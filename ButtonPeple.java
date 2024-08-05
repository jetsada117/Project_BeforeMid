import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPeple extends JPanel implements ActionListener {
    JButton confirm = new JButton("CONFIRM");
    Label text = new Label("INPUT POPULATION");
    TextField text_box = new TextField();

    ButtonPeple() {

        setFont(new Font("Arial", Font.PLAIN, 5));
        setSize(130,100);
        setLocation(200,20);
        //setBackground(Color.GREEN);
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

        confirm.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        getValuepeople();
    }

    int getValuepeople() {
        int value = 0;
        try {
            String message = text_box.getText();
            value = Integer.parseInt(message);
            System.out.println("value: " + value);
        } catch (NumberFormatException e) {
            text_box.setText("Please enter a number");
        }

        return value;
    }
}
