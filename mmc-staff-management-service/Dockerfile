FROM maven:3.9.6 AS build
WORKDIR /app
ARG CONTAINER_PORT
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package

FROM openjdk:17
COPY --from=build /app/target/*.jar staff-service.jar
EXPOSE ${CONTAINER_PORT}
CMD ["java","-jar","staff-service.jar"]