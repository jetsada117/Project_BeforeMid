import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonRandom extends JPanel{
    JLabel text = new JLabel("INPUT RAGE OF RANDOM VALUES");
    JTextField text_box = new JTextField();
    JButton confirm = new JButton("RANDOM");

    public ButtonRandom() {
        setSize(180,100);
        setLocation(340,20);
        setLayout(null);
        
        text.setSize(160,20);
        text.setLocation(10,5);
        text.setFont(new Font("Arial", Font.BOLD, 9));
        
        text_box.setSize(160,20);
        text_box.setLocation(10,25);

        confirm.setSize(160,40);
        confirm.setLocation(10,55);
        confirm.setFont(new Font("Arial", Font.BOLD, 10));

        add(text);
        add(text_box);
        add(confirm);
    }
}
