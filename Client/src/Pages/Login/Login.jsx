// src/Login.js

import React, { useState } from 'react';
import axios from 'axios';

const Login = ({ handleLogin }) => {
  const [username, setUsername] = useState('');
  const [password, setPassword] = useState('');

  const handleFormSubmit = async (e) => {
    e.preventDefault();

    try {
      // Faça uma requisição para o backend para autenticação
      const response = await axios.post('http://localhost:8080/api/user/login', {
        username,
        password,
      });

      // Salve o token no localStorage
      localStorage.setItem('token', response.data.token);

      // Atualize o estado para indicar que o usuário está logado
      handleLogin();
    } catch (error) {
      console.error('Erro durante o login:', error);
    }
  };

  return (
    <div>
      <h2>Login</h2>
      <form onSubmit={handleFormSubmit}>
        <label>
          usuario:
          <input type="text" value={username} onChange={(e) => setUsername(e.target.value)} />
        </label>
        <br />
        <label>
          Senha:
          <input type="password" value={password} onChange={(e) => setPassword(e.target.value)} />
        </label>
        <br />
        <button type="submit">Login</button>
      </form>
    </div>
  );
};

export default Login;
