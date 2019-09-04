# contact-service
Build a simple contact list application in SpringBoot with a REST API. 

Users can create, edit, delete and list their contacts. Each contact has a name, phone number and email address stored in a database. Build a very simple frontend, which can call the API to display and edit the data.

#E2E
```
gradlew.bat clean build docker
docker-compose -f docker-compose.e2e.yml up --force-recreate --build
```

#Running the app
```
gradlew.bat clean build docker
docker-compose -f docker-compose.yml up --force-recreate --build
```