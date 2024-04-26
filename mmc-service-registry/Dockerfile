FROM maven:3.9.6 AS build
# Set the working directory in the container
WORKDIR /app
ARG CONTAINER_PORT
COPY pom.xml /app
RUN mvn dependency:resolve
COPY . /app
RUN mvn clean
RUN mvn package

# Use the official OpenJDK base image
FROM openjdk:17
# Copy the packaged JAR file into the container
COPY --from=build /app/target/*.jar service-registry.jar
EXPOSE ${CONTAINER_PORT}
# Command to run the Eureka server
CMD ["java","-jar","service-registry.jar"]