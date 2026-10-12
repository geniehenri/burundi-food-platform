# ===== STAGE 1 : Build =====
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app

# Copier le POM parent d'abord (cache Docker)
COPY ../pom.xml ../pom.xml
COPY pom.xml .

# Télécharger les dépendances (mis en cache si le POM ne change pas)
RUN mvn dependency:go-offline -B || true

# Copier le code source
COPY src ./src

# Compiler
RUN mvn clean package -DskipTests

# ===== STAGE 2 : Runtime =====
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

# Ajouter le fuseau horaire du Burundi
RUN apk add --no-cache tzdata
ENV TZ=Africa/Bujumbura

# Créer un utilisateur non-root
RUN addgroup -S appgroup && adduser -S appuser -G appgroup
USER appuser

# Copier le JAR
COPY --from=build /app/target/*.jar app.jar

# Port
EXPOSE 8761

# Health check
HEALTHCHECK --interval=30s --timeout=10s --start-period=60s --retries=3 \
    CMD wget --no-verbose --tries=1 --spider http://localhost:8761/actuator/health || exit 1

# Lancer
ENTRYPOINT ["java", "-XX:+UseContainerSupport", "-XX:MaxRAMPercentage=75.0", "-jar", "app.jar"]