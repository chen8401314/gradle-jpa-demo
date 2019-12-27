FROM java:8
VOLUME /tmp
COPY build/libs/gradle-jpa-demo-0.0.1-SNAPSHOT.jar app.jar
RUN bash -c "touch /app.jar"
EXPOSE 8066
ENTRYPOINT ["java", "-jar", "app.jar", "--spring.profiles.active=test"]