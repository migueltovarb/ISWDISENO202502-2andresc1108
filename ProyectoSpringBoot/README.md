Sistema de Control de Acceso para Edificio – Backend

Sistema backend para la gestión de acceso de residentes, visitantes y credenciales.
Desarrollado en Spring Boot, PostgreSQL y MongoDB, siguiendo buenas prácticas de diseño de software.

📌 Funcionalidad Implementada 
HU001 – Iniciar Sesión
Endpoint: /auth/login
Controlador: AuthController
Servicio: AuthService
Descripción: Permite validar las credenciales de un usuario del sistema.

HU002 – Registrar Residente
Endpoint: /usuarios
Controlador: UsuarioController
Servicio: UsuarioService
Descripción: Registra un nuevo residente en el sistema.

HU003 – Asignar Credencial

Endpoint: /credenciales
Controlador: CredencialController
Servicio: CredencialService
Descripción: Permite asignar una tarjeta RFID o código a un residente.

HU201 – Registrar Intento de Acceso
Endpoint: /accesos
Controlador: AccesoController
Servicio: AccesoService
Descripción: Registra cada intento de acceso, exitoso o denegado.

🧱 Arquitectura del Sistema

El sistema sigue una arquitectura basada en capas:

controller/
service/
repository/
model/
config/


Controllers: Exponen los endpoints REST.
Services: Contienen la lógica de negocio.
Repositories: Conexión a PostgreSQL y MongoDB.
Models: Entidades del dominio.
Config: Seguridad y configuración de base de datos.

🗄 Bases de Datos
PostgreSQL
Se usa para información estructurada:
Usuarios
Registros de acceso
Alertas

MongoDB
Se usa para datos no relacionales:
Puertas
Credenciales
Usuarios del sistema

▶️ Cómo Ejecutar el Proyecto
1. Configurar bases de datos
En src/main/resources/application.properties:
Cambiar usuario y contraseña de PostgreSQL
Verificar que MongoDB está corriendo en localhost:27017
2. Compilar
mvn package
3. Ejecutar
java -jar target/access-control-system-0.0.1-SNAPSHOT.jar
4. Acceso inicial
Spring Boot genera un password temporal para acceder a rutas protegidas.

📡 Ejemplo de Endpoints
Acción	Método	URL
Iniciar sesión	POST	/auth/login
Registrar residente	POST	/usuarios
Asignar credencial	POST	/credenciales
Registrar acceso	POST	/accesos
🧑‍💻 Tecnologías utilizadas
Java 17
Spring Boot 2.7
Spring Security
PostgreSQL + JPA/Hibernate
MongoDB
Maven

📘 Notas 

Este proyecto implementa un backend funcional basado en:
Diagramas UML diseñados previamente
Casos de uso entregados
Arquitectura en capas
Buenas prácticas de diseño de software
No se incluye frontend ya que no fue requerido en la entrega.