package francesca.pascalau.thesis.rest.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EntityScan("francesca.pascalau.thesis")
@EnableJpaRepositories(basePackages = {"francesca.pascalau.thesis.data.api"})
public class DataConfiguration {
//    DB Configuration was made by src/resources/application.properties file.
//    Spring Boot analyses the Postgres DB properties and does the whole configuration for us.

    //For Configuration we added the @EntityScan and @EnableJpaRepositories
    //First one tells Spring where to look for Jpa/Hibernate entities
    //Second one tells Spring we have repositories and specified where to look for them.

}
