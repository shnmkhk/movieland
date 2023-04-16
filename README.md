# Build regular spring boot app as jar
mvn compile liquibase:update spring-boot:run

# Build the native image
mvn liquibase:update native:compile -f native-pom.xml

# Ubuntu packages to be installed before running graalvm native build:

sudo apt install curl build-essential neofetch  axel  adb  speedtest-cli  sdkmanager  mysql-server-core-8.0 mysql-client-core-8.0  mysql-server  git  gh  vim  lib32z1-dev nodejs npm httpie -y

curl -s "https://get.sdkman.io" | bash

sdk install maven; sdk install gradle; sdk install sbt; sdk install java 22.3.r19-grl

sudo apt-get remove docker docker-engine docker.io containerd runc
sudo apt-get update
sudo apt-get install \
    ca-certificates \
    curl \
    gnupg
    
sudo install -m 0755 -d /etc/apt/keyrings
curl -fsSL https://download.docker.com/linux/ubuntu/gpg | sudo gpg --dearmor -o /etc/apt/keyrings/docker.gpg
sudo chmod a+r /etc/apt/keyrings/docker.gpg

echo \
  "deb [arch="$(dpkg --print-architecture)" signed-by=/etc/apt/keyrings/docker.gpg] https://download.docker.com/linux/ubuntu \
  "$(. /etc/os-release && echo "$VERSION_CODENAME")" stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null

sudo apt-get update  
sudo apt-get install docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin

sudo service docker start
sudo docker run hello-world

