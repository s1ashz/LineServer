package com.example.line.server;

import com.example.line.server.config.PropertiesValues;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class LineServerApplication implements ApplicationRunner {

	private static final Logger logger = LoggerFactory.getLogger(LineServerApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(LineServerApplication.class, args);
	}

	@Override
	public void run(ApplicationArguments args) {
		logger.info("Application started with command-line arguments: {}", Arrays.toString(args.getSourceArgs()));
		logger.info("NonOptionArgs: {}", args.getNonOptionArgs());
		logger.info("OptionNames: {}", args.getOptionNames());

		for (String name : args.getOptionNames()){
			logger.info("arg-" + name + "=" + args.getOptionValues(name));
		}

		boolean containsOption = args.containsOption(PropertiesValues.FOLDER_PATH);
		logger.info("Contains file.path: " + containsOption);
	}

}
