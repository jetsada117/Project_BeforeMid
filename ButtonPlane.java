import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPlane extends JPanel {

    public ButtonPlane() {
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
