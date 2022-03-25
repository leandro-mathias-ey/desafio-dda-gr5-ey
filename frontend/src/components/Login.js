import React, { useState } from "react";
import { api } from "../services/api";
import { Form, Button } from "react-bootstrap";

const Login = () => {

  const [email, setEmail] = useState('');
  const [senha, setSenha] = useState('');

   async function handlerLogin(e) {
    e.preventDefault();
    await api.post('login', {
      email,
      senha
    }).then(response => {
      window.localStorage.setItem('email', email);
    })
  }

  console.log(window.localStorage.getItem('email'))

  return (
    <div id="squareSearch">
      <Form>
        <Form.Group className="mb-3">
          <Form.Control type="email" placeholder="name@example.com" value={email} onChange={(e) => setEmail(e.target.value)} />
        </Form.Group>
        <Form.Group className="mb-3">
          <Form.Control type="password" placeholder="Password" value={senha} onChange={(e) => setSenha(e.target.value)} />
        </Form.Group>
      </Form>
      <form onSubmit={handlerLogin}>
        <Button type="submit" variant="outline-light">Login</Button>
      </form>
      <br />
      <br />
    </div>
  );
};

export default Login;
