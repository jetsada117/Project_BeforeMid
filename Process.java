import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

class Process extends JFrame implements ActionListener {
    JPanel pancenter = new JPanel(); // panel เอาไว้รงรับปุ่ม 200 ปุ่ม
    JPanel background = new JPanel(); // panel ตั้งค่าสีพื้นหลัง
    TextField file_box = new TextField(); // ช่องแสดงตำแหน่งไฟล์  
    TextField people_box = new TextField(); // ช่องรับค่าคน
    TextField start_box = new TextField(); // ช่องรับค่าคนแบบสุ่ม(ตำแหน่งเริ่มต้น)
    TextField end_box = new TextField(); // ช่องรับค่าคนแบบสุ่ม(ตำแหน่งสุดท้าย)
    ButtonFile file = new ButtonFile();        
    JLabel dust = new JLabel();
    JLabel population = new JLabel();
    JLabel heal = new JLabel();
    JLabel pantient = new JLabel();
    JLabel percen = new JLabel();
    ButtonPeople people = new ButtonPeople();
    ButtonRandom random = new ButtonRandom();
    ButtonPlane plane = new ButtonPlane();
    ButtonRain rain = new ButtonRain();
    ButtonPM [][] button = new ButtonPM[10][20];
    boolean enabledPlane = false;
        
    public Process() {    
        JPanel leftbar = new JPanel();
        JPanel rightbar = new JPanel();
        JPanel footer = new JPanel();

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

        //เรียก Method เพื่อมา set ค่าและตำแหน่ง
        setLeftbar(leftbar);        
        setRightbar(rightbar);
        setFooter(footer);

        add(pancenter);
        add(leftbar);
        add(rightbar);
        add(footer);
        add(background);

        file.addActionListener(this);
        people.addActionListener(this);
        random.addActionListener(this);
        plane.addActionListener(this);
        rain.addActionListener(this);
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == file) {
            selectfile(e);
        } else if (e.getSource() == people) {
            setPeople(e);
        } else if (e.getSource() == random) {
            setRandom(e);
        } else if (e.getSource() == plane) {
            setPlane(e);
        } else if (e.getSource() == rain) {
            setRain(e);
        }
    }

    void selectfile(ActionEvent e) {

        // library เลือกไฟล์จากตัวเครื่อง
        JFileChooser filechooser = new JFileChooser();

        filechooser.setCurrentDirectory(new File("."));

        // ให้แสดงจอขึ้นมาแล้วเลือกไฟล์ เมื่อกด Ok เลือกไฟล์แล้วจะส่งค่าของไฟล์มาที่ตัวแปร ถ้ามีไฟล์จะส่งค่ากลับมาเป็น 0 แต่ถ้าไม่มีจะเป็น 1
        int response = filechooser.showOpenDialog(null);

      
        if (response == JFileChooser.APPROVE_OPTION) {
            // เมื่อกดเลือกไฟล์แล้วจะมีการแสดงตำแหน่งไฟล์บน text field
            String filepath = filechooser.getSelectedFile().getAbsolutePath();
            file.setFilepath(filepath);
            file.setValuePm(filepath);
            file_box.setText(filepath);
        }
        else {
         
            JOptionPane.showMessageDialog(null, "NO FILE SELECT","ALERT", JOptionPane.WARNING_MESSAGE);
        }

    }

    void setPeople(ActionEvent e) {

        try {
            String message = people_box.getText();
            int value = Integer.parseInt(message);

            if(value >= 0) {
                people.setPeople(value);            
                start_box.setText("");
                end_box.setText("");

                if (file.getFilepath() != null) {
                    showButton(e);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select a file","ALERT", JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(null, "People less zero","ALERT", JOptionPane.WARNING_MESSAGE);
                people_box.setText("");
            }

            

        } catch (NumberFormatException ex) {
            // เมื่อไม่มีการใส่จำนวนประชากรหรือใส่จำนวนประชากรไม่ถูกต้องจะมีการแจ้งเตือน
            JOptionPane.showMessageDialog(null, "Please enter a number","ALERT", JOptionPane.WARNING_MESSAGE);
        }

    }

    void showButton(ActionEvent e) {
        pancenter.removeAll();

        int [][] Pm = file.getValuePm();
        int value = people.getPeople();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                button[i][j] = new ButtonPM();
                button[i][j].setPosition(i, j);
                button[i][j].setPm(Pm[i][j]);
                
                
                if (e.getSource() == people) {

                    button[i][j].setPeople(value);
                }
                else if (e.getSource() == random) {

                    button[i][j].setPeople(random.getRandomNumber());
                }      

                button[i][j].setPercents();
                button[i][j].setPantient();
                button[i][j].setHealthy();

                button[i][j].setBackgroundColor();
                pancenter.add(button[i][j]);

                final int x = i;
                final int y = j;

                button[i][j].addActionListener((ActionEvent e1) -> {

                    // เช็คว่ามีการกดเครื่องบินก่อนหรือไม่ ถ้ามีจะทำงาน
                    if(enabledPlane) {
                        int row = button[x][y].getRow();
                        int column = button[x][y].getColumn();
                        
                        updatePmAndColor(row, column, button);
                        
                        enabledPlane = false;
                    }

                    button[x][y].setPercents();
                    button[x][y].setPantient();
                    button[x][y].setHealthy();

                    int pm = button[x][y].getPm();
                    int people1 = button[x][y].getPeople();
                    int healthy = button[x][y].getHealthy();
                    int pantient1 = (int)button[x][y].getPantient();
                    int percents = button[x][y].getPercents();
                    showRightbar(pm, people1, healthy, pantient1, percents);
                });
            }
        }

        pancenter.revalidate();
    }

    private void updatePmAndColor(int row, int column, ButtonPM[][] button) {
        int[] dx = {-1, -1, -1, 0, 0, 0, 1, 1, 1};
        int[] dy = {-1, 0, 1, -1, 0, 1, -1, 0, 1};
        int[] reduction = {30, 30, 30, 30, 50, 30, 30, 30, 30}; // ลด 50% ที่ศูนย์กลาง
    
        for (int k = 0; k < dx.length; k++) {
            int i = row + dx[k];
            int j = column + dy[k];
    
            if (i >= 0 && i < 10 && j >= 0 && j < 20) { // ตรวจสอบขอบเขต

                int reduce = button[i][j].getPm() - (button[i][j].getPm() * reduction[k] / 100);
                if (reduce < 0) reduce = 0; // ป้องกันไม่ให้ค่าติดลบ
                button[i][j].setPm(reduce);
                button[i][j].setPercents();

                button[i][j].setBackgroundColor();


            }
        }
    }

    void setRandom(ActionEvent e) {
        String start = start_box.getText();
        String end = end_box.getText();

        try {
            int startValue = Integer.parseInt(start);
            int endValue = Integer.parseInt(end);

            if (startValue  < endValue && startValue >= 0) {
                people_box.setText("");
                random.setStart(startValue);
                random.setEnd(endValue);

                if ((file.getFilepath() != null)) {
                    showButton(e);
                }
                else {
                    JOptionPane.showMessageDialog(null, "Please select a file","ALERT", JOptionPane.WARNING_MESSAGE);
                }
            } 
            else {
                start_box.setText("");
                end_box.setText("");
                JOptionPane.showMessageDialog(null, "Start value should be less than end value","ALERT", JOptionPane.WARNING_MESSAGE);
            }

        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, "Please enter a number","ALERT", JOptionPane.WARNING_MESSAGE);
        }
    }

    void setPlane(ActionEvent e) {
        if(e.getSource() == plane) {
            enabledPlane = true;
        }
    }

    void setRain(ActionEvent e) {

        try {
            if (e.getSource() == rain) {
                for (int i = 0; i < 10 ; i++) {
                    for (int j = 0; j < 20 ; j++) {
                        int newPm = button[i][j].getPm() - 50;
                        if(newPm < 0) newPm = 0;

                        button[i][j].setPm(newPm);
                        button[i][j].setPercents();
                        button[i][j].setBackgroundColor();
                    }
                } 
            }
        } catch (NullPointerException ex) {
            // แสดงข้อความแจ้งเตือนเมื่อมีการใส่ข้อมูลไม่ครบ
            JOptionPane.showMessageDialog(null, "Please enter complete information","ALERT", JOptionPane.WARNING_MESSAGE);
        }


    }

    // set แถบซ้าย จะมีแถบสีแสดง ปริมาณคนปวย JPanel panel ที่รับมาเป็น atribute ที่ประกาศไว้ด้านบน
    private void setLeftbar(JPanel panel) {
        Color color = new Color(159,160,159);

        panel.setSize(190,420);
        panel.setLocation(0,0);
        panel.setBackground(color);
        panel.setLayout(null);

        panel.add(getPanelcolor(color, Color.RED,"<html>มีคนป่วยเกิน 30% ของประชากรในพื้นที่</html>", Color.WHITE,10,10));        
        panel.add(getPanelcolor(color, Color.ORANGE,"<html>มีคนป่วย 20-29% ของประชากรในพื้นที่</html>", Color.WHITE,10,100));
        panel.add(getPanelcolor(color, Color.YELLOW,"<html>มีคนป่วย 10-19% ของประชากรในพื้นที่</html>", Color.WHITE,10,190));
        panel.add(getPanelcolor(color, Color.GREEN,"<html>มีคนป่วย 0-9% ของประชากรในพื้นที่</html>", Color.WHITE,10,280));        
    }

    private JPanel getPanelcolor(Color background,Color box,String text,Color ctext, int x, int y) {
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

    private void setRightbar(JPanel panel) {
        Font font = new Font("Tahoma", Font.BOLD, 12);

        panel.setSize(190,420);
        panel.setLocation(700,0);
        panel.setBackground(new Color(159,160,159));
        panel.setLayout(null);

        setLocaRightbar(dust, font, 10, 10, 160, 50);
        setLocaRightbar(population, font, 10, 65, 160, 50);
        setLocaRightbar(heal, font, 10, 120, 160, 50);
        setLocaRightbar(pantient, font, 10, 175, 160, 50);
        setLocaRightbar(percen, font, 10, 230, 160, 50);

        panel.add(dust);
        panel.add(population);
        panel.add(heal);
        panel.add(pantient);
        panel.add(percen);
    }

    private void showRightbar(int d, int po, int h, int pan, int per) {
        dust.setText("Dust  :  "+ d);
        population.setText("Population  :  "+ po);
        heal.setText("Healthy  :  "+ h);
        pantient.setText("Patiant  :  "+ pan);
        percen.setText("Percent Patient  :  "+ per +" % ");
    }

    private void setLocaRightbar(JLabel label, Font font, int x, int y, int width, int height) {      
        label.setBounds(x,y,width,height);
        label.setFont(font);
        label.setForeground(Color.WHITE);
    }

    private void setFooter(JPanel panel) {
        panel.setSize(900,177);
        panel.setLocation(0,423);
        panel.setLayout(null);
        panel.setBackground(new Color(159,160,159));

        panel.add(setPanfile());
        panel.add(setPanpeople());
        panel.add(setPanrandom());
        panel.add(plane);
        panel.add(rain);
    }
    
    // เลือกไฟล์ PM 2.5
    private JPanel setPanfile() {      
        JPanel panfile = new JPanel();
        JLabel text = new JLabel("INPUT FILE");
        Font font = new Font("Arial", Font.BOLD, 10);

        panfile.setSize(180,100);
        panfile.setLocation(10,20);
        panfile.setLayout(null);

        text.setSize(120,20);
        text.setLocation(10,5);
        text.setFont(font);

        file_box.setSize(160,20);
        file_box.setLocation(10,25);
        file_box.setFont(font);

        panfile.add(text);
        panfile.add(file_box);
        panfile.add(file);

        return panfile;
    }
    
   
    private JPanel setPanpeople() {
        JPanel panpeople = new JPanel();
        Label text = new Label("INPUT POPULATION");

        panpeople.setSize(130,100);
        panpeople.setLocation(200,20);
        panpeople.setLayout(null);        

        text.setSize(120,20);
        text.setLocation(10,5);
        text.setFont(new Font("Arial", Font.BOLD, 10));

        people_box.setSize(110,20);
        people_box.setLocation(10,25);
        people_box.setFont(new Font("Arial", Font.PLAIN, 10));

        panpeople.add(text);
        panpeople.add(people_box);
        panpeople.add(people);

        return panpeople;
    }
    
    
    private JPanel setPanrandom() {
        JPanel panrandom = new JPanel();  
        JLabel text = new JLabel("INPUT RANDOM POPULATION");
        JLabel to = new JLabel("To");

        panrandom.setSize(180,100);
        panrandom.setLocation(340,20);
        panrandom.setLayout(null);

        text.setSize(160,20);
        text.setLocation(10,5);
        text.setFont(new Font("Arial", Font.BOLD, 10));

        to.setSize(20,20);
        to.setLocation(75,25);
        to.setFont(new Font("Arial", Font.PLAIN, 15));
        
        start_box.setBounds(10,25,60,20);

        end_box.setBounds(100,25,60,20);

        panrandom.add(text);
        panrandom.add(to);
        panrandom.add(start_box);
        panrandom.add(end_box);
        panrandom.add(random);

        return panrandom;
    }
}