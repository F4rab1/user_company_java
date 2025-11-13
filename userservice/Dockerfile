# ---- Stage 1: Build ----
FROM maven:3.9.0-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy entire project
COPY . .

# Build directly (dependencies + package)
RUN mvn clean package -DskipTests

# ---- Stage 2: Run ----
FROM eclipse-temurin:17-jdk

WORKDIR /app
COPY --from=builder /app/target/*-SNAPSHOT.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java","-jar","app.jar"]
