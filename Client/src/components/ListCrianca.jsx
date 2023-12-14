import React, { useState, useEffect } from 'react';
import axios from 'axios';
import AddCrianca from './AddCrianca';

const CriancaList = () => {
  const [criancas, setCriancas] = useState([]);
  const [newCrianca, setNewCrianca] = useState({ nomeCompleto: '', dataDeNascimento: '', status: '' });
  const [editCrianca, setEditCrianca] = useState({ id: null, nomeCompleto: '', dataDeNascimento: '', idDefinicaoDoCabelo: '', idUsuario: '', nomeFantasia: '', status: '' });
  const [message, setMessage] = useState('');

  useEffect(() => {
    fetchCriancas();
  }, []);

  const fetchCriancas = () => {
    axios.get('http://localhost:8080/crianca')
      .then(response => setCriancas(response.data))
      .catch(error => console.error('Error fetching data:', error));
  };

  const createCrianca = () => {
    axios.post('http://localhost:8080/crianca', newCrianca)
      .then(() => {
        fetchCriancas();
        setNewCrianca({ nomeCompleto: '', dataDeNascimento: '', status: '' });
        setMessage('Criança criada com sucesso!');
      })
      .catch(error => console.error('Error creating crianca:', error));
  };

  const updateCrianca = () => {
    axios.put(`http://localhost:8080/crianca/${editCrianca.id}`, editCrianca)
      .then(() => {
        fetchCriancas();
        setEditCrianca({ id: null, nomeCompleto: '', dataDeNascimento: '', idDefinicaoDoCabelo: '', idUsuario: '', nomeFantasia: '', status: '' });
        setMessage('Criança atualizada com sucesso!');
      })
      .catch(error => {
        console.error('Error updating crianca:', error);

        if (error.response) {
          // The request was made, but the server responded with an error status
          setMessage(`Erro ao atualizar criança: ${error.response.data.message}`);
        } else if (error.request) {
          // The request was made, but no response was received
          setMessage('Erro ao atualizar criança. Sem resposta do servidor.');
        } else {
          // Something happened in setting up the request that triggered an Error
          setMessage('Erro ao atualizar criança. Verifique a conexão com a internet ou tente novamente mais tarde.');
        }
      });
  };

  const deleteCrianca = (id) => {
    axios.delete(`http://localhost:8080/crianca/${id}`)
      .then(() => {
        fetchCriancas();
        setMessage('Criança excluída com sucesso!');
      })
      .catch(error => console.error('Error deleting crianca:', error));
  };

  const handleEditClick = (crianca) => {
    setEditCrianca({
      id: crianca.idCrianca,
      nomeCompleto: crianca.nomeCompleto,
      dataDeNascimento: crianca.dataDeNascimento,
      idDefinicaoDoCabelo: crianca.idDefinicaoDoCabelo,
      idUsuario: crianca.idUsuario,
      nomeFantasia: crianca.nomeFantasia,
      status: crianca.status,
    });
  };

  const handleChange = (e) => {
    setEditCrianca({ ...editCrianca, [e.target.name]: e.target.value });
  };

  return (
    <div className="container">
      <h2>Lista de Crianças</h2>
      {message && <p>{message}</p>}
      <AddCrianca onAdd={fetchCriancas} />
      <ul>
        {criancas.map(crianca => (
          <li key={crianca.idCrianca}>
            {crianca.nomeCompleto} - {crianca.dataDeNascimento} - {crianca.status}
            <button onClick={() => handleEditClick(crianca)}>
              Editar
            </button>
            <button onClick={() => deleteCrianca(crianca.idCrianca)}>
              Excluir
            </button>
          </li>
        ))}
      </ul>
      {editCrianca.id && (
        <div className="edit-crianca">
          <h3>Editar Criança</h3>
          <label htmlFor="editNomeCompleto">Nome Completo:</label>
          <input
            type="text"
            id="editNomeCompleto"
            name="nomeCompleto"
            value={editCrianca.nomeCompleto}
            onChange={handleChange}
          />

          <label htmlFor="editDataDeNascimento">Data de Nascimento:</label>
          <input
            type="date"
            id="editDataDeNascimento"
            name="dataDeNascimento"
            value={editCrianca.dataDeNascimento}
            onChange={handleChange}
          />
m 
          <label htmlFor="editDefinicaoDoCabelo">Definição do Cabelo:</label>
          <input
            type="text"
            id="editDefinicaoDoCabelo"
            name="idDefinicaoDoCabelo"
            value={editCrianca.idDefinicaoDoCabelo}
            onChange={handleChange}
          />

          <label htmlFor="editIdUsuario">ID do Usuário:</label>
          <input
            type="text"
            id="editIdUsuario"
            name="idUsuario"
            value={editCrianca.idUsuario}
            onChange={handleChange}
          />

          <label htmlFor="editNomeFantasia">Nome Fantasia:</label>
          <input
            type="text"
            id="editNomeFantasia"
            name="nomeFantasia"
            value={editCrianca.nomeFantasia}
            onChange={handleChange}
          />

          <label htmlFor="editStatus">Status:</label>
          <select
            id="editStatus"
            name="status"
            value={editCrianca.status}
            onChange={handleChange}
          >
            <option value="">Selecione o status</option>
            <option value="Ativo">Ativo</option>
            <option value="Inativo">Inativo</option>
          </select>

          <button onClick={updateCrianca}>Atualizar</button>
        </div>
      )}
    </div>
  );
};

export default CriancaList;