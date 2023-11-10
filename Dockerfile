FROM ligaard/jdk17-gradle73

WORKDIR /bh-note-be
COPY gradlew .
COPY gradle gradle
COPY build.gradle.kts .
COPY settings.gradle.kts .
COPY src src
#RUN chmod +x ./gradlew
#RUN ./gradlew bootJar
COPY build/libs/*.jar app.jar
ENTRYPOINT ["java","-jar", "-Dspring.profiles.active=prod", "app.jar"]

VOLUME /tmp