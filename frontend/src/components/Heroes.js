import React, { useEffect, useState } from "react";
import { Table, Button } from "react-bootstrap";
import SearchBar from "./searchBar";
import { api } from "../services/api";
import moment from 'moment';

const Heroes = () => {

  moment.locale('pt-br'); 

  const [herois, setHerois] = useState([]);
  useEffect(() => {
    api.get("/heroes").then(response => {
      setHerois(response.data.content)
    })
  }, []);

  function handleSubmitUpdate(e) {
    e.preventDefault();
    alert("Update");
  }
  function handleSubmitDelete(e) {
    e.preventDefault();
    alert("Delete");
  }

  return (
    <div>
      <SearchBar />
      <Table striped bordered hover variant="dark">
        <thead>
          <tr>
            <th id="whiteTxt">Nome</th>
            <th>Poder</th>
            <th>Universo</th>
            <th>Data de cadastro</th>
          </tr>
        </thead>
        <tbody>
          {herois.map((item) => 
          <tr>
            <td>{item.nomeHeroi}</td>
            <td>hero_power</td>
            <td>{item.universoId}</td>
            <td>{moment(item.createdAt).format('D MMMM YYYY')}</td>
            <td id="margin">
              <form onSubmit={handleSubmitUpdate}>
                <Button type="submit" variant="outline-light" size="sm">
                  Alterar
                </Button>
              </form>
            </td>
            <td id="margin">
              <form onSubmit={handleSubmitDelete}>
                <Button type="submit" variant="outline-light" size="sm">
                  Deletar
                </Button>
              </form>
            </td>
          </tr>)}
        </tbody>
      </Table>
    </div>
  );
};

export default Heroes;
