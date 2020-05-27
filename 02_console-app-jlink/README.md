
## https://medium.com/criciumadev/its-time-migrating-to-java-11-5eb3868354f9

```bash

# (1)
$ java --add-opens java.base/java.lang=spring.core \
   --module-path target/modules \
   --module patternbox.springboot.modules.console/com.patternbox.springboot.modules.console.CommandLineRunnerApplication

# (2)
$ jar --update \
    --file=target/modules/console-app-jlink-1.0.0-SNAPSHOT.jar \
    --main-class=com.patternbox.springboot.modules.console.CommandLineRunnerApplication

# (3)
$ java --add-opens java.base/java.lang=spring.core \
   --module-path target/modules \
   --module patternbox.springboot.modules.console
```

```bash
$ jar --describe-module --file=target/modules/console-app-jlink-1.0.0-SNAPSHOT.jar
> patternbox.springboot.modules.console@1.0.0-SNAPSHOT jar:file:///Users/dehms/Projects/sandbox-spring/spring-boot-and-java-modules/02_console-app-jlink/target/modules/console-app-jlink-1.0.0-SNAPSHOT.jar/!module-info.class open
> requires java.base mandated
> requires jdk.unsupported
> requires spring.boot
> requires spring.boot.autoconfigure
> requires spring.context
> contains com.patternbox.springboot.modules.console
> main-class com.patternbox.springboot.modules.console.CommandLineRunnerApplication
```

--- 

## Using JLink -> FAILED

```bash
$ rm -rf custom_jre \
   && $JAVA_HOME/bin/jlink --no-header-files --no-man-pages --compress=2 \
      --module-path target/modules \
      --add-modules patternbox.springboot.modules.console \
      --launcher launch=patternbox.springboot.modules.console/com.patternbox.springboot.modules.console.CommandLineRunnerApplication \
      --output custom_jre

> Error: automatic module cannot be used with jlink: spring.boot.starter from file:///Users/dehms/Projects/sandbox-spring/spring-boot-and-java-modules/02_console-app-jlink/target/modules/spring-boot-starter-2.2.7.RELEASE.jar
```

## Maven JLink Plugin
https://rmannibucau.metawerx.net/post/jlink-your-java-image-before-putting-into-docker-part-2-of-3


## Archive....

```bash
$ cd target \
   && TARGET_JAR=console-app-jlink-1.0.0-SNAPSHOT.jar \
   && SLIM_JAR=console-app-jlink-slim.jar \
   && cp "${TARGET_JAR}.original" $SLIM_JAR \
   && unzip $TARGET_JAR -d exploded \
   && cd ..

```

```bash
$ rm -rf custom_jre \
   && $JAVA_HOME/bin/jlink --no-header-files --no-man-pages --compress=2 \
      --module-path ${JAVA_HOME}/jmods:target/console-app-jlink-slim.jar:target/exploded/BOOT-INF/lib \
      --add-modules patternbox.springboot.modules.console \
      --launcher launch=patternbox.springboot.modules.console/com.patternbox.springboot.modules.console.CommandLineRunnerApplication \
      --output custom_jre

$JAVA_HOME/bin/jdeps -recursive \
  --class-path "target/exploded/BOOT-INF/lib/*" \
  --multi-release base \
  --print-module-deps \
  target/console-app-jlink-1.0.0-SNAPSHOT.jar

# https://stackoverflow.com/questions/59869897/jlink-spring-boot
$JAVA_HOME/bin/jdeps -R -s \
   --multi-release 11 \
   -cp "target/exploded/BOOT-INF/lib/*" \
   target/console-app-jlink-1.0.0-SNAPSHOT.jar

```