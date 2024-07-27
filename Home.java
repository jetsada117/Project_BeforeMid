import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
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
    JLabel dust = new JLabel("<html>Dust = 100</html>");
    JLabel pop = new JLabel("<html>Population = 5000</html>");
    JLabel heal = new JLabel("<html>Healthy = 4000</html>");
    JLabel pantient = new JLabel("<html>Patiant = 1000</html>");
    JLabel percen = new JLabel("<html>PercentPatient = 20%</html>");
    Font font = new Font("Tahoma", Font.BOLD, 12);

    public MyFrame() {
        setSize(900,600);
        setLocation(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);
        
        background.setSize(getWidth(),getHeight());
        background.setLocation(0,0); 
        background.setBackground(new Color(211,211,211));         

        panside2.setSize(180,420);
        panside2.setLocation(718,0);
        panside2.setBackground(new Color(159,160,159));
        panside2.setLayout(null);
        
        dust.setSize(160,50);
        dust.setLocation(10,10);
        dust.setFont(font);
        dust.setForeground(Color.WHITE);

        pop.setSize(160,50);
        pop.setLocation(10,65);
        pop.setFont(font);
        pop.setForeground(Color.WHITE);

        heal.setSize(160,50);
        heal.setLocation(10,120);
        heal.setFont(font);
        heal.setForeground(Color.WHITE);

        pantient.setSize(160,50);
        pantient.setLocation(10,175);
        pantient.setFont(font);
        pantient.setForeground(Color.WHITE);

        percen.setSize(160,50);
        percen.setLocation(10,230);
        percen.setFont(font);
        percen.setForeground(Color.WHITE);
        
        panside2.add(dust);
        panside2.add(pop);
        panside2.add(heal);
        panside2.add(pantient);        
        panside2.add(percen);
        
        pan1.setSize(530,420);
        pan1.setLocation(184,0);        
        pan1.setLayout(new GridLayout(10,20));
        pan1.setBackground(new Color(211,211,211));

        ButtonPM buttonPM = new ButtonPM(10, 20);

        LeftBar sidLeftBar = new LeftBar();

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