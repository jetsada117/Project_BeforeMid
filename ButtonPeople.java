import java.awt.Font;
import javax.swing.JButton;

public class ButtonPeople extends JButton {
    private int people = 0;

    ButtonPeople() {
        setText("CONFIRM");
        setSize(120,40);
        setLocation(5,55);
        setFont(new Font("Arial", Font.BOLD, 10));
    }

    void setPeople(int people) {
        this.people = people;
    }

    int getPeople() {
        return people;
    }
}
