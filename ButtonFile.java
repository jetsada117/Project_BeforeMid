import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ButtonFile extends JPanel implements ActionListener {
    JLabel text = new JLabel("INPUT FILE");
    JTextField text_box = new JTextField();
    JButton confirm = new JButton("SELECT");
    Font font = new Font("Arial", Font.BOLD, 10);
    int valuePm [][] = new int[10][20];
    String filepath = "";

    public ButtonFile() {
        setSize(180,100);
        setLocation(10,20);
        setLayout(null);

        text.setSize(120,20);
        text.setLocation(10,5);
        text.setFont(font);
        
        text_box.setSize(160,20);
        text_box.setLocation(10,25);
        text_box.setFont(font);

        confirm.setSize(160,40);
        confirm.setLocation(10,55);
        confirm.setFont(font);

        add(text);
        add(text_box);
        add(confirm);

        confirm.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        // library เลือกไฟล์จากตัวเครื่อง
        JFileChooser filechooser = new JFileChooser();

        filechooser.setCurrentDirectory(new File("."));

        // ให้แสดงจอขึ้นมาแล้วเลือกไฟล์ เมื่อกด Ok เลือกไฟล์แล้วจะส่งค่าของไฟล์มาที่ตัวแปร ถ้ามีไฟล์จะส่งค่ากลับมาเป็น 0 แต่ถ้าไม่มีจะเป็น 1
        int response = filechooser.showOpenDialog(null);

        // เช็คว่ามีไฟล์หรือไม่
        if (response == JFileChooser.APPROVE_OPTION) {
            // เมื่อกดเลือกไฟล์แล้วจะมีการแสดงตำแหน่งไฟล์บน text field
            text_box.setText(filechooser.getSelectedFile().getAbsolutePath());
            filepath = filechooser.getSelectedFile().getAbsolutePath();
            getValuePm();
        }
        else {
            // เมื่อกด Cancel จะไม่มีการเลือกไฟล์
            text_box.setText("No File Selected");
        }
    }

    int [][] getValuePm() {

        try {
            String line;
            String [] data;

            BufferedReader reader = new BufferedReader(new FileReader(filepath));

            for (int row = 0; (line = reader.readLine()) != null ; row++) {
                // แยกตัวเลขโดยใช้ช่องว่างอย่างน้อย 1 ตัว          
                data = line.split("\\s+");            
                
                for (int i = 0; i < data.length; i++) {
                    valuePm[row][i] = Integer.parseInt(data[i]);
                    System.out.print(valuePm[row][i] + " ");
                }
                System.out.println();
            }

        } catch (IOException e1) {
            System.out.println(e1.getMessage());
        } catch (NumberFormatException e2) {
            System.out.println("Invalid data format");
        }

        return valuePm;
    }
}
