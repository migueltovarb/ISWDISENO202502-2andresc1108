#!/bin/bash
# Script simple para usar en la terminal 
echo "Ejemplos rápidos usando curl (asumiendo servidor en http://localhost:8080)"
echo "Crear vehículo..."
curl -s -X POST -H "Content-Type: application/json" -d '{"marca":"Kia","modelo":"Rio","anio":2018,"placa":"PST001"}' http://localhost:8080/api/vehiculos | jq
echo
echo "Listar vehículos..."
curl -s http://localhost:8080/api/vehiculos | jq
