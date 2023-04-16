# Build regular spring boot app as jar
mvn compile liquibase:update spring-boot:run

# Build the native image
mvn liquibase:update native:compile -f native-pom.xml

# Known issues
https://github.com/spring-attic/spring-native/issues/1684
