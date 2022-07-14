# dotsAfrica

Java Sprint Boot ReSTful Application

## Requirements
	1. Java 8 or later
	2. Sprint Boot 4.2.0 or later
	3. Maven 3 or later
	4. JUnit
	5. Postgres installed on your machine

   
### PostgreSQL Setup
We need to create:
* user with name 'dostsafrica' and password 'password'
* database with name 'api_dotsafrica' with owner 'dotsafrica'

#### STEPS
 Open terminal in project directory.

   **LINUX:**
   ```
   $ sudo ./postgres_reset.sh
   ```

## HOW TO RUN REST API
1. If you are using Visual Studio Code, you can simple download **Spring boot dashbord** extension. Navigate to the project directroy. Spring dashboard bar should appear on the right side (aligned with download extension icon). Upon clicking the Sping icon, the option to run the application should be visible.

2. If wish to run via terminal, open terminal in project directory and run the following command.

    ```
    $ mvn spring-boot:run
    ```


**NOTE** Server will be running on: http://127.0.0.1:8080

## ROUTES IMPLEMENTED 
| Purpose of route | HTTP Request Method | Route  | Body | Response |
| :---: | :---: | :---: | :---: | :---:|
| Register user | POST | /api/register | {"username": "..."}| HTTP_200_OK |
| Add item | POST | /api/addItem | {"username": "...", "label": "...", "description,": "..."}| HTTP_200_OK |
| Get items | GET | /api/items/username or add optional params such as {sortBy, pageNumber, pageSize} | - | HTTP_200_OK |
| Get item | GET | /api/item/username?id=itemId | - | HTTP_200_OK |
| Delete item | DELETE | /api/item/username?id=itemId | - | HTTP_200_OK |
| Update item | PUT | /api/item | {"id":"...", "username": "...", "label": "...", "description": "..."}  where label and description are optional field| HTTP_200_OK |
| Update item  status | PUT | /api/item/status | {"username": "...", "id": "...", "status": "..."}| HTTP_200_OK |








