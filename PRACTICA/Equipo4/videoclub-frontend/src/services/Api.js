import axios from "axios";

export default (URL) => {

    const InstanceAxios = axios.create({
        baseURL: URL
    })

    var token = localStorage.getItem('token');

    if (token) {
        InstanceAxios.defaults.headers.common.Authorization = `Bearer ${token}`;
    }

    return InstanceAxios;
}