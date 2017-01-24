# rsyslog_remote_example

This only publishes slf4j logs over log4j 2 to rsyslog server.
Created few example various severity logs to test.

> mvn clean install

Above builds fat jar which can be executed with following command:

java -DSyslogServer=[rsyslog server ip] -DSyslogServerPort=[rsyslog server port]  -DSyslogServerProtocol=[rsyslog protocol] -jar rsyslog_remote_example-0.0.1-SNAPSHOT-jar-with-dependencies.jar
