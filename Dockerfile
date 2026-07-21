# Usamos Java 22 como base para compilar
FROM eclipse-temurin:22-jdk-alpine AS build
WORKDIR /app

# Copiamos los archivos de Maven y el código fuente
COPY .mvn/ .mvn
COPY mvnw pom.xml ./

# 👇 Le damos permisos de ejecución al wrapper de Maven
RUN chmod +x mvnw

RUN ./mvnw dependency:go-offline

COPY src ./src
RUN ./mvnw clean package -DskipTests

# Segunda etapa: Imagen liviana solo con la JVM para ejecutar
FROM eclipse-temurin:22-jre-alpine
WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]