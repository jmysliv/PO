package pl.edu.agh.to.lab4;

public abstract class Suspect {
    private final String firstname;
    private final String lastname;

    public Suspect(String firstname, String lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
    }

    public String display() {
        return getFirstname() + " " + getLastname();
    }

    public String getFirstname() {
        return firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public abstract boolean isSuspected();

    public abstract int getAge();
}
