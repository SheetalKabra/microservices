#Start with a base image containing Java runtime
FROM eclipse-temurin:21-jre-jammy

#Information aroiund who maintain the image
LABEL maintainer=sheetalkabra4@gmail.com

#Add the applications jar to the image
COPY target/accounts-0.0.1-SNAPSHOT.jar accounts-0.0.1-SNAPSHOT.jar

#execute the application
ENTRYPOINT ["java", "-jar", "accounts-0.0.1-SNAPSHOT.jar"]