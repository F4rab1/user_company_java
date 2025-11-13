# ---- Stage 1: Build ----
FROM maven:3.9.0-eclipse-temurin-17 AS builder

WORKDIR /app

# Copy entire project
COPY . .

# Build directly (download dependencies + package)
RUN mvn clean package -DskipTests

# ---- Stage 2: Run ----
FROM eclipse-temurin:17-jdk

WORKDIR /app

# Copy the built jar from the builder stage
COPY --from=builder /app/target/*.jar app.jar

# Expose the company service port
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
