# Vehículos API (Hecho por: Andrés - Estudiante 4° semestre)

Proyecto simple de ejemplo que implementa un CRUD de vehículos usando Java + Spring Boot + MongoDB.
Pensado para ejecutarse desde la terminal (VSCode) con Maven.

## Requisitos
- Java 17 instalado
- Maven instalado
- MongoDB corriendo (localmente o MongoDB Atlas)

## Ejecutar en la terminal (VSCode)
1. Abrir la terminal y posicionarse en la carpeta del proyecto.
2. Ejecutar:
   ```
   mvn spring-boot:run
   ```
3. La API quedará en `http://localhost:8080/api/vehiculos`

## Si usas Docker para MongoDB (opcional)
```
docker run -d -p 27017:27017 --name mongo-local mongo:6
```

## Endpoints (ejemplos curl)
- Crear:
  ```
  curl -X POST -H "Content-Type: application/json" -d '{"marca":"Toyota","modelo":"Corolla","anio":2019,"placa":"ABC123"}' http://localhost:8080/api/vehiculos
  ```
- Obtener todos:
  ```
  curl http://localhost:8080/api/vehiculos
  ```
- Obtener por id:
  ```
  curl http://localhost:8080/api/vehiculos/{id}
  ```
- Actualizar:
  ```
  curl -X PUT -H "Content-Type: application/json" -d '{"marca":"Nissan","modelo":"Sentra","anio":2020,"placa":"XYZ987"}' http://localhost:8080/api/vehiculos/{id}
  ```
- Eliminar:
  ```
  curl -X DELETE http://localhost:8080/api/vehiculos/{id}
  ```

GRACIAS
