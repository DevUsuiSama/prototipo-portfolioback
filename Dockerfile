FROM openjdk:19-ea-jdk-slim

LABEL maintainer="DevUsuiSama"

COPY target/portfoliobackend-devusuisama.jar appdevusuisama.jar

ENTRYPOINT ["java","-jar","/appdevusuisama.jar"]