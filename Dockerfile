FROM openjdk:8
COPY ./target/commerce-0.0.1-SNAPSHOT.jar commerce-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","Commerce-0.0.1-SNAPSHOT.jar"]