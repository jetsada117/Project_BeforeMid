import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonFile extends JPanel{
    JLabel text = new JLabel("INPUT FILE");
    JTextField text_box = new JTextField();
    JButton confirm = new JButton("SELECT");

    public ButtonFile() {
        setSize(180,100);
        setLocation(10,20);
        setLayout(null);

        text.setSize(120,20);
        text.setLocation(10,10);
        text.setFont(new Font("Arial", Font.BOLD, 10));
        
        text_box.setSize(160,20);
        text_box.setLocation(10,30);

        confirm.setSize(160,40);
        confirm.setLocation(10,55);
        confirm.setFont(new Font("Arial", Font.BOLD, 10));

        add(text);
        add(text_box);
        add(confirm);
    }
}
