import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Home {
    public static void main(String[] args) {
        MyFrame frame = new MyFrame();
        frame.setVisible(true);
    }
}    

class MyFrame extends JFrame{
    JPanel pan1 = new JPanel();
    JPanel panside2 = new JPanel();
    JPanel background = new JPanel();

    public MyFrame() {
        setSize(900,600);
        setLocation(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        background.setSize(getWidth(),getHeight());
        background.setLocation(0,0); 
        background.setBackground(Color.BLUE);         

        panside2.setSize(180,420);
        panside2.setLocation(718,0);
        panside2.setBackground(Color.GRAY);             
        
        pan1.setSize(530,420);
        pan1.setLocation(184,0);        
        pan1.setLayout(new GridLayout(10,20));
        pan1.setBackground(Color.BLUE);

        ButtonPM buttonPM = new ButtonPM(10, 20);

        LeftBar sidLeftBar = new LeftBar();
        sidLeftBar.setPanred();
        sidLeftBar.setPanorang();
        sidLeftBar.setPanyellow();
        sidLeftBar.setPangreen();

        Footer footer = new Footer();

        for (int i = 0; i < buttonPM.getRow(); i++) {
            for (int j = 0; j < buttonPM.getCol(); j++) {
                pan1.add(buttonPM.getButton(i, j));
            }
        }

        add(pan1);
        add(sidLeftBar);
        add(panside2);
        add(footer);
        add(background);
    }
}