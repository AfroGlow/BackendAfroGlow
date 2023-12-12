import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './Crianca.css';

const API_BASE_URL = 'ec2-35-175-211-209.compute-1.amazonaws.com:8080/api/criancas';

const Crianca = () => {
  const [criancas, setCriancas] = useState([]);
  const [nomeCompleto, setNomeCompleto] = useState('');
  const [nomeFantasia, setNomeFantasia] = useState('');
  const [dataDeNascimento, setDataDeNascimento] = useState('');
  const [status, setStatus] = useState('');

  useEffect(() => {
    fetchCriancas();
  }, []);

  const fetchCriancas = async () => {
    try {
      const response = await axios.get(API_BASE_URL);
      setCriancas(response.data);
    } catch (error) {
      console.error('Error fetching data:', error);
    }
  };

  const handleCreateCrianca = async () => {
    try {
      await axios.post(API_BASE_URL, {
        nomeCompleto,
        nomeFantasia,
        dataDeNascimento,
        status,
      });
      fetchCriancas();
    } catch (error) {
      console.error('Error creating crianca:', error);
    }
  };

  return (
    <div className="App">
      <h1>CRUD de Criancas</h1>

      <div>
        <h2>Listagem de Criancas</h2>
        <ul>
          {criancas.map(crianca => (
            <li key={crianca.idCrianca}>
              {crianca.nomeCompleto} - {crianca.status}
            </li>
          ))}
        </ul>
      </div>

      <div>
        <h2>Criar Nova Crianca</h2>
        <form>
          <label>
            Nome Completo:
            <input
              type="text"
              value={nomeCompleto}
              onChange={e => setNomeCompleto(e.target.value)}
            />
          </label>
          <br />
          <label>
            Nome Fantasia:
            <input
              type="text"
              value={nomeFantasia}
              onChange={e => setNomeFantasia(e.target.value)}
            />
          </label>
          <br />
          <label>
            Data de Nascimento:
            <input
              type="date"
              value={dataDeNascimento}
              onChange={e => setDataDeNascimento(e.target.value)}
            />
          </label>
          <br />
          <label>
            Status:
            <input
              type="text"
              value={status}
              onChange={e => setStatus(e.target.value)}
            />
          </label>
          <br />
          <button type="button" onClick={handleCreateCrianca}>
            Criar Crianca
          </button>
        </form>
      </div>
    </div>
  );
};

export default Crianca;
