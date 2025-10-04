# Reto_CIVA

BACKEND
🧱 Requisitos previos
Antes de ejecutar el proyecto, asegúrate de tener instalado:
- Java 17 o superior
- Maven 3+
- PostgreSQL 14+
- (Opcional) pgAdmin 4 para visualizar la base de datos

⚙️ Configuración del proyecto
1. Clona el repositorio:
git clone https://github.com/Aladan2040/Reto_CIVA.git
cd Reto_CIVA

2. Configura el archivo application.properties con los datos de tu base de datos
3. Compila y ejecuta el proyecto:
  mvn clean install
  mvn spring-boot:run

🔐 Autenticación
La API está protegida mediante Basic Authentication.
Credenciales por defecto:
Usuario: admin
Contraseña: password123

FRONTEND
🧩 Requisitos previos
Asegúrate de tener instalado:
Node.js 18 o superior
npm (viene con Node.js)
Tener el backend corriendo en http://localhost:8080

1. Clona el repositorio del frontend (si está en el mismo repo del backend, entra a la carpeta del frontend):
git clone https://github.com/Aladan2040/Reto_CIVA.git
cd Reto_CIVA/frontend

2.Instala dependencias y ejecuta el frontEnd
npm install
npm start

3. Accede a la aplicación
FrontEnd: http://localhost:3000
BackEnd: http://localhost:8080
