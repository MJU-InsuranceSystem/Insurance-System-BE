FROM openjdk:17
CMD ["./gradlew", "clean", "build"]
COPY build/libs/*SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]