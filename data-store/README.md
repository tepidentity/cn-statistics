# Data Store Service
## Microservice to serve and manage data.

- Data entry point for other microservices. All access is read-only.
- Listens to RabbitMQ broker for incoming data and preserves new entries.

## Configuration

`spring.rabbitmq` - rabbit connection properties.

## Swagger
#### swagger accessible at http://localhost:8082/swagger.html 