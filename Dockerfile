FROM ligaard/jdk17-gradle73

WORKDIR /bh-note-be

COPY build/libs/*.jar app.jar

ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod", "app.jar"]

VOLUME /tmp