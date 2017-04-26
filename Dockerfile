FROM airhacks/java
ENV INSTALL_DIR /opt
ADD /target/TestContainer-1.0-SNAPSHOT.jar ${INSTALL_DIR}/
WORKDIR ${INSTALL_DIR}
ENTRYPOINT java -jar TestContainer-1.0-SNAPSHOT.jar
EXPOSE 8080
