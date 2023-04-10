FROM openjdk:8
COPY ./build/libs/shopDemoITSJ-0.0.1-SNAPSHOT.jar /shopDemoITSJ.jar
ENTRYPOINT ["java","-jar","/shopDemoITSJ.jar"]
EXPOSE 8080