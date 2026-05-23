export default function Soundboard() {
  const sounds = [
    { id: 1, name: 'V12 Startup', desc: 'صوت بدء تشغيل V12' },
    { id: 2, name: 'V10 Revs', desc: 'تسريع V10' },
    { id: 3, name: 'Flyby', desc: 'مرور سريع' },
  ];

  return (
    <div>
      <h2 style={{ color: 'var(--color-gold)' }}>الصوت (Soundboard)</h2>
      <div className="grid">
        {sounds.map((sound) => (
          <div key={sound.id} className="card">
            <h2>{sound.name}</h2>
            <p>{sound.desc}</p>
            <button className="button">تشغيل الصوت (Play)</button>
          </div>
        ))}
      </div>
    </div>
  );
}
