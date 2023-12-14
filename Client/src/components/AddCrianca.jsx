import React, { useState } from 'react';
import axios from 'axios';

const AddCrianca = ({ onAdd }) => {
  const [crianca, setCrianca] = useState({
    dataDeNascimento: '',
    idDefinicaoDoCabelo: '',
    idUsuario: '',
    nomeCompleto: '',
    nomeFantasia: '',
    status: '',
  });

  const [error, setError] = useState('');
  const [success, setSuccess] = useState('');

  const handleChange = (e) => {
    setCrianca({ ...crianca, [e.target.name]: e.target.value });
  };

  const handleSubmit = (e) => {
    e.preventDefault();

    // Validar o formulário
    if (!crianca.nomeCompleto || !crianca.dataDeNascimento || !crianca.status) {
      setError('Preencha todos os campos obrigatórios.');
      return;
    }

    axios.post('http://localhost:8080/crianca', crianca)
      .then(response => {
        console.log('Criança adicionada:', response.data);
        setSuccess('Criança adicionada com sucesso.');
        setError('');
        onAdd();
        // Limpar o formulário
        setCrianca({
          dataDeNascimento: '',
          idDefinicaoDoCabelo: '',
          idUsuario: '',
          nomeCompleto: '',
          nomeFantasia: '',
          status: '',
        });
      })
      .catch(error => {
        console.error('Erro ao adicionar criança:', error);
        setError('Erro ao adicionar criança. Verifique os dados e tente novamente.');
        setSuccess('');
      });
  };

  return (
    <div>
      <h2>Adicionar Criança</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Nome Completo:
          <input
            type="text"
            name="nomeCompleto"
            value={crianca.nomeCompleto}
            onChange={handleChange}
          />
        </label>

        <label>
          Data de Nascimento:
          <input
            type="date"
            name="dataDeNascimento"
            value={crianca.dataDeNascimento}
            onChange={handleChange}
          />
        </label>

        <label>
          Definição do Cabelo:
          <input
            type="text"
            name="idDefinicaoDoCabelo"
            value={crianca.idDefinicaoDoCabelo}
            onChange={handleChange}
          />
        </label>

        <label>
          ID do Usuário:
          <input
            type="text"
            name="idUsuario"
            value={crianca.idUsuario}
            onChange={handleChange}
          />
        </label>

        <label>
          Nome Fantasia:
          <input
            type="text"
            name="nomeFantasia"
            value={crianca.nomeFantasia}
            onChange={handleChange}
          />
        </label>

        <label>
          Status:
          <select
            name="status"
            value={crianca.status}
            onChange={handleChange}
          >
            <option value="">Selecione o status</option>
            <option value="Ativo">Ativo</option>
            <option value="Inativo">Inativo</option>
          </select>
        </label>

        <button type="submit">Adicionar</button>
      </form>
    </div>
  );
};

export default AddCrianca;