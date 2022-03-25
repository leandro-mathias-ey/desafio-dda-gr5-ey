import React, { useEffect, useState } from "react";
import { api } from "../services/api";
import { Form, Button, Row, Col } from "react-bootstrap";
import { useNavigate } from "react-router-dom"
import "./AddHero.css";

const AddHero = () => {

const navigate = useNavigate();

const [nome, setNome] = useState('')

const [poderes, setPoderes] = useState([]);
const [universos, setUniversos] = useState([]);

const [selectedUniverso, setSelectedUniverso] = useState('')
const [selectedPoder, setSelectedPoder] = useState([])

  useEffect(() => {
    api.get('heroes/poderes').then(response => {
      const getPoderes = response.data.content.map(resPoder => resPoder.poder);
      setPoderes(getPoderes);
    })
  }, []);

  useEffect(async () => {
    const { data } = await api.get('heroes/universos');
    setUniversos(data.content);    
  }, []);

  const handlerSelectPoder = (e) => {
    const poder = e.target.value;

    setSelectedPoder(poder)
  }

  const handlerSelectUniverso = (e) => {
    const universo = e.target.value;
    setSelectedUniverso(universo)
  }

  const handleSubmit = async (e) => {

    const data = JSON.stringify({
      nomeHeroi: nome,
      universoId: selectedUniverso,
      usuarioId: "fc0e1dbc-227e-4ac2-9ebd-b8a515182fd6"
    })

    let createHeroi = await api.post('heroes/create', data, {
      headers: {
        'Content-Type': 'application/json'
      }
    }).then(() => {
      alert('Heroi criado!');
      navigate("/");
    });
  };

  return (
    <div>
      <div id="squareSearch">
        <h1 id="textColor">Adicionar Heróis</h1>
        <Form
          onSubmit={() => {
            handleSubmit();
          }}
        >
          <Row className="mb-3">
            <Col>
              <Form.Control
                placeholder="Nome do Herói"
                value={nome}
                onChange={(e) => setNome(e.target.value)}
              />
            </Col>
            <Col>
              <Form.Select
                placeholder="Poder do Herói"
                name="poder"
                value={selectedPoder}
                onChange={handlerSelectPoder}
              >
                <option value="">Selecione os poderes</option>
                {poderes.map((item, i) => <option key={i} value={item}>{item}</option>)}
              </Form.Select>
            </Col>
          </Row>
          <Row>
            <Col>
              <Form.Select
                placeholder="Universo"
                name="universo"
                value={selectedUniverso}
                onChange={handlerSelectUniverso}
              >
                <option value="">Selecione o universo</option>
                {universos.map((item) => <option key={item.universoId} value={item.universoId}>{item.universo}</option>)}
              </Form.Select>
            </Col>
          </Row>
        </Form>
      </div>
      <div id="padding">
        <Button variant="outline-light" onClick={() => handleSubmit()}>Adicionar Herói</Button>
      </div>
    </div>
  );
};

export default AddHero;
