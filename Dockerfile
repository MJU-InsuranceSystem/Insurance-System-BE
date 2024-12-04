FROM eclipse-temurin:17-jdk

EXPOSE 8080

COPY build/libs/*SNAPSHOT.jar mju-insurance.jar

# prometheus yml copy
COPY prometheus/prometheus.yml app/prometheus.yml



ENTRYPOINT ["java","-jar","/mju-insurance.jar"]
