# Etapa 1: Construcción (Build)
FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn clean package -DskipTests

# Etapa 2: Empaquetado final (Run)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Se cambia el nombre al archivo .jar
COPY --from=builder /app/target/*.jar ecomarket-carrito.jar

# El carrito corre en el puerto 8081
EXPOSE 8081

# Se ejecuta el microservicio del carrito
ENTRYPOINT ["java", "-jar", "ecomarket-carrito.jar"]