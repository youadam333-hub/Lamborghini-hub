export default function ModelsCatalog() {
  const models = [
    { id: 1, name: 'Revuelto', year: 2023, hp: 1015 },
    { id: 2, name: 'Aventador SVJ', year: 2018, hp: 770 },
    { id: 3, name: 'Huracán STO', year: 2020, hp: 640 },
    { id: 4, name: 'Countach LPI 800-4', year: 2021, hp: 814 },
  ];

  return (
    <div>
      <h2 style={{ color: 'var(--color-gold)' }}>النماذج (Models Catalog)</h2>
      <div className="grid">
        {models.map((model) => (
          <div key={model.id} className="card">
            <h2>{model.name}</h2>
            <p>السنة (Year): {model.year}</p>
            <p>قوة الحصان (HP): {model.hp} CV</p>
          </div>
        ))}
      </div>
    </div>
  );
}
