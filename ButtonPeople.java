import java.awt.Font;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class ButtonPeople extends JPanel implements ActionListener {
    JButton confirm = new JButton("CONFIRM");
    Label text = new Label("INPUT POPULATION");
    TextField text_box = new TextField();
    int value = 0;

    ButtonPeople() {

        setFont(new Font("Arial", Font.PLAIN, 5));
        setSize(130,100);
        setLocation(200,20);
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
        
        try {
            String message = text_box.getText();
            value = Integer.parseInt(message);
            System.out.println("value: " + value);
            
            Process process = (Process) SwingUtilities.getWindowAncestor(this);
            if (process != null) {
                process.showButton(e, value); // Pass the updated value to showButton
            }
        } catch (NumberFormatException ex) {
            text_box.setText("Please enter a number");
        }
    }
}
