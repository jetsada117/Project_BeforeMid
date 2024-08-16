import java.awt.Font;
import javax.swing.JButton;

public class ButtonRandom extends JButton{
    private int start;
    private int end;

    public ButtonRandom() {
        setText("RANDOM");
        setSize(160,40);
        setLocation(10,55);
        setFont(new Font("Arial", Font.BOLD, 10));
    }

    void setStart(int start) {
        this.start = start;
    }

    void setEnd(int end) {
        this.end = end;
    }

    int getRandomNumber() {
        return (int) (Math.random() * (end - start + 1)) + start;
    }
}
