import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '/node_modules/bootstrap/dist/js/bootstrap.min.js'
import './App.css';
import KorisnikView from './component/korisnik/KorisnikView';
import HomePage from './HomePage';
import NavBar from './component/korisnik/NavBar';

function App() {
  return (
    <div className="App">
        <h2>Welcome to my website</h2>
        <HomePage />
        <NavBar />
        <KorisnikView />
    </div>
  );
}

export default App;
