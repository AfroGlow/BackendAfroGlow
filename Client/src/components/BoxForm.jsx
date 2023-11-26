import React, { useState, useEffect } from 'react';
import axios from 'axios';

const BoxForm = ({ setEditing, setBoxToEdit, boxes, setBoxes }) => {
  const [formData, setFormData] = useState({
    tipoDeBox: '',
    descricao: '',
    preco: '',
  });
  const [submitting, setSubmitting] = useState(false);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setFormData((prevData) => ({ ...prevData, [name]: value }));
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
  
    try {
      setSubmitting(true);
  
      if (formData.tipoDeBox && formData.descricao && formData.preco) {
        if (formData.id) {
          await axios.put(`http://localhost:8080/api/boxes/${formData.id}`, formData);
          const updatedBoxes = boxes.map((box) => (box.id === formData.id ? formData : box));
          setBoxes(updatedBoxes);
          setEditing(false);
          setBoxToEdit(null);
        } else {
          const response = await axios.post('http://localhost:8080/api/boxes', formData);
          setBoxes([...boxes, response.data]);
        }
  
        setFormData({ tipoDeBox: '', descricao: '', preco: '' });
      }
    } catch (error) {
      console.error('Erro ao salvar caixa:', error.message);
    } finally {
      setSubmitting(false);
    }
  };

  useEffect(() => {
    if (setBoxToEdit) {
      setFormData({
        id: setBoxToEdit.id,
        tipoDeBox: setBoxToEdit.tipoDeBox,
        descricao: setBoxToEdit.descricao,
        preco: setBoxToEdit.preco,
      });
    }

    // Cleanup function
    return () => {
      setFormData({ tipoDeBox: '', descricao: '', preco: '' });
    };
  }, [setBoxToEdit]);

  return (
    <div className="box-form">
      <h2>Formulário de Caixa</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Tipo de Box:
          <input
            type="text"
            name="tipoDeBox"
            value={formData.tipoDeBox}
            onChange={handleChange}
          />
        </label>
        <label>
          Descrição:
          <input
            type="text"
            name="descricao"
            value={formData.descricao}
            onChange={handleChange}
          />
        </label>
        <label>
          Preço:
          <input
            type="number"
            name="preco"
            value={formData.preco}
            onChange={handleChange}
          />
        </label>
        <button type="submit" disabled={submitting}>
          {submitting ? 'Salvando...' : 'Salvar'}
        </button>
      </form>
    </div>
  );
};

export default BoxForm;
