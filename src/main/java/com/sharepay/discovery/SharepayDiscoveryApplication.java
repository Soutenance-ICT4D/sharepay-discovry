package com.sharepay.discovery;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class SharepayDiscoveryApplication {
	public static void main(String[] args) {

		Dotenv dotenv = Dotenv.configure()
				.filename(".env.local")
				.ignoreIfMissing()
				.load();
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(SharepayDiscoveryApplication.class, args);
	}
}
