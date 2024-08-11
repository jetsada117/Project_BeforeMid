import java.awt.Button;

public class ButtonPM extends Button{
    private int pm;
    private int people;
    private int healthy;
    private float  pantient;
    private int percents;

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

    void setPercents() {
        this.percents = pm/5;
    }

    int getPercents() {
        return percents;
    }

    void setPantient() {
        this.pantient = (float)pm/5*people/100;
    }

    float getPantient() {
        return pantient;
    }

    void setHealthy() {
        this.healthy = people - (int)pantient;
    }

    int getHealthy() {
        return healthy;
    }
}

