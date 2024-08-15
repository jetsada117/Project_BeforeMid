import java.awt.Button;
import java.awt.Color;

public class ButtonPM extends Button{
    private int pm;
    private int people;
    private int healthy;
    private float  pantient;
    private int percents;
    private int x;
    private int y;

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
        if (people == 0 ) {
            this.percents = 0;
        }else {
            this.percents = pm/5;
        }
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

    void setPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    int getRow() {
        return x;
    }

    int getColumn() {
        return y;
    }

    void setBackgroundColor() {
        if (percents >= 30) {
            setBackground(Color.RED);
        }
        else if (percents >= 20) {
            setBackground(Color.ORANGE);
        }
        else if (percents >= 10) {
            setBackground(Color.YELLOW);
        }
        else {
            setBackground(Color.GREEN);
        } revalidate();
    }
}

