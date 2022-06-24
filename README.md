# Summary

Demo project to demonstrate infrastructure understanding.

## How to build:

1. Make sure you are having running RabbitMQ broker that is accessible on port `15672`.
- If you don't have Rabbit installed locally you could use docker: `docker run -d -p 15672:15672 -p 5672:567 rabbitmq:3-management`
- If you want to use different port you need to set that here: `data-scrapper/src/main/resources/application.yml`, `statistics/src/main/resources/application.yml`
2. Run `mvn clean install` in root directory. This will build all 5 modules at once.

## How to run:

1. Start `cloud-registry` application.
2. Start `cloud-gateway` application. (OPTIONAL)
3. Start `data-scrapper` application.
4. Start `data-source` application.
5. Start `statistics` application. (OPTIONAL)

## Resources:

- Country Summary url: http://localhost:8080/country/{code}
- H2 console url(JDBC URL - jdbc:h2:mem:dev) http://localhost:8082/h2-console/ 
- RabbitMQ management url: http://localhost:15672
- Eurica management url: http://localhost:8761/
- data-store-service swagger url: http://localhost:8081/swagger.html
- statistics-Service swagger url: http://localhost:8082/swagger.html

### Running Spring jars locally:
- running spring boot jar locally: `mvn spring-boot:run` or `java -jar XXX.jar`