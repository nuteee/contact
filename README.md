# contact-service
Build a simple contact list application in SpringBoot with a REST API. 

Users can create, edit, delete and list their contacts. Each contact has a name, phone number and email address stored in a database. Build a very simple frontend, which can call the API to display and edit the data.

#Running the app
```
gradlew.bat clean build docker
docker-compose -f docker-compose.yml up --force-recreate --build
```


#E2E
```
gradlew.bat clean build docker
docker-compose -f docker-compose.e2e.yml up --force-recreate --build
```

#TODO
- Add a `-` button as a cell renderer to delete contacts in the grid
- Fix updating a contact and sending that to the backend
- Improve unit, integration and e2e testing
- Finalize the E2E testing pipeline