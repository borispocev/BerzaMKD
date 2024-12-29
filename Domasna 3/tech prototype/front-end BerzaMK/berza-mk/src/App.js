import '../node_modules/bootstrap/dist/css/bootstrap.min.css'
import '/node_modules/bootstrap/dist/js/bootstrap.min.js'
import './App.css';
import KorisnikView from './component/korisnik/KorisnikView';
import HomePage from './HomePage';
import NavBar from './component/korisnik/NavBar';
import Exchange from './component/korisnik/exchange';
import { Route, Routes} from "react-router-dom";
import { computeHeadingLevel } from '@testing-library/react';
import CompanyDropdown from './component/korisnik/CompanyDropdown';
import DataTable2 from './component/korisnik/AnalizaView';


function App() {
  let component
  switch(window.location.pathname){
    case "/news":
      component = <HomePage/>
      break
    case "/dashboard":
      component = <KorisnikView/>
      break
    case "/login":
      component = <CompanyDropdown />
      break
  }
  return (
    <div className="App">
        <NavBar />
        {component}
    </div>
  );
}

export default App;
