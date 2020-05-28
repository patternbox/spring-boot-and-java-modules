
```bash
# Build Maven project
$ mvn clean package
# Run with Java modules
$ java -p target/modules -m patternbox.restrepo/com.patternbox.restrepo.RestRepoWebapp
# Build Docker image
$ docker build -t rest-repo-webapp .
# https://spring.io/guides/gs/spring-boot-docker/
$ docker run -p 8080:8080 -t rest-repo-webapp
```

```bash

# docker run -d -p 3306:3306 — name=Home-Server-1  — env=”MYSQL_ROOT_PASSWORD=”Your Password" mysql
# $ docker run -p 3306:3306 --name some-mysql -e MYSQL_ROOT_PASSWORD=my-secret-pw -d mysql:5.7
# MYSQL_ROOT_PASSWORD="Rds4711!" && MYSQL_ROOT_HOST="%" && MYSQL_DATABASE="db_person" && \

docker run \
   --detach \
   --env MYSQL_ROOT_PASSWORD='Rds4711!' \
   --env MYSQL_ROOT_HOST='%' \
   --env MYSQL_DATABASE='db_person' \
   --name mysql_server \
   --publish 3306:3306 \
   mysql:5.7

docker run --name mysql -e MYSQL_ROOT_PASSWORD='Rds4711!' --publish 3306:3306 mysql:5.7

#  --env MYSQL_ROOT_PASSWORD=${MYSQL_ROOT_PASSWORD} \
#  --env MYSQL_USER=${MYSQL_USER} \
#  --env MYSQL_PASSWORD=${MYSQL_PASSWORD} \
#  --env MYSQL_DATABASE=${MYSQL_DATABASE} \

```

If we do an update on the Dockerfile, the war/jar file, or the docker-compose file, then we have to execute this command to get updated data on the Docker machine.

```bash
$ docker-compose up --build
```