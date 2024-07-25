import java.awt.Color;
import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPeple extends JPanel{
    JButton confirm = new JButton("CONFIRM");
    Label text = new Label("INPUT POPULATION");
    TextField text_box = new TextField();

    ButtonPeple() {

        setFont(new Font("Arial", Font.PLAIN, 5));
        setSize(130,100);
        setLocation(300,20);
        setBackground(Color.GREEN);
        setLayout(null);        
        
        confirm.setSize(120,40);
        confirm.setLocation(5,55);
        confirm.setFont(new Font("Arial", Font.BOLD, 10));

        text.setSize(120,20);
        text.setLocation(10,5);
        text.setFont(new Font("Arial", Font.BOLD, 10));

        text_box.setSize(110,20);
        text_box.setLocation(10,25);
        text_box.setFont(new Font("Arial", Font.PLAIN, 10));



        add(confirm);
        add(text);
        add(text_box);
    }
}
