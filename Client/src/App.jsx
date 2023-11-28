
import React from 'react';
import { BrowserRouter as Router, Route,  Routes, Link } from 'react-router-dom';

import './App.css';
// import Crianca from './Pages/Crianca';
import ListCrianca from './components/ListCrianca';
import AddCrianca from './components/AddCrianca';
import EditCrianca from './components/EditCrianca';
import BoxList from './components/BoxList';

function App() {
  return (
    <Router>
    <div className="container">
      <nav>
        <ul>
          <li>
            <Link to="/list">Listar Crianças</Link>
          </li>
          <li>
            <Link to="/add">Adicionar Criança</Link>
            
          </li>
       

          <li>
            <Link to="/boxlist">box list</Link>
            
          </li>
        </ul>
      </nav>

      <hr />

      <Routes>
   
      <Route path="/boxlist" element={<BoxList />} />
        <Route path="/list" element={<ListCrianca />} />
        <Route path="/add" element={<AddCrianca />} />
        <Route path="/edit" element={<EditCrianca />} />
      </Routes>
    </div>
  </Router>
  );
}

export default App;