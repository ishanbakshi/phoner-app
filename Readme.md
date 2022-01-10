# Phone app

this app does this .... text goes here


## How to run this app
yadii yadii yadaaa ... some text goes here.

## Design considerations
yadii yadii yadaaa ... some text goes here.

## Limitations in this design
- Package structure : since this is a small app all the classes are in the same package. Ideally I would break it down into different packages.
- Phone number is a string : It is not an int type because there could be leading zeroes or country codes like +61.
- Phone number could also be a unique index.
- Lombak boiler plate code removal : Lobmak is a library used to remove a lot of boiler plate code for constructors, getters, setters and builder patterns. This is great for working fast, but it needs to be cleaned if we want to be strict about the security of the object, in terms of deciding which variables are mutable and not.


## References :
1) https://start.spring.io/
2) https://www.baeldung.com/spring-boot-h2-database
