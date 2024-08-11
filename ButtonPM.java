import java.awt.Button;

public class ButtonPM extends Button{
    private int pm;
    private int people;

    ButtonPM(int pm,int people) {
        this.pm = pm;
        this.people = people;
    }
    
    int getPm() {
        return pm;
    }

    int getPeople() {
        return people;
    }
}

