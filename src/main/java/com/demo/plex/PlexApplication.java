package com.demo.plex;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.envers.repository.support.EnversRevisionRepositoryFactoryBean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.demo.plex"})
@EnableJpaRepositories(value = {"com.demo.plex" }, repositoryFactoryBeanClass = EnversRevisionRepositoryFactoryBean.class)
@EntityScan({"com.demo.plex" })
@EnableAutoConfiguration
public class PlexApplication {

	public static void main(String[] args) {
		SpringApplication.run(PlexApplication.class, args);
	}

}
