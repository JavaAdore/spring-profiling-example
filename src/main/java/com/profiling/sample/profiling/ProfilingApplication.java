package com.profiling.sample.profiling;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@SpringBootApplication
@PropertySource(value = "classpath:config/ds-${spring.profiles.active}.properties")
public class ProfilingApplication {


	// datasource attributes injected as per active profile from (classpath:config/ds-${spring.profiles.active})
	@Value("${spring.datasource.url}")
	private String datasourceUrl;
	@Value("${spring.datasource.username}")
	private String datasourceUserName;
	@Value("${spring.datasource.password}")
	private String datasourcePassword;

	// environment property injected as per active profile (classpath:application-${spring.profiles.active})
	@Value("${application.environment}")
	private String environment;


	@RequestMapping(path = "/getActiveDatasourceProperties")
	public Map<String,String> getActiveDatasourceProperties()
	{
		Map<String,String> propertiesMap = new HashMap<>();
		propertiesMap.put("datasourceUrl",datasourceUrl);
		propertiesMap.put("datasourceUserName",datasourceUserName);
		propertiesMap.put("datasourcePassword",datasourcePassword);
		return propertiesMap;
	}


	@RequestMapping(path = "/getActiveEnvironment")
	public String getActiveEnvironment()
	{
		return environment;
	}



	public static void main(String[] args) {
		SpringApplication.run(ProfilingApplication.class, args);
	}


}
