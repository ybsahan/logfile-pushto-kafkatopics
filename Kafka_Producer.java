package com.github.ybsahan.logcreator;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Properties;

public class Kafka_Producer {

    private static String strLine;

    public static void main(String[] args) {

        String bootstrapServers = "127.0.0.1:9092";

        // create Producer properties
        Properties properties = new Properties();
        properties.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        properties.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());
        properties.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class.getName());

        // create the producer
        KafkaProducer<String, String> producer = new KafkaProducer<String, String>(properties);

        // create a producer record
        try{
            FileInputStream fstream = new FileInputStream("/home/ybsahan/IdeaProjects/kafkabeginner/src/main/java/com/github/ybsahan/logcreator/CityLogFile.log");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            /* read log line by line */
            while ((strLine = br.readLine()) != null)   {
                //send log file data to Kafka Producer
                System.out.println (strLine);
                ProducerRecord<String, String> record =
                        new ProducerRecord<String, String>("city_topic", strLine );
                producer.send(record);



            }

            fstream.close();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }

        //close producer
        producer.close();

    }
}
