package com.patternbox.springboot.modules.console;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CommandLineRunnerApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(CommandLineRunnerApplication.class, args);
	}

	@Override
	public void run(String... args) {
		Map<String, String> env = System.getenv();
		List<String> keyList = env.keySet().stream().sorted().collect(Collectors.toList());
		keyList.forEach(key -> {
			System.out.println(String.format("args[%s]: %s", key, env.get(key)));
		});
	}

}
