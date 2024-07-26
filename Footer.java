import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Label;
import java.awt.TextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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

class ButtonRandom extends JPanel{
    JLabel text = new JLabel("INPUT RAGE OF RANDOM VALUES");
    JTextField text_box = new JTextField();
    JButton confirm = new JButton("RANDOM");

    ButtonRandom() {
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

class ButtonRain  extends JPanel{

    ButtonRain() {
        setSize(150,130);
        setLocation(530,10);
        setLayout(null);
        setBackground(Color.GRAY);

        ImageIcon imageIcon = new ImageIcon("Rain.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(getWidth(), 120, Image.SCALE_SMOOTH); // Scale image to fit button
        imageIcon = new ImageIcon(scaledImage);

        JButton button = new JButton(imageIcon);      
        button.setBackground(Color.GRAY);
        button.setBounds(0, 0, getWidth(), 120);
        add(button);
    }
}
    
class ButtonPlane extends JPanel {

    ButtonPlane() {
        setSize(180,130);
        setLocation(700,10);
        setLayout(null);
        setBackground(Color.GRAY);

        ImageIcon imageIcon = new ImageIcon("Plane.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(getWidth(), 120, Image.SCALE_SMOOTH); // Scale image to fit button
        imageIcon = new ImageIcon(scaledImage);

        JButton button = new JButton(imageIcon);      
        button.setBackground(Color.GRAY);
        button.setBounds(0, 0, getWidth(), 120);
        add(button);
    }
}

class ButtonPeple extends JPanel{
    JButton confirm = new JButton("CONFIRM");
    Label text = new Label("INPUT POPULATION");
    TextField text_box = new TextField();

    ButtonPeple() {

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
    }
}

class ButtonFile extends JPanel{
    JLabel text = new JLabel("INPUT FILE");
    JTextField text_box = new JTextField();
    JButton confirm = new JButton("SELECT");

    ButtonFile() {
        setSize(180,100);
        setLocation(10,20);
        setLayout(null);

        text.setSize(120,20);
        text.setLocation(10,5);
        text.setFont(new Font("Arial", Font.BOLD, 10));
        
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
