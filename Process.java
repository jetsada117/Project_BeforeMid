import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Process extends JFrame{
    JPanel pancenter = new JPanel();
    JPanel background = new JPanel();
        
    public Process() {
        setSize(900,600);
        setLocation(400,200);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        
        background.setSize(getWidth(),getHeight());
        background.setLocation(0,0); 
        background.setBackground(new Color(211,211,211));         
        
        pancenter.setSize(530,420);
        pancenter.setLocation(184,0);        
        pancenter.setLayout(new GridLayout(10,20));
        pancenter.setBackground(new Color(211,211,211));

        ButtonPM buttonPM = new ButtonPM(10, 20);

        LeftBar sidLeftBar = new LeftBar();

        RightBar sidRightBar = new RightBar();

        Footer footer = new Footer();

        for (int i = 0; i < buttonPM.getRow(); i++) {
            for (int j = 0; j < buttonPM.getCol(); j++) {
                pancenter.add(buttonPM.getButton(i, j));
            }
        }

        add(pancenter);
        add(sidLeftBar);
        add(sidRightBar);
        add(footer);
        add(background);
    }
}