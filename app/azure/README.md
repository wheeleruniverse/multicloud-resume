# Resume Azure

## Development

### package
mvn clean package

### run
mvn azure-functions:run

### deploy 
mvn azure-functions:deploy

## Production

### root
* https://wheeler-resume-app.azurewebsites.net/api

### certification
* [GET] /certification/retrieve

### education
* [GET] /education/retrieve

### experience
* [GET] /experience/retrieve

### project
* [GET] /project/retrieve

### skill
* [GET] /skill/retrieve

### visitor
* [GET]  /visitor/count
* [POST] /visitor/create
* [GET]  /visitor/retrieve