import { useState } from 'react';

export default function QuizGame() {
  const [score, setScore] = useState(0);

  return (
    <div>
      <h2 style={{ color: 'var(--color-gold)' }}>اختبار (Quiz Game)</h2>
      <div className="card">
        <h3>في أي عام تأسست لامبورغيني؟ (When was Lamborghini founded?)</h3>
        <div style={{ display: 'flex', gap: '1rem', marginTop: '1rem' }}>
          <button className="button" onClick={() => alert('خطأ')}>1950</button>
          <button className="button" onClick={() => setScore(score + 1)}>1963</button>
          <button className="button" onClick={() => alert('خطأ')}>1970</button>
        </div>
        <p style={{ marginTop: '2rem' }}>النقاط: {score}</p>
      </div>
    </div>
  );
}
