# Java Vienna Talk

## Topic:  Messaging with Spring - ActiveMQ vs. RabbitMQ (21.10.2024)
## Speaker: Milan Gogic
----------
 This Repository contains examples from the Java Vienna meetup talk, 21.10.2024

There are two examples:

- ### ActiveMQ Example
- ### RabbitMQ Example

All the examples are created as a Multi-Module maven projects, in order to easily turn apps on and off during the presentation of specific possibilities.

Both examples have a ```shared-dependencies``` sub-module, where common dependencies are defined.

### Endpoints
Endpoints for both examples are provided under  ```producer-service/test/*.http``` files.

# Prerequisits

To successfully run the examples, one needs to install ```docker``` on the local machine.
Docker compose files are provided under ```root/compose.yml``` files

## ActiveMQ example
Messaging pattern: Pub/Sub

This example consists of 3 sub-modules:

- ```durable-consumer-service```
- ```non-durable-consumer-service```
- ```producer-service```

```Producer-service``` exposes one endpoint, and by calling that endpoint, with the message body as a query parameter(name of param is ```message```), a message will be sent to the topic and consumed by subscribers.

ActiveMQ console is runnning on ```http://localhost:8161/```
## RabbitMQ example
Exchange types implemented: 
- Fanout
- Topic

This example consists of 3 sub-modules:

- ```fanout-consumer-service```
- ```topic-consumer-service```
- ```producer-service```

```Producer-service``` exposes two endpoints, one for sending messages to fanout and another for sending messages to topic.

### For the fanout exchange endpoint, only the message body should be sent as a query parameter(name of param is ```message```), and for the topic exchange endpoint, ```message``` AND ```routing_key``` should be sent. ###
Routing patterns used for topic exchange can be checked in ```io.viesure.config.TopicConsumerConfig``` 

RabbitMQ console is running on ```http://localhost:15672```
