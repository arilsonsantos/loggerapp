package com.orion.logger.logtoqueue;


import org.apache.http.HttpHost;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * ElasticsearchConfig
 */
@Configuration
@PropertySource("classpath:elasticsearch.properties")
public class ElasticsearchConfig {

    @Value("${elasticsearch.host}")
    public String host;
    @Value("${elasticsearch.port}")
    public int port;

    @Value("${elasticsearch.index.name}")
    private String indexName;

    @Value("${elasticsearch.type.name}")
    private String typeName;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient client() {
        RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(host, port)));
        return client;
    }

    
    // @Bean
    // RestHighLevelClient elasticsearchClient() {
    //     final ClientConfiguration configuration = ClientConfiguration.localhost();
    //     RestHighLevelClient client = RestClients.create(configuration).rest();
    //     return client;
    // }

    // @Bean
    // ElasticsearchRestTemplate elasticsearchTemplate() {
    //     return new ElasticsearchRestTemplate(elasticsearchClient());
    // }

}