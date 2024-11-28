FROM eclipse-temurin:17-jdk

EXPOSE 8080

COPY build/libs/*SNAPSHOT.jar mju-insurance.jar

ENTRYPOINT ["java","-jar","/mju-insurance.jar"]
