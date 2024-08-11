FROM openjdk

LABEL maintainer="mwduncan2018@gmail.com"

WORKDIR /target

COPY target/elevatorsimulator-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["java","-jar","elevatorsimulator-0.0.1-SNAPSHOT.jar"]