import React, { useState, useEffect } from 'react';
import axios from 'axios';

const EditCrianca = ({ id, onCancel, onUpdate }) => {
  const [crianca, setCrianca] = useState({
    dataDeNascimento: '',
    idDefinicaoDoCabelo: '',
    idUsuario: '',
    nomeCompleto: '',
    nomeFantasia: '',
    status: '',
  });

  const [loading, setLoading] = useState(true);
  const [error, setError] = useState('');
  const [successMessage, setSuccessMessage] = useState('');

  useEffect(() => {
    let isMounted = true;
  
    const fetchData = async () => {
      try {
        const response = await axios.get(`http://localhost:8080/api/crianca`);
        if (isMounted) {
          setCrianca(response.data);
          setLoading(false);
        }
      } catch (error) {
        if (isMounted) {
          console.error('Erro ao buscar dados da criança:', error);
          setError('Erro ao buscar dados da criança');
          setLoading(false);
        }
      }
    };
  
    fetchData();
  
    return () => {
      isMounted = false;
    };
  }, [id]);

  const handleChange = (e) => {
    setCrianca({ ...crianca, [e.target.name]: e.target.value });
  };

  const handleUpdate = async (e) => {
    e.preventDefault();

    try {
     

      await axios.put(`ec2-35-175-211-209.compute-1.amazonaws.com/api/crianca/${id}`, crianca);
      setSuccessMessage('Criança atualizada com sucesso');
      onUpdate();
    } catch (error) {
      console.error('Erro ao atualizar criança:', error);
      setError('Erro ao atualizar criança. Verifique os dados e tente novamente.');
    }
  };

  return (
    <div>
      <h2>Editar Criança</h2>
      {loading && <p>Carregando dados...</p>}
      {error && <p style={{ color: 'red' }}>{error}</p>}
      {successMessage && <p style={{ color: 'green' }}>{successMessage}</p>}
      {!loading && !error && (
        <form onSubmit={handleUpdate}>
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
            Nome Fantasia:
            <input
              type="text"
              name="nomeFantasia"
              value={crianca.nomeFantasia}
              onChange={handleChange}
            />
          </label>
       
      
          <button type="submit">Atualizar</button>
          <button type="button" onClick={onCancel}>
            Cancelar
          </button>
        </form>
      )}
    </div>
  );
};

export default EditCrianca;
