FROM amazoncorretto:17-alpine-jdk
COPY ./build/libs/atl-7-0.0.1-SNAPSHOT.jar atl-7-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","atl-7-0.0.1-SNAPSHOT.jar"]