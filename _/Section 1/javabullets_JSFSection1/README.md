# Build
mvn clean package && docker build -t com.javabullets.javaee/javabullets .

# RUN

docker rm -f javabullets || true && docker run -d -p 8080:8080 -p 4848:4848 --name javabullets com.javabullets.javaee/javabullets 