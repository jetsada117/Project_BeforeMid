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
    JPanel pan2 = new JPanel();
    JPanel pan3 = new JPanel();
    JPanel pink = new JPanel();

    public MyFrame() {
        setSize(900,600);
        setLocation(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        pink.setSize(getWidth(),getHeight());
        pink.setLocation(0,0); 
        pink.setBackground(Color.PINK);        

        pan2.setSize(getWidth()*30/100,getHeight()*70/100);
        pan2.setLocation(0,0);
        pan2.setBackground(Color.yellow);        
        
        pan1.setSize(getWidth()*67/100,getHeight()*70/100);
        pan1.setLocation(pan2.getWidth()+5,0);        
        pan1.setBackground(Color.BLACK);
        pan1.setLayout(new GridLayout(10,20));

        pan3.setSize(getWidth(),getHeight()*25/100);
        pan3.setLocation(0,pan1.getHeight()+5);
        pan3.setLayout(null);
        pan3.setBackground(Color.blue);

        ButtonPeple btnPP = new ButtonPeple();

        ButtonPM buttonPM = new ButtonPM(10, 20);

        for (int i = 0; i < buttonPM.getRow(); i++) {
            for (int j = 0; j < buttonPM.getCol(); j++) {
                pan1.add(buttonPM.getButton(i, j));
            }
        }

        pan3.add(btnPP);
        add(pan1);
        add(pan2);
        add(pan3);
        add(pink);
    }
}