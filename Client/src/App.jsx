

import { BrowserRouter as Router, Route,  Routes, Link } from 'react-router-dom';
import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './App.css';
// import Crianca from './Pages/Crianca';
import ListCrianca from './components/ListCrianca';
import AddCrianca from './components/AddCrianca';
import EditCrianca from './components/EditCrianca';
import BoxList from './components/BoxList';
import Login from './Pages/Login/Login';

const App = () => {


 


  const [isLoggedIn, setIsLoggedIn] = useState(false);

  useEffect(() => {
    // Check user's authentication status on component mount
    checkAuthenticationStatus();
  }, []);

  const checkAuthenticationStatus = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/check-auth', {
        headers: {
          Authorization: `Bearer ${localStorage.getItem('token')}`,
        },
      });
      setIsLoggedIn(response.data.isAuthenticated);
    } catch (error) {
      console.error('Error checking authentication status:', error);
    }
  };

  const handleLogout = () => {
    // Implement logout logic here
    // Clear token from local storage and update state
    localStorage.removeItem('token');
    setIsLoggedIn(false);
  };
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

          {isLoggedIn ? (
          <li>
          <Link to="/login" onClick={handleLogout}>Sair </Link>
          </li>
        ) : (
          <li> <Link to="/login"> Entrar </Link></li>
        )}
        </ul>
      </nav>

      <hr />

      <Routes>
   
      <Route path="/boxlist" element={<BoxList />} />
        <Route path="/list" element={<ListCrianca />} />
        <Route path="/add" element={<AddCrianca />} />
        <Route path="/edit" element={<EditCrianca />} />
        <Route path="/login" element={<Login />} />
      </Routes>
    </div>
  </Router>
  );
}

export default App;