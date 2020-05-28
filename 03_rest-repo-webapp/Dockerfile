FROM openjdk:13-alpine AS builder

ENV JAVA_HOME=/opt/openjdk-13 \
    PATH=${PATH}:/opt/openjdk-13/bin \
    LANG=C.UTF-8

RUN jlink \
    --add-modules java.base,java.desktop,java.naming \
    --output dist \
    --compress 2 \
    --strip-java-debug-attributes \
    --no-header-files \
    --no-man-pages

FROM alpine:latest

COPY --from=builder /dist /opt/jdk/
COPY target/modules /modules/
ENV PATH=$PATH:/opt/jdk/bin

ENTRYPOINT ["java", "--module-path", "/modules", "--module", "patternbox.restrepo/com.patternbox.restrepo.RestRepoWebapp"]
