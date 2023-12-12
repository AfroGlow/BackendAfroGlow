import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './app.css'

function App() {
  const [boxes, setBoxes] = useState([]);
  const [newBox, setNewBox] = useState({ tipoDeBox: 0, descricao: '', preco: 0 });

  useEffect(() => {
    loadBoxes();
  }, []);

  const loadBoxes = async () => {
    try {
      const response = await axios.get('http://localhost:8080/api/boxes');
      setBoxes(response.data);
    } catch (error) {
      console.error('Erro ao carregar caixas', error);
    }
  };

  const saveBox = async () => {
    try {
      await axios.post('http://localhost:8080/api/boxes', newBox);
      setNewBox({ tipoDeBox: 0, descricao: '', preco: 0 });
      loadBoxes();
    } catch (error) {
      console.error('Erro ao salvar caixa', error);
    }
  };

  const deleteBox = async (id) => {
    try {
      await axios.delete(`http://localhost:8080/api/boxes/${id}`);
      loadBoxes();
    } catch (error) {
      console.error('Erro ao deletar caixa', error);
    }
  };

  return (
    <div>
      <h1>GlowBox!</h1>
      <ul>
        {boxes.map((box) => (
          <li key={box.id}>
            {box.descricao} - R${box.preco}{' '}
            <button onClick={() => deleteBox(box.id)}>Deletar</button>
          </li>
        ))}
      </ul>
      <h2>Nova Box</h2>
      <label>
        Tipo de Box:
        <input
          type="number"
          value={newBox.tipoDeBox}
          onChange={(e) => setNewBox({ ...newBox, tipoDeBox: e.target.value })}
        />
      </label>
      <br />
      <label>
        Descrição:
        <input
          type="text"
          value={newBox.descricao}
          onChange={(e) => setNewBox({ ...newBox, descricao: e.target.value })}
        />
      </label>
      <br />
      <label>
        Preço:
        <input
          type="number"
          value={newBox.preco}
          onChange={(e) => setNewBox({ ...newBox, preco: e.target.value })}
        />
      </label>
      <br />
      <button onClick={saveBox}>Salvar</button>
    </div>
  );
}

export default App;