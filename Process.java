import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;

class Process extends JFrame {
    JPanel pancenter = new JPanel();
    JPanel background = new JPanel();
    LeftBar sidLeftBar = new LeftBar();
    RightBar sidRightBar = new RightBar();
    Footer footer = new Footer();
    ButtonFile buttonfile = new ButtonFile();
        
    public Process() {
        setSize(900,600);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        
        background.setSize(900,600);
        background.setLocation(0,0); 
        background.setBackground(new Color(211,211,211));  
        background.setLayout(new BorderLayout());       
        
        pancenter.setSize(500,400);
        pancenter.setLocation(195,0);        
        pancenter.setLayout(new GridLayout(10,20,0,2));
        pancenter.setBackground(new Color(211,211,211));

        add(pancenter, BorderLayout.CENTER);
        add(sidLeftBar);
        add(sidRightBar);
        add(footer);
        add(background);
    }

    void showButton(ActionEvent e, int value) {
        pancenter.removeAll();
        int [][] valuePm = buttonfile.getValuePm();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {

                ButtonPM button = new ButtonPM(valuePm[i][j], value);
                pancenter.add(button);

                button.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        int x = button.getPm();
                        int y = button.getPeople();
                        System.out.println(x + " " + y);
                    }
                });
            }
        }

        pancenter.revalidate();
    }
}