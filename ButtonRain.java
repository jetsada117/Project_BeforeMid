import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonRain  extends JPanel{

    public ButtonRain() {
        setSize(150,130);
        setLocation(530,10);
        setLayout(null);
        setBackground(new Color(159,160,159));
        setBorder(null);

        ImageIcon imageIcon = new ImageIcon("Image\\\\Rain.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(getWidth(), 120, Image.SCALE_SMOOTH); // Scale image to fit button
        imageIcon = new ImageIcon(scaledImage);

        JButton button = new JButton(imageIcon);      
        button.setBackground(new Color(159,160,159));
        button.setBounds(0, 0, getWidth(), 120);
        button.setBorder(null);
        add(button);
    }
    
}
