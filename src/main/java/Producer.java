import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;
import java.util.concurrent.ExecutionException;

public class Producer extends Thread{
    KafkaProducer producer;

    public Producer () {
        Properties properties = new Properties();
        properties.put("bootstrap.servers", "kafka-kaktus-1.stage.branch.io" + ":" + "9092");
        properties.put("client.id", "DemoProducer");
        properties.put("key.serializer", "org.apache.kafka.common.serialization.IntegerSerializer");
        properties.put("value.serializer", "org.apache.kafka.common.serialization.ByteArraySerializer");

        producer = new KafkaProducer<>(properties);
    }


    public void produce(String topic, byte[] message) {
        try {
            producer.send(new ProducerRecord<>(topic,
                    message)).get();
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            // handle the exception
        }


    }
    public static void main(String[] args) {

    }




}






