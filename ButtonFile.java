import java.awt.Font;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JOptionPane;

public class ButtonFile extends JButton {
    int valuePm [][] = new int[10][20];
    private String filepath;

    public ButtonFile() {
        setText("SELECT");
        setSize(160,40);
        setLocation(10,55);
        setFont(new Font("Arial", Font.BOLD, 10));
    }

    void setValuePm(String filepath) {

        try {
            String line;
            String [] data;

            BufferedReader reader = new BufferedReader(new FileReader(filepath));

            for (int row = 0; (line = reader.readLine()) != null ; row++) {
                // แยกตัวเลขโดยใช้ช่องว่างอย่างน้อย 1 ตัว          
                data = line.split("\\s+");            
                
                for (int i = 0; i < data.length; i++) {
                    valuePm[row][i] = Integer.parseInt(data[i]);             
                }
            }

            reader.close();        
        } catch (IOException e1) {
            JOptionPane.showMessageDialog(null, "Please select file again!","ALERT", JOptionPane.WARNING_MESSAGE);
        } catch (NumberFormatException e2) {
            JOptionPane.showMessageDialog(null, "Please select file again!","ALERT", JOptionPane.WARNING_MESSAGE);
        } catch (NullPointerException e3) {
            JOptionPane.showMessageDialog(null, "Please select file again!","ALERT", JOptionPane.WARNING_MESSAGE);
        }
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }

    String getFilepath() {
        return filepath;
    }

    int [][] getValuePm() {
        return valuePm;
    }
}
