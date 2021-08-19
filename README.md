# SpringBoot Kafka Example
Kafka example with Spring Boot to track transaction events of the book store.

Read in: [Türkçe](README.tr.md)

# Install the Apache Kafka
Download the Apache Kafka and extract the files. 

Go to extracted folder.

(You can simply follow the instruction here: https://kafka.apache.org/quickstart)

# Start the zookeper

In kafka folder, run this command on terminal window to start zookeper with default configs
```shell
bin/zookeeper-server-start.sh config/zookeeper.properties
```
# Start the Kafka broker (server)

In kafka folder, on a new terminal session, start the broker with the command:

```shell
bin/kafka-server-start.sh config/server.properties
```

# Start a consumer to read the messages

On a new terminal window run this command to begin reading messages:

```shell
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic BookTransaction --from-beginning
```

# Run the Spring Boot App

Start the spring boot app and the server will start on the port **8080**. 

You can make a post request to test the kafka events with the curl command.

Example request:

```shell
curl --location --request POST 'http://localhost:8080/book/transaction' \
--header 'Content-Type: application/json' \
--data-raw '{
    "isbn": "123-5266-56",
    "transactionType": "RETURN",
    "amount": 1
}'
```

Then you can see the message on both the SpringBoot app console and the consumer terminal.
