import java.awt.Color;
import javax.swing.JPanel;

public class LeftBar extends JPanel{
    JPanel panred = new JPanel();
    JPanel panorang = new JPanel();
    JPanel panyellow = new JPanel();
    JPanel pangreen = new JPanel();
    LeftBar() {
        setSize(180,420);
        setLocation(0,0);
        setBackground(Color.GRAY);
        setLayout(null);

        panred.setSize(160,90);
        panred.setLocation(10,10);

        panorang.setSize(160,90);
        panorang.setLocation(10,110);

        panyellow.setSize(160,90);
        panyellow.setLocation(10,210);

        pangreen.setSize(160,90);
        pangreen.setLocation(10,310);

        add(panred);
        add(panorang);
        add(panyellow);
        add(pangreen);
    }
}
