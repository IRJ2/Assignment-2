// This is a Person class that has three attributes: name, surname, and email
public class Person {
    // These are the private fields that store the name, surname, and email
    private String name; 
    private String surname;
    private String email;

    // This is the constructor that takes in a name, surname, and email and
    // initializes the fields
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    // These are the getter methods that return the values of the fields
    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }
}