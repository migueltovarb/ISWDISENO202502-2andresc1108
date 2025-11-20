const express = require('express');
const fs = require('fs');
const app = express();
app.use(express.json());

const FILE_PATH = './vehiculos.json';

// Cargar vehículos desde archivo o iniciar con default
let vehiculos = [];
if (fs.existsSync(FILE_PATH)) {
  const data = fs.readFileSync(FILE_PATH, 'utf8');
  vehiculos = JSON.parse(data);
} else {
  vehiculos = [
    { id: 1, marca: "Toyota", modelo: "Corolla", anio: 2020, placa: "ABC123" },
    { id: 2, marca: "Mazda", modelo: "3", anio: 2022, placa: "XYZ789" },
    { id: 3, marca: "Honda", modelo: "Civic", anio: 2021, placa: "DEF456" },
    { id: 4, marca: "Ford", modelo: "Focus", anio: 2019, placa: "GHI012" },
    { id: 5, marca: "Chevrolet", modelo: "Cruze", anio: 2023, placa: "JKL345" }
  ];
  fs.writeFileSync(FILE_PATH, JSON.stringify(vehiculos, null, 2));
}

// Función para guardar cambios en archivo
const guardarArchivo = () => {
  fs.writeFileSync(FILE_PATH, JSON.stringify(vehiculos, null, 2));
};

// Función para formatear como tabla JSON
const formatearTabla = () => {
  return JSON.stringify({
    tabla: vehiculos.map(v => ({
      ID: v.id,
      Marca: v.marca,
      Modelo: v.modelo,
      Año: v.anio,
      Placa: v.placa
    }))
  }, null, 2);
};

// ------------------- RUTAS -------------------

// GET todos los vehículos
app.get('/vehiculos', (req, res) => {
  console.table(vehiculos);
  res.setHeader('Content-Type', 'application/json');
  res.send(formatearTabla());
});

// GET vehículo por ID
app.get('/vehiculos/:id', (req, res) => {
  const id = parseInt(req.params.id);
  const vehiculo = vehiculos.find(v => v.id === id);
  if (!vehiculo) return res.status(404).send({ error: "Vehículo no encontrado" });
  res.setHeader('Content-Type', 'application/json');
  res.send(JSON.stringify(vehiculo, null, 2));
});

// POST nuevo vehículo
app.post('/vehiculos', (req, res) => {
  const { marca, modelo, anio, placa } = req.body;
  if (!marca || !modelo || !anio || !placa) {
    return res.status(400).send({ error: "Todos los campos son obligatorios" });
  }
  const nuevoVehiculo = {
    id: vehiculos.length ? vehiculos[vehiculos.length - 1].id + 1 : 1,
    marca,
    modelo,
    anio,
    placa
  };
  vehiculos.push(nuevoVehiculo);
  guardarArchivo();
  res.setHeader('Content-Type', 'application/json');
  res.send(JSON.stringify(nuevoVehiculo, null, 2));
});

// PUT actualizar vehículo por ID
app.put('/vehiculos/:id', (req, res) => {
  const id = parseInt(req.params.id);
  const { marca, modelo, anio, placa } = req.body;
  const vehiculo = vehiculos.find(v => v.id === id);
  if (!vehiculo) return res.status(404).send({ error: "Vehículo no encontrado" });

  if (marca) vehiculo.marca = marca;
  if (modelo) vehiculo.modelo = modelo;
  if (anio) vehiculo.anio = anio;
  if (placa) vehiculo.placa = placa;

  guardarArchivo();
  res.setHeader('Content-Type', 'application/json');
  res.send(JSON.stringify(vehiculo, null, 2));
});

// DELETE vehículo por ID
app.delete('/vehiculos/:id', (req, res) => {
  const id = parseInt(req.params.id);
  const index = vehiculos.findIndex(v => v.id === id);
  if (index === -1) return res.status(404).send({ error: "Vehículo no encontrado" });

  const eliminado = vehiculos.splice(index, 1)[0];
  guardarArchivo();
  res.setHeader('Content-Type', 'application/json');
  res.send(JSON.stringify(eliminado, null, 2));
});

// Iniciar servidor
const PORT = 3000;
app.listen(PORT, () => console.log(`Servidor corriendo en http://localhost:${PORT}`));
