# Data scrapper
## Script application to poll data from the external API and submit result to internal system

- Scraping the remote service once when the application is started
- Scraping the remote service every day at 11AM
- Submitting scrapped  data to RabbitMQ broker

## Configuration

`scrape.url` - url to poll data from. Initially value:
`url: https://api.covid19api.com/summary` <br>
`scrape.cron` - cron expression to run the scrape task. Initial value: `0 11 0 * * ?` <br>
`spring.rabbitmq` - rabbit connection properties.
