import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class LeftBar extends JPanel{
    Color color = new Color(159,160,159);

    LeftBar() {
        setSize(190,420);
        setLocation(0,0);
        setBackground(color);
        setLayout(null);

        add(getPanel(color, Color.RED,"<html>มีคนป่วยเกิน 30% ของประชากรในพื้นที่</html>", Color.WHITE,10,10));        
        add(getPanel(color, Color.ORANGE,"<html>มีคนป่วย 20-29% ของประชากรในพื้นที่</html>", Color.WHITE,10,100));
        add(getPanel(color, Color.YELLOW,"<html>มีคนป่วย 10-19% ของประชากรในพื้นที่</html>", Color.WHITE,10,190));
        add(getPanel(color, Color.GREEN,"<html>มีคนป่วย 0-9% ของประชากรในพื้นที่</html>", Color.WHITE,10,280));        
    }

    JPanel getPanel(Color background,Color box,String text,Color ctext, int x, int y) {    
        JPanel panel = new JPanel();
        panel.setSize(160,90);
        panel.setLocation(x,y);
        panel.setBackground(background);
        panel.setLayout(null);

        JPanel color_box = new JPanel();
        JLabel text_label = new JLabel(text);

        color_box.setSize(50,50);
        color_box.setLocation(0,15);
        color_box.setBackground(box);

        text_label.setFont(new Font("Tahoma", Font.BOLD, 10));
        text_label.setSize(105,60);
        text_label.setLocation(55,10);
        text_label.setForeground(ctext);

        panel.add(color_box);
        panel.add(text_label);

        return panel;
    }
}
