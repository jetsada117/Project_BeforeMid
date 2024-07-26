import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Organizer {
    public static void main(String[] args){
    MyFrameOR frame = new MyFrameOR();
    frame.setVisible(true);
    }
}

class MyFrameOR extends JFrame{
    JPanel background = new JPanel();
    // JPanel textbox = new JPanel();
    JLabel text = new JLabel("<html>นาย เจษฎา พรหมบุตร 66011212160<br><br>นาย นฤพล ท่าสะอาด 66011212182<br><br>นาย ณัฐพงษ์ จันทร์คำพา 66011212087</html>"); 
    JPanel box_1 = new JPanel();
    JPanel box_2 = new JPanel();
    JPanel box_3 = new JPanel();

    ImageIcon img = new ImageIcon("Background_page3.jpg");
    Image image1 = img.getImage();
    Image image2 = image1.getScaledInstance(900,600,Image.SCALE_SMOOTH);
    ImageIcon imageIcon1 = new ImageIcon(image2);
    JLabel imgback = new JLabel(imageIcon1);

    public MyFrameOR(){
        setSize(900,600);
        setLocation(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);        
        
        background.setSize(900,600);
        // background.setBackground(Color.blue);
        background.setLocation(0,0);

        box_1.setSize(150,250);
        box_1.setLocation(150,20);
        box_1.setBackground(Color.BLACK);

        box_2.setSize(150,250);
        box_2.setLocation(375,20);
        box_2.setBackground(Color.BLACK);

        box_3.setSize(150,250);
        box_3.setLocation(600,20);
        box_3.setBackground(Color.BLACK);

        text.setSize(600,300);
        text.setLocation(150,250);
        text.setFont(new Font("Tahoma", Font.BOLD, 30));

        background.add(imgback);  
        add(box_1);
        add(box_2);
        add(box_3);
        add(text);   
        add(background);  

    } 
}
