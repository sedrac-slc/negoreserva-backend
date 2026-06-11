# Estágio 1: Build - Focado em cache de dependências
FROM maven:3.9.16-eclipse-temurin-25-alpine AS build

# Copia apenas o pom.xml primeiro para aproveitar o cache do Docker
WORKDIR /app
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Agora copia o código fonte
COPY src ./src
RUN mvn clean package -DskipTests

# Estágio 2: Runtime
FROM eclipse-temurin:25-jre-alpine
WORKDIR /app

# Copia apenas o jar final do estágio de build
COPY --from=build /app/target/negoreserva-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]