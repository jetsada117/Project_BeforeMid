import java.awt.Button;

public class ButtonPM extends Button{
    private int pm;
    private int people;

    void setPm(int pm) {
        this.pm = pm;
    }

    void setPeople(int people) {
        this.people = people;
    }
    
    int getPm() {
        return pm;
    }

    int getPeople() {
        return people;
    }
}

