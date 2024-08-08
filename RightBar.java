import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class RightBar extends JPanel {
    JLabel dust = new JLabel("<html>Dust = 100</html>");
    JLabel pop = new JLabel("<html>Population = 5000</html>");
    JLabel heal = new JLabel("<html>Healthy = 4000</html>");
    JLabel pantient = new JLabel("<html>Patiant = 1000</html>");
    JLabel percen = new JLabel("<html>PercentPatient = 20%</html>");
    Font font = new Font("Tahoma", Font.BOLD, 12);

    public RightBar() {
        setSize(180,420);
        setLocation(718,0);
        setBackground(new Color(159,160,159));
        setLayout(null);

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
        
        add(dust);
        add(pop);
        add(heal);
        add(pantient);        
        add(percen);
    }
}
