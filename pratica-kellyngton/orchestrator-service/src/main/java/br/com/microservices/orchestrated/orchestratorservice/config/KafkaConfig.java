package br.com.microservices.orchestrated.orchestratorservice.config;

import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.admin.NewTopic;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.*;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@RequiredArgsConstructor
public class KafkaConfig {

    @Value("${spring.kafka.bootstrap-servers}")
    private String bootstrapServers;

    @Value("${spring.kafka.consumer.group-id}")
    private String groupId;

    @Value("${spring.kafka.consumer.auto-offset-reset}")
    private String autoOffsetReset;

    @Value("${spring.kafka.topic.orchestrator}")
    private String orchestratorTopic;

    @Value("${spring.kafka.topic.finish-success}")
    private String finishSuccessTopic;

    @Value("${spring.kafka.topic.finish-fail}")
    private String finishFailTopic;

    @Value("${spring.kafka.topic.notify-ending}")
    private String notifyEndingTopic;

    private static final Integer REPLICA_COUNT = 1;
    private static final Integer PARTITION_COUNT = 1;

    @Bean
    public ProducerFactory<String, String> producerFactory(){
        return new DefaultKafkaProducerFactory<String, String>(producerConfig());
    }

    private Map<String, Object> producerConfig(){
        var configProps = new HashMap<String, Object>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configProps.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
    return configProps;
    }

    @Bean
    public ConsumerFactory<String, String> consumerFactory(){
        return new DefaultKafkaConsumerFactory<String, String>(consumerConfig());
    }

    private Map<String, Object> consumerConfig(){
        var configProps = new HashMap<String, Object>();
        configProps.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, bootstrapServers);
        configProps.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
        configProps.put(ConsumerConfig.GROUP_ID_CONFIG, groupId);
        configProps.put(ConsumerConfig.AUTO_OFFSET_RESET_CONFIG, autoOffsetReset);
        return configProps;
    }

    @Bean
    public KafkaTemplate kafkaTemplate(){
        return new KafkaTemplate(producerFactory());
    }

    private NewTopic topicBuilder(String name){
        return TopicBuilder
                .name(name)
                .replicas(REPLICA_COUNT)
                .partitions(PARTITION_COUNT)
                .build();
    }

    @Bean
    public NewTopic finishSuccess(){
        return  topicBuilder(finishSuccessTopic);
    }

    @Bean
    public NewTopic finishFail(){
        return  topicBuilder(finishFailTopic);
    }

    @Bean
    public NewTopic orchestrator(){
        return  topicBuilder(orchestratorTopic);
    }

    @Bean
    public NewTopic notifyEnding(){
        return  topicBuilder(notifyEndingTopic);
    }
}
