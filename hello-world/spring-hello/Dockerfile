FROM openjdk

WORKDIR /app

COPY target/spring-hello-0.0.1-SNAPSHOT.jar /app/spring-hello.jar

ENTRYPOINT ["java","-jar", "spring-hello.jar"]