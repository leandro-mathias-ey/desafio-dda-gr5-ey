import React, { useEffect, useState } from "react";
import "./Home.css";
import CardRow from "./CardRow";
import SearchBar from "./searchBar";
import { api } from "../services/api";

const Home = () => {

  const [herois, setHerois] = useState([]);
  useEffect(() => {
    api.get('/heroes').then(response => setHerois(response.data.content));
  }, []);

  return (
    <div>
      <SearchBar />
      <div id="cardRowAlign">
        <CardRow data={herois}/>
      </div>
    </div>
  );
};

export default Home;
