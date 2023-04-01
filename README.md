# Build regular spring boot app as jar
mvn compile spring-boot:run -Dspring.liquibase.enabled=true -f pom.xml

# Build the native image
mvn -Pnative native:compile -Dspring.liquibase.enabled=false -f native-pom.xml
