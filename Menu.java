import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Menu {
    public static void main(String[] args){
        MyFramework frame = new MyFramework();
        frame.setVisible(true);  
    }
}

class MyFramework extends JFrame implements ActionListener, WindowListener{
    JLabel text = new JLabel("PM 2.5");
    JPanel background = new JPanel();
    ImageIcon img = new ImageIcon("Image\\Img_menu.jpg");//เรียกใฟล์ภาพ
    Image image1 = img.getImage();//รับ ไฟส์รูป
    Image image2 = image1.getScaledInstance(900,600,Image.SCALE_SMOOTH);//ปรับขนาดรูป
    ImageIcon imageIcon1 = new ImageIcon(image2);//set รูปเป็นไอคอน
    JLabel imgback = new JLabel(imageIcon1);//นำรุปไปsetลง JLabel        
    JButton buttonstart = new JButton();
    JButton buttonor = new JButton();          
    JButton buttonexit = new JButton();
    private final Process process = new Process();
    private final Organizer organizer = new Organizer();

    boolean isframeshow = true;

    public MyFramework(){
        setSize(900,600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(null);

        background.setSize(900,600);
        background.setLocation(0,-10);
        background.setBackground(Color.WHITE);
        background.setLayout(new BorderLayout());
        Font font = new Font("Arial", Font.BOLD, 20); 

        buttonstart.setFont(font);
        buttonstart.setSize(200, 60);
        buttonstart.setLocation(350, 150);
        buttonstart.setText("START");  

        buttonor.setFont(font);
        buttonor.setSize(200, 60);
        buttonor.setLocation(350, 250);
        buttonor.setText("ORGANIZER");

        buttonexit.setFont(font);
        buttonexit.setSize(200, 60);
        buttonexit.setLocation(350, 350);
        buttonexit.setText("EXIT");

        
        text.setSize(300, 120);
        text.setLocation(350, 20);
        text.setFont(new Font("Comic Sans MS", Font.BOLD, 60));

        background.add(imgback);
        add(text);
        add(buttonexit);
        add(buttonor);
        add(buttonstart);
        add(background);

        // กดปุ่มเพื่อเรียกหน้าถัดไป
        buttonstart.addActionListener(this);
        buttonor.addActionListener(this);
        buttonexit.addActionListener(this);
        process.addWindowListener(this);
        organizer.addWindowListener(this);
    }

    void ClickStart(ActionEvent e) {
        process.setVisible(true);
    }

    void ClickOrgan(ActionEvent e) {
        organizer.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        if (e.getSource() == buttonstart) {
            // set flag โปรแกรมมีการทำงานอยู่แล้วจะไม่แสดงซ้ำ
            if (isframeshow) {
                ClickStart(e);
                isframeshow = false;
            }
        } 
        else if (e.getSource() == buttonor) {
            // set flag โปรแกรมมีการทำงานอยู่แล้วจะไม่แสดงซ้ำ
            if (isframeshow) {
                ClickOrgan(e);
                isframeshow = false;
            }
        } 
        else {
            System.exit(0); // close program
        }
    }      
    
    @Override
    public void windowClosing(WindowEvent e) {
        isframeshow = true;//จะกำหนดค่า true แล้วส่งค่ากับไปให้สามารถทำงานใหม่
    }
      
    @Override
    public void windowClosed(WindowEvent e) {}

    @Override
    public void windowOpened(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}

    @Override
    public void windowDeiconified(WindowEvent e) {}

    @Override
    public void windowActivated(WindowEvent e) {}

    @Override
    public void windowDeactivated(WindowEvent e) {}

}

 