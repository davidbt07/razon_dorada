FROM openjdk:16
COPY "./out/artifacts/razonDorada_jar/razonDorada.jar" "./razonDorada.jar"
EXPOSE 8088
ENTRYPOINT ["java", "-jar", "./razonDorada.jar", "0", "3" ,"true"]