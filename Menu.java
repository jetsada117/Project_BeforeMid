import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Image;

public class Menu {
    public static void main(String[] in){
        MyFramework frame = new MyFramework();
        frame.setVisible(true);  
    }
}
class MyFramework extends JFrame{
    JLabel jLabel = new JLabel("PM 2.5");
    JPanel jPanel1 = new JPanel();
    ImageIcon img = new ImageIcon("Image\\\\Img_menu.jpg");
    Image image1 = img.getImage();
    Image image2 = image1.getScaledInstance(900,600,Image.SCALE_SMOOTH);
    ImageIcon imageIcon1 = new ImageIcon(image2);
    JLabel imgback = new JLabel(imageIcon1);

    public MyFramework(){
        setSize(900,600);
        setLocation(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        jPanel1.setSize(900,600);
        jPanel1.setLocation(0,0);
        jPanel1.setBackground(Color.WHITE);

        
        set_ButtonStart ButtonStart = new set_ButtonStart();
        set_ButtonOrganizer buttonoborganizer = new set_ButtonOrganizer();
        set_Logout buttonend = new set_Logout();
        
        
        jLabel.setSize(300, 120);
        jLabel.setLocation(350, 20);
        jLabel.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
        
        jPanel1.add(imgback);
        add(jLabel);
        add(buttonend);
        add(buttonoborganizer);
        add(ButtonStart);
        add(jPanel1);
    }
}

