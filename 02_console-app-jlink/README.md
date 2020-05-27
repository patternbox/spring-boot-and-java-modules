
```bash
$ jar --describe-module --file=target/console-app-print-env-1.2.3-SNAPSHOT.jar
patternbox.springboot.modules.console@1.2.3-SNAPSHOT jar:file:///Users/dehms/Projects/sandbox-spring/spring-boot-and-java-modules/01_console-app-print-env/target/console-app-print-env-1.2.3-SNAPSHOT.jar/!module-info.class
requires java.base mandated
requires spring.boot
requires spring.boot.autoconfigure
requires spring.context
opens com.patternbox.springboot.modules.console

```

```bash
$ rm -rf custom_jre \
   && $JAVA_HOME/bin/jlink --no-header-files --no-man-pages --compress=2 \
      --module-path target/console-app-print-env-1.2.3-SNAPSHOT.jar \
      --add-modules patternbox.springboot.modules.console \
      --launcher launch=patternbox.springboot.modules.console/com.patternbox.springboot.modules.console.CommandLineRunnerApplication \
      --output custom_jre
```