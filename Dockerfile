
FROM adoptopenjdk:11-jdk
COPY target/CosmosAssignment-0.0.1-SNAPSHOT.jar CosmosAssignment-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java", "-jar", "/CosmosAssignment-0.0.1-SNAPSHOT.jar"]