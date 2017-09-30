package cn.spring.studio.webapp.config;

import cn.spring.studio.audit.config.AuditTrailContextConfig;
import javax.sql.DataSource;
import org.jasig.inspektr.audit.support.JdbcAuditTrailManager;
import org.jasig.inspektr.common.web.ClientInfoThreadLocalFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Configuration
@Import(AuditTrailContextConfig.class)
public class AuditTrailConfig {

    @Autowired PlatformTransactionManager transactionManager;

    @Bean
    public FilterRegistrationBean clientInfoThreadLocalFilter() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new ClientInfoThreadLocalFilter());
        registration.addUrlPatterns("/*");
        return registration;
    }

    @Bean
    public TransactionTemplate inspektrTransactionTemplate() {
        return new TransactionTemplate(transactionManager);
    }

    @Bean
    public JdbcAuditTrailManager jdbcAuditTrailManager(DataSource dataSource) {
        JdbcAuditTrailManager jdbcAuditTrailManager =
            new JdbcAuditTrailManager(inspektrTransactionTemplate());
        jdbcAuditTrailManager.setDataSource(dataSource);
        jdbcAuditTrailManager.setColumnLength(255);
        return jdbcAuditTrailManager;
    }
}
