package com.api.apiclientsdk;

import com.api.apiclientsdk.client.ApiClient;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Data
@ComponentScan
@Configuration
@ConfigurationProperties("api.client")
public class ApiClientSDKConfig {
    private String accessKey;
    private String secretKey;

    @Bean
    public ApiClient apiClient() {
        return new  ApiClient(accessKey, secretKey);
    }

}
