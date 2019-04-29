# BigDataProject
This Project is that about continuously generated logs have to be shown in a browser as real time and be stored in a database which can be any rdbms or nosql.

There are 7 steps that I divided

1)CREATE LOG FILE
  In this step created log file and was written some data manually into this log file
  
2)KAFKA PRODUCER
  Created kafka producer
 
3)SEND LOG FILES DATA TO KAFKA PRODUCER
  In Kafka_Producer Code Read Logs line by line and append into Kafka city_topic

4)CREATE KAFKA CONSUMER
  In this step was created Kafka Consumer 

5)INSERT DATA INTO ELASTICSEARCH
  I tried to write from kafka consumer to elasticsearch by bonsai elasticsearch not local but could not work

6)ON BROWSER REAL TIME EVENT
  Could not do this properties

7)MONITORING AND LOG DASHBOARD
  COuld not real time event so this properties also could not.
