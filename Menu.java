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
    ImageIcon img = new ImageIcon("Image\\Img_menu.jpg");
    Image image1 = img.getImage();
    Image image2 = image1.getScaledInstance(900,600,Image.SCALE_SMOOTH);
    ImageIcon imageIcon1 = new ImageIcon(image2);
    JLabel imgback = new JLabel(imageIcon1);        
    JButton ButtonStart = new JButton();
    JButton buttonor = new JButton();          
    JButton buttonend = new JButton();

    boolean isFrameShow = true;

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

        ButtonStart.setFont(font);
        ButtonStart.setSize(200, 60);
        ButtonStart.setLocation(350, 150);
        ButtonStart.setText("START");  


        buttonor.setFont(font);
        buttonor.setSize(200, 60);
        buttonor.setLocation(350, 250);
        buttonor.setText("ORGANIZER");


        buttonend.setFont(font);
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
        ButtonStart.addActionListener(this);
        buttonor.addActionListener(this);
        buttonend.addActionListener(this);
    }
    void ClickSt(ActionEvent e) {
        Process frame = new Process();
        frame.setVisible(true);
    }

    void ClickOr(ActionEvent e) {
        Organizer frame = new Organizer();
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {        
        if (e.getSource() == ButtonStart) {
            // set flag โปรแกรมมีการทำงานอยู่แล้วจะไม่แสดงซ้ำ
            if (isFrameShow) {
                ClickSt(e);
                isFrameShow = false;
            }
        } 
        else if (e.getSource() == buttonor) {
            if (isFrameShow) {
                ClickOr(e);
                isFrameShow = false;
            }
        } 
        else {
            System.exit(0); // close program
        }
    }  
      
    @Override
    public void windowClosed(WindowEvent e) {
        isFrameShow = true;
    }

    @Override
    public void windowOpened(WindowEvent e) {}
    @Override
    public void windowClosing(WindowEvent e) {}

    @Override
    public void windowIconified(WindowEvent e) {}
    @Override
    public void windowDeiconified(WindowEvent e) {}
    @Override
    public void windowActivated(WindowEvent e) {}
    @Override
    public void windowDeactivated(WindowEvent e) {}

}

