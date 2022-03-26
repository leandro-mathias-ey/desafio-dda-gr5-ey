import axios from "axios";

const api = axios.create({
    // baseURL: "https://backend-desafio-dda.azurewebsites.net"
    baseURL: "http://localhost:8080"
});

export { api };