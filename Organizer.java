import java.awt.Font;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

final class Organizer extends JFrame{
    JPanel background = new JPanel();
    JLabel text = new JLabel("<html><div style='width:600px'>นายเจษฎา พรหมบุตร 66011212160<br><br>นายนฤพล ท่าสะอาด 66011212182<br><br>นายณัฐพงษ์ จันทร์คำพา 66011212087</div></html>"); 
    JLabel box_1 = new JLabel(getImage("Image\\No1.png",180,250));
    JLabel box_2 = new JLabel(getImage("Image\\No2.png",180,250));
    JLabel box_3 = new JLabel(getImage("Image\\No3.png",180,250));

    public Organizer(){
        setSize(900,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);        
        
        background.setSize(900,600);
        background.setLocation(0,0);

        box_1.setSize(180,250);
        box_1.setLocation(100,20);

        box_2.setSize(180,250);
        box_2.setLocation(360,20);

        box_3.setSize(180,250);
        box_3.setLocation(600,20);

        text.setSize(600,300);
        text.setLocation(150,250);
        text.setFont(new Font("Tahoma", Font.BOLD, 30));

        JLabel imgback = new JLabel(getImage("Image\\\\Background_page3.jpg",900,600));

        background.add(imgback);  
        add(box_1);
        add(box_2);
        add(box_3);
        add(text);   
        add(background);  
    }
    
    ImageIcon getImage(String filename,int width,int height) {
        ImageIcon img = new ImageIcon(filename);
        Image image1 = img.getImage();
        Image image2 = image1.getScaledInstance(width,height,Image.SCALE_SMOOTH);
        ImageIcon imageIcon1 = new ImageIcon(image2);

        return imageIcon1;
    }
}
