# contact-service
Build a simple contact list application in SpringBoot with a REST API. 

Users can create, edit, delete and list their contacts. Each contact has a name, phone number and email address stored in a database. Build a very simple frontend, which can call the API to display and edit the data.

```
gradlew.bat clean build docker
docker-compose up --force-recreate --build
```