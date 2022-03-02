package raluandnic.client.configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@ComponentScan("raluandnic.client.configuration")
public class WebSecurity{
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
