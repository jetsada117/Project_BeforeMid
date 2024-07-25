import java.awt.Color;
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
        setBackground(Color.GRAY);
        setLayout(null);

        add(panred);        
        add(panorang);
        add(panyellow);
        add(pangreen);        
    }

    void setPanred() {
        panred.setSize(160,90);
        panred.setLocation(10,10);
        panred.setLayout(null);

        JPanel color_box = new JPanel();
        JLabel text = new JLabel("มีคนป่วยเกิน 30% ของประชากรในพื้นที่");

        color_box.setSize(60,60);
        color_box.setLocation(10,15);
        color_box.setBackground(Color.RED);

        //text.setFont(new Font("Tahoma", Font.BOLD, 10));
        text.setSize(90,60);
        text.setLocation(70,15);

        panred.add(color_box);
        panred.add(text);
    }

    void setPanorang() {
        panorang.setSize(160,90);
        panorang.setLocation(10,110);
        panorang.setLayout(null);

        JPanel color_box = new JPanel();

        color_box.setSize(60,60);
        color_box.setLocation(10,15);
        color_box.setBackground(Color.ORANGE);
        panorang.add(color_box);
    }

    void setPanyellow() {
        panyellow.setSize(160,90);
        panyellow.setLocation(10,210);
        panyellow.setLayout(null);

        JPanel color_box = new JPanel();

        color_box.setSize(60,60);
        color_box.setLocation(10,15);
        color_box.setBackground(Color.YELLOW);
        panyellow.add(color_box);
    }

    void setPangreen() {
        pangreen.setSize(160,90);
        pangreen.setLocation(10,310);
        pangreen.setLayout(null);

        JPanel color_box = new JPanel();

        color_box.setSize(60,60);
        color_box.setLocation(10,15);
        color_box.setBackground(Color.GREEN);
        pangreen.add(color_box);
    }
}
