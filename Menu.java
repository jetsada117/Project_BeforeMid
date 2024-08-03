import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu {
    public static void main(String[] in){
        MyFramework frame = new MyFramework();
        frame.setVisible(true);  
    }
}
class MyFramework extends JFrame implements MouseListener{
    JLabel text = new JLabel("PM 2.5");
    JPanel background = new JPanel();
    ImageIcon img = new ImageIcon("Image\\Img_menu.jpg");
    Image image1 = img.getImage();
    Image image2 = image1.getScaledInstance(900,600,Image.SCALE_SMOOTH);
    ImageIcon imageIcon1 = new ImageIcon(image2);
    JLabel imgback = new JLabel(imageIcon1);        
    JButton ButtonStart = new JButton();
    JButton buttonor = new JButton();          
    JButton buttonend = new JButton(); 
    boolean isFrameShow = false;

    public MyFramework(){
        setSize(900,600);
        setLocation(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        background.setSize(900,600);
        background.setLocation(0,-5);
        background.setBackground(Color.WHITE);

        

        ButtonStart.setFont(new Font("Arial", Font.BOLD, 20));
        ButtonStart.setSize(200, 60);
        ButtonStart.setLocation(350, 150);
        ButtonStart.setText("START");  


        buttonor.setFont(new Font("Arial", Font.BOLD, 20));
        buttonor.setSize(200, 60);
        buttonor.setLocation(350, 250);
        buttonor.setText("ORGANIZER");


        buttonend.setFont(new Font("Arial", Font.BOLD, 20));
        buttonend.setSize(200, 60);
        buttonend.setLocation(350, 350);
        buttonend.setText("EXIT");

        
        text.setSize(300, 120);
        text.setLocation(350, 20);
        text.setFont(new Font("Comic Sans MS", Font.BOLD, 60));

        background.add(imgback);
        add(text);
        add(buttonend);
        add(buttonor);
        add(ButtonStart);
        add(background);

        // กดปุ่มเพื่อเรียกหน้าถัดไป
        ButtonStart.addMouseListener(this);
        buttonor.addMouseListener(this);
        buttonend.addMouseListener(this);
    }

    void ClickSt(MouseEvent e) {
        Process frame = new Process();
        frame.setVisible(true);
    }

    void ClickOr(MouseEvent ex) {
        Organizer frame = new Organizer();
        frame.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource() == ButtonStart) {
            // set flag โปรแกรมมีการทำงานอยู่แล้วจะไม่แสดงซ้ำ
            if (!isFrameShow) {
                ClickSt(e);
                isFrameShow = true;
            }
        }
        else if (e.getSource() == buttonor) {
            if (!isFrameShow) {
                ClickOr(e);
                isFrameShow = true;
            }
        }
        else {
            System.exit(0); // close program
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {
        isFrameShow = false;
    }
}

