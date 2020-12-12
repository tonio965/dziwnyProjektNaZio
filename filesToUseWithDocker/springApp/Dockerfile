FROM alpine:3.11 AS libs
RUN apk add openjdk14 --repository=http://dl-3.alpinelinux.org/alpine/edge/testing/
RUN apk add vim
FROM libs AS app
COPY ./target/id-0.0.1-SNAPSHOT.jar /myApp/id-0.0.1-SNAPSHOT.jar
EXPOSE 8082
WORKDIR /myApp
CMD ["java", "-jar", "-DMODULE=reloadapi.log", "-Dlogging.config=/myApp/conf/example.log4j2.xml", "id-0.0.1-SNAPSHOT.jar", "--spring.config.location=/myApp/conf/example.properties"]