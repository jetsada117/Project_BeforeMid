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
    JPanel pan3 = new JPanel();
    JPanel pink = new JPanel();

    public MyFrame() {
        setSize(900,600);
        setLocation(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        pink.setSize(getWidth(),getHeight());
        pink.setLocation(0,0); 
        pink.setBackground(Color.GREEN);         

        panside2.setSize(getWidth()*20/100,getHeight()*70/100);
        panside2.setLocation(725,0);
        panside2.setBackground(Color.GRAY);             
        
        pan1.setSize(getWidth()*60/100,getHeight()*70/100);
        pan1.setLocation(183,0);        
        pan1.setLayout(new GridLayout(10,20));

        pan3.setSize(getWidth(),getHeight()*25/100);
        pan3.setLocation(0,423);
        pan3.setLayout(null);
        pan3.setBackground(Color.GRAY);

        ButtonPeple btnPP = new ButtonPeple();

        ButtonPM buttonPM = new ButtonPM(10, 20);

        ButtonFile btnF = new ButtonFile();

        LeftBar sidLeftBar = new LeftBar();

        for (int i = 0; i < buttonPM.getRow(); i++) {
            for (int j = 0; j < buttonPM.getCol(); j++) {
                pan1.add(buttonPM.getButton(i, j));
            }
        }

        pan3.add(btnPP);
        pan3.add(btnF);
        add(pan1);
        add(sidLeftBar);
        add(panside2);
        add(pan3);
        add(pink);
    }
}