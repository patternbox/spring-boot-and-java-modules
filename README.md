
# Spring Boot and Java Modules

```bash
$ jdeps target/classes/com/patternbox/springboot/modules/console/CommandLineRunnerApplication.class 
CommandLineRunnerApplication.class -> java.base
CommandLineRunnerApplication.class -> not found
   com.patternbox.springboot.modules.console          -> java.io                                            java.base
   com.patternbox.springboot.modules.console          -> java.lang                                          java.base
   com.patternbox.springboot.modules.console          -> java.lang.invoke                                   java.base
   com.patternbox.springboot.modules.console          -> java.util                                          java.base
   com.patternbox.springboot.modules.console          -> java.util.function                                 java.base
   com.patternbox.springboot.modules.console          -> java.util.stream                                   java.base
   com.patternbox.springboot.modules.console          -> org.springframework.boot                           not found
   com.patternbox.springboot.modules.console          -> org.springframework.boot.autoconfigure             not found
   com.patternbox.springboot.modules.console          -> org.springframework.context                        not found
```

## External Resources

### Migrating a Spring Boot application to Java 9 - Modules
https://blog.frankel.ch/migrating-to-java-9/2/

### Spring boot java 9 example
https://javadeveloperzone.com/spring-boot/spring-boot-java-9-example/

### It’s time! Migrating to Java 11
https://medium.com/criciumadev/its-time-migrating-to-java-11-5eb3868354f9


