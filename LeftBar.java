import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeftBar extends JPanel{
    JPanel panred = new JPanel();
    JPanel panorang = new JPanel();
    JPanel panyellow = new JPanel();
    JPanel pangreen = new JPanel();

    LeftBar() {
        setSize(180,420);
        setLocation(0,0);
        setBackground(new Color(159,160,159));
        setLayout(null);

        add(panred);        
        add(panorang);
        add(panyellow);
        add(pangreen);        
    }

    void setPanred() {
        panred.setSize(160,90);
        panred.setLocation(10,10);
        panred.setBackground(new Color(159,160,159));
        panred.setLayout(null);

        JPanel color_box = new JPanel();
        JLabel text = new JLabel("<html>มีคนป่วยเกิน 30% ของประชากรในพื้นที่</html>");

        color_box.setSize(50,50);
        color_box.setLocation(0,15);
        color_box.setBackground(Color.RED);

        text.setFont(new Font("Tahoma", Font.BOLD, 10));
        text.setSize(105,60);
        text.setLocation(55,10);
        text.setForeground(Color.WHITE);

        panred.add(color_box);
        panred.add(text);
    }

    void setPanorang() {
        panorang.setSize(160,90);
        panorang.setLocation(10,100);
        panorang.setBackground(new Color(159,160,159));
        panorang.setLayout(null);

        JPanel color_box = new JPanel();
        JLabel text = new JLabel("<html>มีคนป่วย 20-29% ของประชากรในพื้นที่</html>");

        color_box.setSize(50,50);
        color_box.setLocation(0,15);
        color_box.setBackground(Color.ORANGE);

        text.setFont(new Font("Tahoma", Font.BOLD, 10));
        text.setSize(105,60);
        text.setLocation(55,10);
        text.setForeground(Color.WHITE);

        panorang.add(color_box);
        panorang.add(text);
    }

    void setPanyellow() {
        panyellow.setSize(160,90);
        panyellow.setLocation(10,190);
        panyellow.setBackground(new Color(159,160,159));
        panyellow.setLayout(null);

        JPanel color_box = new JPanel();
        JLabel text = new JLabel("<html>มีคนป่วย 10-19% ของประชากรในพื้นที่</html>");

        color_box.setSize(50,50);
        color_box.setLocation(0,15);
        color_box.setBackground(Color.YELLOW);

        text.setFont(new Font("Tahoma", Font.BOLD, 10));
        text.setSize(105,60);
        text.setLocation(55,10);
        text.setForeground(Color.WHITE);

        panyellow.add(color_box);
        panyellow.add(text);
    }

    void setPangreen() {
        pangreen.setSize(160,90);
        pangreen.setLocation(10,280);
        pangreen.setBackground(new Color(159,160,159));
        pangreen.setLayout(null);

        JPanel color_box = new JPanel();
        JLabel text = new JLabel("<html>มีคนป่วย 0-9% ของประชากรในพื้นที่</html>");

        color_box.setSize(50,50);
        color_box.setLocation(0,15);
        color_box.setBackground(Color.GREEN);

        text.setFont(new Font("Tahoma", Font.BOLD, 10));
        text.setSize(105,60);
        text.setLocation(55,10);
        text.setForeground(Color.WHITE);

        pangreen.add(color_box);
        pangreen.add(text);
    }
}
