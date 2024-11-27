FROM openjdk:17

EXPOSE 8080

COPY build/libs/*SNAPSHOT.jar mju-insurance.jar

ENTRYPOINT ["java","-jar","/mju-insurance.jar"]
