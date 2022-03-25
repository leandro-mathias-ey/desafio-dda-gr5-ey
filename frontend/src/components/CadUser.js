import "../App.css";
import { Form, FormGroup, Button, Col, Row } from "react-bootstrap";
import { useState } from "react";
import { api } from "../services/api";
import { useNavigate } from "react-router-dom"

const CadUser = () => {

  const navigate = useNavigate();

  const [nome, setNome] = useState('');
  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');
  const [username, setUsername] = useState('');

  const handlerSubmitCreate = async(e) => {
      e.preventDefault();
    let createUser = await api.post('/user/create', {
        nome,
        email,
        senha,
        username,
    }).then(() => {
        alert('Usuário criado!');
        navigate("/login");
    });
  }

  return (
    <div id="squareSearch">
      <Form>
        <FormGroup controlId="formBasicNome">
          <Form.Label>Nome</Form.Label>
          <Form.Control type="text" placeholder="Nome" value={nome} onChange={(e) => setNome(e.target.value)} />
        </FormGroup>
        <FormGroup controlId="formBasicUsername">
          <Form.Label>Username</Form.Label>
          <Form.Control type="text" placeholder="Username" value={username} onChange={(e) => setUsername(e.target.value)} />
        </FormGroup>
        <FormGroup className="mb-1" controlId="formBasicEmail">
          <Form.Label>E-mail</Form.Label>
          <Form.Control type="email" placeholder="E-mail" value={email} onChange={(e) => setEmail(e.target.value)} />
        </FormGroup>
        <FormGroup className="mb-1" controlId="formBasicPassword">
          <Form.Label>Senha</Form.Label>
          <Form.Control type="password" placeholder="Senha" value={senha} onChange={(e) => setSenha(e.target.value)} />
        </FormGroup>
        <Row>
          <Col>
            <Button type="submit" variant="outline-light" size="sm">
              Cancelar
            </Button>
          </Col>
          <Col>
            <Button variant="outline-light" size="sm" onClick={(e) => handlerSubmitCreate(e)}>
              Criar Usuário
            </Button>
          </Col>
        </Row>
      </Form>
    </div>
  );
};
export default CadUser;