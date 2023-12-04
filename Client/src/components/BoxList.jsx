import React, { useEffect, useState } from 'react';
import axios from 'axios';

const BoxList = () => {
    const [boxes, setBoxes] = useState([]);
    const [newBox, setNewBox] = useState({ tipoDeBox: '', preco: 0, qtdDeProdutos: 0 });
    const [editBox, setEditBox] = useState({ id: null, tipoDeBox: '', preco: 0, qtdDeProdutos: 0 });
    const [message, setMessage] = useState('');
  
    useEffect(() => {
      fetchBoxes();
    }, []);
  
    const fetchBoxes = () => {
      axios.get('ec2-35-175-211-209.compute-1.amazonaws.com:8080/api')
        .then(response => setBoxes(response.data))
        .catch(error => console.error('Error fetching data:', error));
    };
  
    const createBox = () => {
      axios.post('ec2-35-175-211-209.compute-1.amazonaws.com:8080/api', newBox)
        .then(() => {
          fetchBoxes();
          setNewBox({ tipoDeBox: '', preco: 0, qtdDeProdutos: 0 });
          setMessage('Caixa criada com sucesso!');
        })
        .catch(error => console.error('Error creating box:', error));
    };
  
    const updateBox = () => {
      axios.put(`ec2-35-175-211-209.compute-1.amazonaws.com/api/${editBox.id}`, editBox)
        .then(() => {
          fetchBoxes();
          setEditBox({ id: null, tipoDeBox: '', preco: 0, qtdDeProdutos: 0 });
          setMessage('Caixa atualizada com sucesso!');
        })
        .catch(error => console.error('Error updating box:', error));
    };
  
    const deleteBox = (id) => {
      axios.delete(`ec2-35-175-211-209.compute-1.amazonaws.com/api/${id}`)
        .then(() => {
          fetchBoxes();
          setMessage('Caixa excluída com sucesso!');
        })
        .catch(error => console.error('Error deleting box:', error));
    };
  
    const handleEditClick = (caixa) => {
      setEditBox({ id: caixa.idBox, tipoDeBox: caixa.tipoDeBox, preco: caixa.preco, qtdDeProdutos: caixa.qtdDeProdutos });
    };
  
    return (
      <div className="container">
        <h2>Lista de Caixas</h2>
        {message && <p>{message}</p>}
        <ul>
          {boxes.map(caixa => (
            <li key={caixa.idBox}>
              {caixa.tipoDeBox} - {caixa.preco} - {caixa.qtdDeProdutos}
              <button onClick={() => handleEditClick(caixa)}>
                Editar
              </button>
              <button onClick={() => deleteBox(caixa.idBox)}>
                Excluir
              </button>
            </li>
          ))}
        </ul>
        <div className="create-box">
          <h3>Criar Nova Caixa</h3>
          <label htmlFor="tipoDeBox">Tipo</label>
          <input
            type="text"
            id="tipoDeBox"
            placeholder="Digite o tipo da caixa"
            value={newBox.tipoDeBox}
            onChange={(e) => setNewBox({ ...newBox, tipoDeBox: e.target.value })}
          />
          <label htmlFor="preco">Preço</label>
          <input
            type="number"
            id="preco"
            placeholder="Digite o preço da caixa"
            value={newBox.preco}
            onChange={(e) => setNewBox({ ...newBox, preco: e.target.value })}
          />
          <label htmlFor="qtdDeProdutos">Quantidade</label>
          <input
            type="number"
            id="qtdDeProdutos"
            placeholder="Digite a quantidade de produtos"
            value={newBox.qtdDeProdutos}
            onChange={(e) => setNewBox({ ...newBox, qtdDeProdutos: e.target.value })}
          />
          <button onClick={createBox}>Criar</button>
        </div>
        {editBox.id && (
          <div className="edit-box">
            <h3>Editar Caixa</h3>
            <label htmlFor="editTipoDeBox">Tipo</label>
            <input
              type="text"
              id="editTipoDeBox"
              placeholder="Digite o tipo da caixa"
              value={editBox.tipoDeBox}
              onChange={(e) => setEditBox({ ...editBox, tipoDeBox: e.target.value })}
            />
            <label htmlFor="editPreco">Preço</label>
            <input
              type="number"
              id="editPreco"
              placeholder="Digite o preço da caixa"
              value={editBox.preco}
              onChange={(e) => setEditBox({ ...editBox, preco: e.target.value })}
            />
            <label htmlFor="editQtdDeProdutos">Quantidade</label>
            <input
              type="number"
              id="editQtdDeProdutos"
              placeholder="Digite a quantidade de produtos"
              value={editBox.qtdDeProdutos}
              onChange={(e) => setEditBox({ ...editBox, qtdDeProdutos: e.target.value })}
            />
            <button onClick={updateBox}>Atualizar</button>
          </div>
        )}
      </div>
    );
  };
  
  export default BoxList;