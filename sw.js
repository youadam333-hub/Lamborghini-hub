const CACHE_NAME = 'lambo-hub-cache-v1';
const APP_SHELL_URLS = [
  '/',
  '/index.html',
  '/manifest.json' // Include other static assets (CSS, fallback images) here
];

// Install Event: Cache App Shell
self.addEventListener('install', (event) => {
  self.skipWaiting();
  event.waitUntil(
    caches.open(CACHE_NAME).then((cache) => {
      console.log('[Service Worker] Caching App Shell');
      return cache.addAll(APP_SHELL_URLS);
    })
  );
});

// Activate Event: Cleanup Old Caches
self.addEventListener('activate', (event) => {
  event.waitUntil(
    caches.keys().then((cacheNames) => {
      return Promise.all(
        cacheNames.map((cache) => {
          if (cache !== CACHE_NAME) {
            console.log('[Service Worker] Deleting old cache:', cache);
            return caches.delete(cache);
          }
        })
      );
    })
  );
  self.clients.claim();
});

// Fetch Event: Stale-While-Revalidate for static assets, Network-First for videos/reels
self.addEventListener('fetch', (event) => {
  const { request } = event;

  // Network-First strategy for media & API (Reels, videos, dynamic data)
  if (request.destination === 'video' || request.destination === 'audio' || request.url.includes('/api/')) {
    event.respondWith(
      fetch(request)
        .catch(() => {
          // Fallback to cache if network fails (e.g., offline)
          return caches.match(request);
        })
    );
    return;
  }

  // Stale-While-Revalidate for App Shell, HTML, CSS, JS, and Images
  event.respondWith(
    caches.match(request).then((cachedResponse) => {
      if (cachedResponse) {
        // Fetch in background to update cache for next time
        fetch(request).then((networkResponse) => {
          if (networkResponse && networkResponse.status === 200) {
            caches.open(CACHE_NAME).then((cache) => {
              cache.put(request, networkResponse.clone());
            });
          }
        }).catch(() => { /* Ignore background network errors */ });
        
        return cachedResponse;
      }
      
      // If not in cache, fetch from network and cache it
      return fetch(request).then((networkResponse) => {
        if (networkResponse && networkResponse.status === 200 && networkResponse.type === 'basic') {
          const responseToCache = networkResponse.clone();
          caches.open(CACHE_NAME).then((cache) => {
            cache.put(request, responseToCache);
          });
        }
        return networkResponse;
      });
    })
  );
});
