FROM openjdk:17

EXPOSE 8080

COPY build/libs/mju-insurance-SNAPSHOT.jar mju-insurance.jar

ENTRYPOINT ["java","-jar","/mju-insurance.jar"]
