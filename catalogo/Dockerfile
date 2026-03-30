# Etapa 1: Construcción (Build)
FROM maven:3.9.6-eclipse-temurin-17-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Compila el proyecto omitiendo los tests para mayor rapidez
RUN mvn clean package -DskipTests

# Etapa 2: Empaquetado final (Run)
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
# Copia solo el archivo compilado desde la etapa anterior
COPY --from=builder /app/target/*.jar ecomarket-catalogo.jar

# Expone el puerto por defecto
EXPOSE 8080

# Comando para iniciar el microservicio
ENTRYPOINT ["java", "-jar", "ecomarket-catalogo.jar"]