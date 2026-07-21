# Usamos Java 22 como base para compilar
FROM eclipse-temurin:22-jdk-alpine AS build
WORKDIR /app

# Copiamos los archivos de Maven y el código fuente
COPY .mvn/ .mvn
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw clean package -DskipTests

# Segunda etapa: Imagen liviana solo con la JVM para ejecutar
FROM eclipse-temurin:22-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# Render asigna el puerto dinámico en la variable PORT
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]