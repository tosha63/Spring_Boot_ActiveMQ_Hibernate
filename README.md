# Spring_Boot_ActiveMQ_Hibernate
An implementation of an application that deploys an Embedded Broker and launches 2 threads: 
a sender and a receiver. The sender generates messages at some intervals and sends the broker. 
The recipient listens to the queue, and when a message appears there, it writes the message to 
the database using Hibernate. The record is made in 2 tables, in one the body of the message, 
in the other - headers. The relationship between tables is implemented using a foreign key. 
Threads should not be explicitly started. Setting up, launching, configuring is carried out using the Spring Framework.
