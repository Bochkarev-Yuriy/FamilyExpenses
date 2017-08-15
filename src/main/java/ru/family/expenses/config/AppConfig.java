package ru.family.expenses.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import ru.family.expenses.util.init.TestDataInitializer;

@EnableWebMvc
@Configuration
@ComponentScan("ru.family.expenses")
public class AppConfig {

    @Bean(initMethod = "init")
    public TestDataInitializer initTestData() {
        return new TestDataInitializer();
    }
}
