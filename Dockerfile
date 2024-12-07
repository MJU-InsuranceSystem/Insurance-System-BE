FROM eclipse-temurin:17-jdk

EXPOSE 8080

COPY build/libs/*SNAPSHOT.jar mju-insurance.jar

# prometheus yml copy
COPY prometheus/prometheus.yml app/prometheus.yml

# promtail yml copy
COPY promtail/promtail-config.yml app/promtail-config.yml

# loki yml copy
COPY loki/loki-config.yml app/loki-config.yml

ENTRYPOINT ["java","-jar","/mju-insurance.jar"]
