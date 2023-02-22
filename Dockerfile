FROM openjdk:11

EXPOSE 8080

ADD target/devOpsProjetCv-0.0.1-SNAPSHOT.jar devOpsProjetCv-0.0.1-SNAPSHOT.jar

ENTRYPOINT ["java","-jar","/devOpsProjetCv-0.0.1-SNAPSHOT.jar"]