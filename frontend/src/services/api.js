import axios from "axios";

const api = axios.create({
    baseURL: "https://backend-desafio-dda.azurewebsites.net"
});

export { api };