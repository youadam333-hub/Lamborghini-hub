import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import ModelsCatalog from './components/ModelsCatalog';
import QuizGame from './components/QuizGame';
import Soundboard from './components/Soundboard';
import Gallery from './components/Gallery';
import './index.css';

function App() {
  return (
    <Router>
      <div className="app-container">
        <header className="header">
          <h1>Lamborghini Hub (لامبورغيني)</h1>
          <nav>
            <Link to="/">النماذج (Models)</Link>
            <Link to="/gallery">المعرض (Gallery)</Link>
            <Link to="/soundboard">الصوت (Soundboard)</Link>
            <Link to="/quiz">اختبار (Quiz)</Link>
          </nav>
        </header>

        <main className="main-content">
          <Routes>
            <Route path="/" element={<ModelsCatalog />} />
            <Route path="/gallery" element={<Gallery />} />
            <Route path="/soundboard" element={<Soundboard />} />
            <Route path="/quiz" element={<QuizGame />} />
          </Routes>
        </main>
      </div>
    </Router>
  );
}

export default App;
