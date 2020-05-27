
## Maven JLink Plugin
https://rmannibucau.metawerx.net/post/jlink-your-java-image-before-putting-into-docker-part-2-of-3

```bash
$ jar --describe-module --file=target/console-app-jlink-1.0.0-SNAPSHOT.jar
patternbox.springboot.modules.console@1.0.0-SNAPSHOT jar:file:///Users/dehms/Projects/sandbox-spring/spring-boot-and-java-modules/02_console-app-jlink/target/console-app-jlink-1.0.0-SNAPSHOT.jar/!module-info.class
exports com.patternbox.springboot.modules.console
requires java.base mandated
requires spring.boot
requires spring.boot.autoconfigure
requires spring.context
opens com.patternbox.springboot.modules.console

```

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