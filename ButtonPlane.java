import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class ButtonPlane extends JButton{
    
    public ButtonPlane() {
        ImageIcon imageIcon = new ImageIcon("Image\\Plane.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(180, 130, Image.SCALE_SMOOTH); // Scale image to fit button
        imageIcon = new ImageIcon(scaledImage);

        setIcon(imageIcon);     
        setBackground(new Color(159,160,159));
        setPreferredSize(new Dimension(180, 130));
        setBorder(null);
    }
}
