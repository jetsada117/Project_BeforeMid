import javax.swing.JButton;
import java.awt.Font;


public class set_ButtonStart extends JButton {
   
    public set_ButtonStart(){
        setFont(new Font("Arial", Font.BOLD, 20));
        setSize(200, 60);
        setLocation(350, 150);
        setText("START");  
    }
}
