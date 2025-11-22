# --- Etapa 1: Build (Construção) ---
# Usa uma imagem com Maven e Java 17 para compilar o projeto
FROM maven:3.9.6-eclipse-temurin-17 AS build
WORKDIR /app

# Copia os arquivos do projeto para dentro do Docker
COPY pom.xml .
COPY src ./src

# Roda o comando do Maven para gerar a pasta target
RUN mvn clean package -DskipTests

# --- Etapa 2: Runtime (Execução) ---
# Usa uma imagem leve apenas com Java 17 para rodar
FROM eclipse-temurin:17-jre
WORKDIR /deployments

# Copia os arquivos compilados da Etapa 1 para a Etapa 2
COPY --from=build /app/target/quarkus-app/lib/ /deployments/lib/
COPY --from=build /app/target/quarkus-app/*.jar /deployments/
COPY --from=build /app/target/quarkus-app/app/ /deployments/app/
COPY --from=build /app/target/quarkus-app/quarkus/ /deployments/quarkus/

# Expõe a porta e define o comando de início
EXPOSE 8080
CMD ["java", "-jar", "quarkus-run.jar"]