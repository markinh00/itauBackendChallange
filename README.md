# 💸 Itau Backend Challenge - Java
This is a backend project developed in Java as a solution to Itau's technical challenge. The system simulates transfers between users, validating business rules. In addition, it has interactive documentation via Swagger.

🔗 Original challenge: [Github](https://github.com/feltex/desafio-itau-backend)

🚀 Technologies Used
- Java 17+
- Spring Boot
- Swagger (SpringDoc OpenAPI)
- Maven
- Docker and Docker Compose (optional)

## 🧪 Running the Project
🔧 Prerequisites
- Java 17+
- Maven 3.8+
- (Optional) Docker + Docker Compose

### ▶️ Running Locally (without Docker)
#### 1. Clone the repository
```
  git clone https://github.com/markinh00/itauBackendChallange.git
  cd itauBackendChallange
```
#### 2. Compile the project
```
  mvn clean install
```
#### 3. Execute the app
```
  mvn spring-boot:run
```
#### 4. Access swagger at:
```
  http://localhost:8080/swagger-ui/index.html
```
### 🐳 Running with Docker Compose
#### 1. Clone the repository
```
  git clone https://github.com/markinh00/itauBackendChallange.git
  cd itauBackendChallange
```
#### 2. Build and upload containers
```
  docker-compose up --build
```
#### 3. Access swagger at:
```
  http://localhost:8080/swagger-ui/index.html
```