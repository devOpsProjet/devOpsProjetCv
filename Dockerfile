# image docker de base
FROM openjdk:11
#   ajouter le fichier jar generer dans une image docker
ADD target/devOpsProjetCv-0.0.1-SNAPSHOT.jar app.jar
#  instruction de point d`entrer
EXPOSE 8080
VOLUME /main-app
ENTRYPOINT ["java","-jar","/app.jar"]