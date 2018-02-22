Here is some instructions for using an application.

Welcome pagepage url: http://localhost:8080/user/

1. If you want to add a new Contact, please
go to : http://localhost:8080/user/form
Input values and press save (all values are required)

2. If toy want to get Contcat be name:
go to : http://localhost:8080/user/byName/{name}
It will redirect you to form with values if Contact exists
or to custom Info page if not extsts

(!)Please provide name for url - I didn't managed to create pafe for entering search parameters
Example:
http://localhost:8080/user/byName/Ihor

3. If you want to get Contact by ID:
go to: http://localhost:8080/user/byId/45
It will redirect you to form with values if Contact exists
or to custom Info page if not extsts


Regarding switching the DB layer:
In this case we should change interface ContactCrudRepository to another one and Autowire it in our ContactRepository
aso change RepositoryMapper in Entity changes and Entity if needed.
So repository and entity packages.

Thanks!