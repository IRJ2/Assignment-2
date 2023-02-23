public class Person {
    // create attributes name, surname, and email
    private String name;
    private String surname;
    private String email;

    // constructor
    public Person(String name, String surname, String email) {
        this.name = name;
        this.surname = surname;
        this.email = email;
    }

    //create getters
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
