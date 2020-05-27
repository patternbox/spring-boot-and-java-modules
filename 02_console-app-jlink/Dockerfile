# https://stackoverflow.com/questions/53669151/java-11-application-as-lightweight-docker-image
FROM alpine:latest as packager

RUN apk --no-cache add openjdk11-jdk openjdk11-jmods

ENV JAVA_MINIMAL="/opt/java-minimal"

# build minimal JRE
RUN /usr/lib/jvm/java-11-openjdk/bin/jlink \
    --verbose \
    --add-modules java.base,jdk.unsupported,java.desktop,java.naming \
    --compress 2 --strip-debug --no-header-files --no-man-pages \
    # --release-info="add:IMPLEMENTOR=radistao:IMPLEMENTOR_VERSION=radistao_JRE" \
    --output "$JAVA_MINIMAL"

FROM alpine:latest

ENV JAVA_HOME=/opt/java-minimal
ENV PATH="$PATH:$JAVA_HOME/bin"

COPY --from=packager "$JAVA_HOME" "$JAVA_HOME"
COPY target/modules /modules/

# ENV MAIN_CLASS=""

ENTRYPOINT ["java", "--module-path", "/modules", "--module", "patternbox.springboot.modules.console/com.patternbox.springboot.modules.console.CommandLineRunnerApplication"]