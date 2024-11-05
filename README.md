# Spring Boot + PostgreSQL Dockerized

### To start your services while also building images if there are any changes in your Dockerfile or your application code that might affect the image
* It builds the images specified in your docker-compose.yml file before starting the containers.
* If any changes are detected in the files being used for the build (e.g., the Dockerfile, context directory, etc.), it will rebuild those images.
```  bash
docker-compose up --build
```
### To start your services in detached mode, meaning the containers run in the background.
* It does not automatically build images unless specified
```  bash
docker-compose up -d
```
### Check Containers, get Container ID of database
```  bash
docker container ls
```
### Get Ip address where database runs
```  bash
docker inspect {container id}
```
###After that we establish connection to the pgAdmin
ip address - copy from container details 
database - company
username - postgres
password - 1234



### Creating a docker network
``` bash
docker network create my_network
``` 
### Postgresql docker setup
``` bash
#Build PostfresSQL image (From the position of the Dockerfile)
docker build . -t postgres_db

#Run Postgres container from image
docker run --name my_database --network my_network postgres_db
```

### Spring Boot docker setup
``` bash
#Build Spring boot image (From the position of the Dockerfile)
docker build . -t spring_boot_service

#Run backend service and hos tit on localhost port 8080
docker run -d -p 8080:8080 --name backend --network my_network spring_boot_service

```
