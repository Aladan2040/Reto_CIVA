import React, {useEffect, useState} from 'react';
import {getBuses, getBusById} from "../services/busService";

function BusTable(){
    const [busesPage, setBusesPage] = useState(null);
    const [page, setPage] = useState(0);
    const [size] = useState(10);
    const [loading, setLoading] = useState(false);

    useEffect(() => {
        loadBuses(page);
    }, [page]);

    function loadBuses(pageNumber){
        setLoading(true);
        getBuses(pageNumber,size)
            .then((data) =>{
                setBusesPage(data);
            })
            .catch((err) => {
                console.error(err);
                alert("Error al cargar buses");
            })
            .finally(() => setLoading(false));
    }

    function handleShowDetails(id){
        getBusById(id)
            .then((b) => {
                alert(`Bus ${b.id}\nNumero: ${b.numeroBus}\nPlaca: ${b.placa}\nMarca: ${b.marca?.nombre}\nEstado: ${b.estado}\nCaracteristicas: ${b.caracteristicas}`);
            })
            .catch(() => alert("No se encontro el bus"));
    }

    if (loading) return <div>Cargando....</div>;
    if (!busesPage) return <div>No hay datos</div>;

    return (
        <div>
            <table border="1" cellPadding="8" style={{borderCollapse: "collapse", width: "100%"}}>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Numero</th>
                        <th>Placa</th>
                        <th>Marca</th>
                        <th>Estado</th>
                    </tr>
                </thead>
                <tbody>
                    {busesPage.content.map((bus) => (
                        <tr key={bus.id}>
                            <td>{bus.id}</td>
                            <td>{bus.numeroBus}</td>
                            <td>{bus.placa}</td>
                            <td>{bus.marca?.nombre}</td>
                            <td>{bus.estado ? "True" : "False"}</td>
                            <td>
                                <button onClick={() => handleShowDetails(bus.id)}>Ver</button>
                            </td>
                        </tr>
                        ))}
                </tbody>
            </table>

            <div style={{ marginTop: 12}}>
                <button onClick={() => setPage((p) => Math.max(0, p - 1))} disabled={page === 0}>
                    Anterior
                </button>
                <span style={{margin: "0 10px"}}>Pagina: {busesPage.number + 1} / {busesPage.totalPages}</span>
                <button onClick={() => setPage((p) => (p+1 < busesPage.totalPages ? p + 1 : p))} disabled={busesPage.number + 1 === busesPage.totalPages}>
                    Siguiente
                </button>
            </div>
        </div>
    );
}

export default BusTable;