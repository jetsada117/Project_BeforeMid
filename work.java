import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;

public class work {
    public static void main(String[] in){
        MyFramework frame = new MyFramework();
        frame.setVisible(true);  

    }
}
class MyFramework extends JFrame{
    JLabel jLabel = new JLabel("PM 2.5");

   
    public MyFramework(){
        setSize(900,600);
        setLocation(400,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        set_ButtonStart B1 = new set_ButtonStart();
        setset_Buttonmember b2 = new setset_Buttonmember();
        set_Logout B3 = new set_Logout();
        jLabel.setSize(200, 120);
        jLabel.setLocation(350, 20);
        jLabel.setFont(new Font("Arial", Font.BOLD, 60));
        
        add(jLabel);
        add(B3);
        add(b2);
        add(B1);
       
        
    }
}
