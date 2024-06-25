Read Me :

I want to add some commands for using while working on Kafka:

Run the following commands in order to start all services in the correct order: (Note : Please work on PowerShell)
-> bin/zookeeper-server-start.sh config/zookeeper.properties

Open another terminal session and run:
-> bin/kafka-server-start.sh config/server.properties

READ THE EVENTS :
Open another terminal session and run the console consumer client to read the events you just created:

bin/kafka-console-consumer.sh --topic CHANGE-THIS-BY-YOUR-TOPIC --from-beginning --bootstrap-server localhost:9092