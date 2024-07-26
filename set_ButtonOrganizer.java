import java.awt.Font;
import javax.swing.JButton;


public class set_ButtonOrganizer extends JButton {
    
    public set_ButtonOrganizer(){
        setFont(new Font("Arial", Font.BOLD, 20));
        setSize(200, 60);
        setLocation(350, 250);
        setText("ORGANIZER");
    }
}

