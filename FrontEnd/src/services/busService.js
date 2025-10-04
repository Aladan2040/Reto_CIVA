const API_URL = "http://localhost:8080/bus";
const USER = "admin";
const PASS = "password123";

function authHeader(){
    return {
        Authorization: "Basic " + btoa(`${USER}:${PASS}`),
        "Content-Type": "application/json"
    };
}

export async function getBuses(page = 0, size=10){
    const res = await fetch(`${API_URL}?page=${page}&size=${size}`, {
        headers: authHeader()
    });
    if (!res.ok) throw new Error("Error fetching buses");
    return res.json();
}

export async function getBusById(id){
    const res = await fetch(`${API_URL}/${id}`, {
        headers: authHeader()
    });
    if (!res.ok) throw new Error("Bus not found");
    return res.json();
}