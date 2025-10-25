
# Step 1: Use a Java image
FROM openjdk:21-jdk

# Step 2: Copy the JAR file into the container
COPY target/Booking-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

# Step 3: Run the JAR file
ENTRYPOINT ["java","-jar","/app.jar"]

