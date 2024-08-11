import java.awt.Color;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ButtonRain  extends JButton{

    public ButtonRain() {
        ImageIcon imageIcon = new ImageIcon("Image\\Rain.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(150, 120, Image.SCALE_SMOOTH); // Scale image to fit button
        imageIcon = new ImageIcon(scaledImage);
 
        setIcon(imageIcon);
        setBackground(new Color(159,160,159));
        setBounds(530, 10, 150, 120);
        setBorder(null);
    }
    
}
