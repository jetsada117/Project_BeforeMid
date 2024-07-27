import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonRandom extends JPanel{
    JLabel text = new JLabel("INPUT RANDOM POPULATION");
    JLabel to = new JLabel("To");
    JTextField text_box1 = new JTextField();
    JTextField text_box2 = new JTextField();
    JButton confirm = new JButton("RANDOM");

    public ButtonRandom() {
        setSize(180,100);
        setLocation(340,20);
        setLayout(null);
        
        text.setSize(160,20);
        text.setLocation(10,5);
        text.setFont(new Font("Arial", Font.BOLD, 10));

        to.setSize(20,20);
        to.setLocation(75,25);
        to.setFont(new Font("Arial", Font.BOLD, 15));
        
        text_box1.setSize(60,20);
        text_box1.setLocation(10,25);

        text_box2.setSize(60,20);
        text_box2.setLocation(100,25);

        confirm.setSize(160,40);
        confirm.setLocation(10,55);
        confirm.setFont(new Font("Arial", Font.BOLD, 10));

        add(text);
        add(to);
        add(text_box1);
        add(text_box2);
        add(confirm);
    }
}
