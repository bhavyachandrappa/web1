# SayNoToHungerServer
JAVA Spring boot project

## Creating Controller methods in Spring boot

1. Create a new class file for your feature and add controller method in the class. If already relevant file exist, add your controller method in that class.
2. Create a model class in the "Model" directory which will be responsible for holding the data from the database.
3. Create an interface file for your feature inside the "Interfaces" directory inside the "DataLayer" directory (if there is an interface exists for your feature, skip this step).
4. Follow the naming convention for interfaces: prefix the interface names with letter "I".
5. Add declaration of the methods that are required to perform database operations.
6. Create a class file your feature for  in the "DataLayer" directory implementing the interfaces that you have created in the previous step (if the relevant class file already exists, skip this step).
7. Provide definitions for the methods (which you have declared in step 5).
8. Decorate the DataLayer class file (created in step 6) by "@Repository".
9. Create an interface file for your feature inside the "Interfaces" directory inside the "ServiceLayer" directory (if there is an interface exists for your feature, skip this step).
10. Add declaration of the methods that are required to perform business logic.
11. Create a class file your feature for  in the "ServiceLayer" directory implementing the interfaces that you have created in the previous step 3(if the relevant class file already exists, skip this step). Decorate the service class by "@Service".
12. Declare a member which is of the type of the interface you have created in step 3 and decorate it by "@Autowired". This variable should be used to invoke to perform any database operations.
13. Provide definitions for all the methods declared in the interface created in step 9.
14. Now service methods are ready to be consumed from the controller. Declare a member which is of the type of the interface you have created in step 9 and decorate it by "@Autowired".
15. The member variable created in the previous step can be used directly to invoke the methods defined in Service Layer.

I have created a sample by the above mentioned steps for reference. The files which has the name starting with "Test" are the sample files which can be removed later.

To summarize, the program flow will start from the controller, passes through the service layer to the data layer, performs the database operations at the data layer and returns the data to the service layer.
The business logic will be performed in the service layer and the final result will be sent to the controller.
