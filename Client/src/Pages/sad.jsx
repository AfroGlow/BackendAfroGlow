// ListCrianca.js
import React, { useEffect, useState } from 'react';
import axios from 'axios';

const LisstCrianca = () => {
  const [criancas, setCriancas] = useState([]);

  useEffect(() => {
    axios.get('http://localhost:8080/api/criancas')
      .then(response => {
        setCriancas(response.data);
      })
      .catch(error => {
        console.error('Error fetching data:', error);
      });
  }, []);

  return (
    <div>
      <h2>List of Criancas</h2>
      <ul>
        {criancas.map(crianca => (
          <li key={crianca.idCrianca}>{crianca.nomeCompleto}</li>
        ))}
      </ul>
    </div>
  );
};

export default LisstCrianca;