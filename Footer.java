import java.awt.Color;
import javax.swing.JPanel;

public class Footer extends JPanel {
    public Footer() {
        setSize(900,177);
        setLocation(0,423);
        setLayout(null);
        setBackground(Color.GRAY);

        ButtonFile btnFile = new ButtonFile();
        ButtonPeple btnPP = new ButtonPeple();
        ButtonRandom btnRan = new ButtonRandom();
        ButtonRain btnRain = new ButtonRain();
        ButtonPlane btnPlane = new ButtonPlane();

        add(btnPP);
        add(btnFile);
        add(btnRan);
        add(btnRain);
        add(btnPlane);
    }
}

