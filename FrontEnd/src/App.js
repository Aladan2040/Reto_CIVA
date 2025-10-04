import React from "react";
import BusTable from "./components/BusTable";

function App() {
    return (
        <div style={{ padding: "20px", fontFamily: "Arial, sans-serif" }}>
            <h1>Lista de Buses</h1>
            <BusTable />
        </div>
    );
}

export default App;