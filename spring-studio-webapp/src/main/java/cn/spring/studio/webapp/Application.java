package cn.spring.studio.webapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableCaching(order = 0)
@EnableConfigurationProperties
public class Application extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Application.class);
    }

    @Configuration
    @EnableTransactionManagement
    @EnableJpaRepositories(basePackages = "cn.tendata.mdcs.data.repository")
    @EnableJpaAuditing
    @EntityScan(basePackages = "cn.tendata.mdcs.data.domain")
    static class JpaConfig {
    }

    @Configuration
    //@ComponentScan(basePackageClasses = {EntityService.class})
    static class ServiceConfig {
    }

    @Configuration
    @EnableScheduling
    static class ScheduleConfig {

    }
}

