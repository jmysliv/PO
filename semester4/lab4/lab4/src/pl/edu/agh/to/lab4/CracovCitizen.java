package pl.edu.agh.to.lab4;

public class CracovCitizen extends Suspect {
    private int age;

    public CracovCitizen(String firstname, String lastname, int age) {
        super(firstname, lastname);
        this.age = age;
    }

    public int getAge() {
        return age;
    }


    @Override
    public boolean isSuspected() {
        return getAge() > 18;
    }
}
