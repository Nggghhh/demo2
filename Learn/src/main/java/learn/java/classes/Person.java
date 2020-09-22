package learn.java.classes;

import java.util.Objects;

public abstract class Person {
    protected int id;
    protected String name;
    protected String lastName;
    protected String patronym;

    public Person() {

    }

    public Person(int id, String name, String lastName, String patronym) {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.patronym = patronym;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", patronym='" + patronym + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return id == person.id &&
                Objects.equals(name, person.name) &&
                Objects.equals(lastName, person.lastName) &&
                Objects.equals(patronym, person.patronym);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, lastName, patronym);
    }

    public void printPersonalData() {
        System.out.println("\n" + "Full name: " + getFullName());
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPatronym(String patronym) {
        this.patronym = patronym;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFullName() {
        return name + " " + lastName + " " + patronym;
    }

    ;

    public String getLastName() {
        return lastName;
    }

    public String getPatronym() {
        return patronym;
    }
}
