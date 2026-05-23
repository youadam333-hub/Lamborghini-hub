export default function Gallery() {
  const images = [
    { id: 1, url: 'https://images.unsplash.com/photo-1621007947382-bb3c3994e3fd', title: 'Revuelto' },
    { id: 2, url: 'https://images.unsplash.com/photo-1544829099-b152342c8d20', title: 'Aventador' },
    { id: 3, url: 'https://images.unsplash.com/photo-1614200179396-2bdb77ebf81b', title: 'Huracan' },
  ];

  return (
    <div>
      <h2 style={{ color: 'var(--color-gold)' }}>المعرض (Gallery)</h2>
      <div className="grid">
        {images.map((img) => (
          <div key={img.id} className="card" style={{ padding: 0, overflow: 'hidden' }}>
            <img src={`${img.url}?auto=format&fit=crop&w=600&q=80`} alt={img.title} style={{ width: '100%', height: '200px', objectFit: 'cover' }} />
            <h3 style={{ padding: '1rem', margin: 0, color: 'var(--color-gold)' }}>{img.title}</h3>
          </div>
        ))}
      </div>
    </div>
  );
}
