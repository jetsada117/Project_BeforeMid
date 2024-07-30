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
class MyFramework extends JFrame{
    JLabel text = new JLabel("PM 2.5");
    JPanel background = new JPanel();
    ImageIcon img = new ImageIcon("Image\\\\Img_menu.jpg");
    Image image1 = img.getImage();
    Image image2 = image1.getScaledInstance(900,600,Image.SCALE_SMOOTH);
    ImageIcon imageIcon1 = new ImageIcon(image2);
    JLabel imgback = new JLabel(imageIcon1);
    boolean isFrameShow = false;

    public MyFramework(){
        setSize(900,600);
        setLocation(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        background.setSize(900,600);
        background.setLocation(0,0);
        background.setBackground(Color.WHITE);

        
        JButton ButtonStart = new JButton();
        ButtonStart.setFont(new Font("Arial", Font.BOLD, 20));
        ButtonStart.setSize(200, 60);
        ButtonStart.setLocation(350, 150);
        ButtonStart.setText("START");  

        JButton buttonor = new JButton();
        buttonor.setFont(new Font("Arial", Font.BOLD, 20));
        buttonor.setSize(200, 60);
        buttonor.setLocation(350, 250);
        buttonor.setText("ORGANIZER");

        JButton buttonend = new JButton();
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
        ButtonStart.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
                // set flag โปรแกรมมีการทำงานอยู่แล้วจะไม่แสดงซ้ำ
                if (!isFrameShow) {
                    Click(e);
                    isFrameShow = true;
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
            
        });
    }

    void Click(MouseEvent e) {
        Process frame = new Process();
        frame.setVisible(true);
    }
}

