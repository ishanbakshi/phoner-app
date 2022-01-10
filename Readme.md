# Phone app

This app was created using start.spring.io.
It does not have a User interface. To run the app, run these test files in intellIj:
   
- CustomerRepositoryTest.java
- PhoneNumberDetailsRepositoryTest.java
- CustomerServiceTest.java
- PhoneNumberDetailsService.java


## How to run this app
Use intellIj to run the tests or run maven test.
This  was built using Openjdk-17 but it should be compatible with any java version about 11.

## Design considerations
- Package structure : The code flow should happen in the way :
  - controller-->service-->repository-->database (At present this app does not have a controller. It could be covered if this app had a user-interface or api exposed)
  - h2 database : for the purpose of testing and local development only I have used an in-memory db call h2
  - Phone number is a string : It is not an int type because there could be leading zeroes or country codes like +61.


## Limitations in this design
- Phone number could also be a unique index.
- Lombak boiler plate code removal : Lobmak is a library used to remove a lot of boiler plate code for constructors, getters, setters and builder patterns. This is great for working fast, but it needs to be cleaned if we want to be strict about the security of the object, in terms of deciding which variables are mutable and not.
- Could add better security at repository layer by exposing just the function we need instead of extending JpaRepository.


## References :
1) https://start.spring.io/
2) https://www.baeldung.com/spring-boot-h2-database
3) https://www.baeldung.com/
