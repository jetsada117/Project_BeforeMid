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
import javax.swing.JPanel;

class Process extends JFrame implements ActionListener {
    JPanel pancenter = new JPanel();
    JPanel background = new JPanel();
    LeftBar sidLeftBar = new LeftBar();
    RightBar sidRightBar = new RightBar();
    private final JPanel footer = new JPanel();
    private final JPanel panfile = new JPanel();
    private final JPanel panpeople = new JPanel();
    private final JPanel panrandom = new JPanel();   
    TextField file_box = new TextField();     
    TextField people_box = new TextField();
    TextField start_box = new TextField();
    TextField end_box = new TextField();
    ButtonFile file = new ButtonFile();
    ButtonPeople people = new ButtonPeople();
    ButtonRandom random = new ButtonRandom();
    ButtonPlane plane = new ButtonPlane();
    ButtonRain rain = new ButtonRain();
        
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

        setFooter();

        add(pancenter, BorderLayout.CENTER);
        add(sidLeftBar);
        add(sidRightBar);
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
            selectfile();
        } else if (e.getSource() == people) {
            setPeople(e);
        } else if (e.getSource() == random) {
            setRandom(e);
        } else if (e.getSource() == plane) {
            System.out.println("Plane");
        } else if (e.getSource() == rain) {
            System.out.println("Rain");
        }
    }

    void selectfile() {

        // library เลือกไฟล์จากตัวเครื่อง
        JFileChooser filechooser = new JFileChooser();

        filechooser.setCurrentDirectory(new File("."));

        // ให้แสดงจอขึ้นมาแล้วเลือกไฟล์ เมื่อกด Ok เลือกไฟล์แล้วจะส่งค่าของไฟล์มาที่ตัวแปร ถ้ามีไฟล์จะส่งค่ากลับมาเป็น 0 แต่ถ้าไม่มีจะเป็น 1
        int response = filechooser.showOpenDialog(null);

        // เช็คว่ามีไฟล์หรือไม่
        if (response == JFileChooser.APPROVE_OPTION) {
            // เมื่อกดเลือกไฟล์แล้วจะมีการแสดงตำแหน่งไฟล์บน text field
            String filepath = filechooser.getSelectedFile().getAbsolutePath();
            file.setFilepath(filepath);
            file.setValuePm(filepath);
            file_box.setText(filepath);
        }
        else {
            // เมื่อกด Cancel จะไม่มีการเลือกไฟล์
            System.out.println("No File Selected");
        }

        System.out.println(file.getFilepath());
        int [][] pm = file.getValuePm();

        for(int i = 0; i < 10 ; i++) {
            for(int j = 0; j < 20 ; j++) {
                System.out.print(pm[i][j] + " ");
            }
            System.out.println();
        }
    }

    void setPeople(ActionEvent e) {

        try {
            String message = people_box.getText();
            int value = Integer.parseInt(message);
            people.setPeople(value);
            System.out.println("value: " + people.getPeople());
                             
            if ((file.getValuePm() != null)) {
                showButton(e);
                System.out.println("Successfully");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a number");
        }

    }

    void showButton(ActionEvent e) {
        pancenter.removeAll();

        int [][] Pm = file.getValuePm();
        int value = people.getPeople();

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 20; j++) {
                ButtonPM button = new ButtonPM();
                if (e.getSource() == people) {
                    button.setPm(Pm[i][j]);
                    button.setPeople(value);
                }
                else if (e.getSource() == random) {
                    button.setPm(Pm[i][j]);
                    button.setPeople(random.getRandomNumber());
                }


                if (Pm[i][j] > 150) {
                    button.setBackground(Color.RED);
                }
                else if (Pm[i][j] > 100) {
                    button.setBackground(Color.ORANGE);
                }
                else if (Pm[i][j] > 50) {
                    button.setBackground(Color.YELLOW);
                }
                else {
                    button.setBackground(Color.GREEN);
                }

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

    void setRandom(ActionEvent e) {
        String start = start_box.getText();
        String end = end_box.getText();

        try {
            int startValue = Integer.parseInt(start);
            int endValue = Integer.parseInt(end);

            random.setStart(startValue);
            random.setEnd(endValue);

            if ((file.getValuePm() != null)) {
                showButton(e);
                System.out.println("Successfully");
            }
        } catch (NumberFormatException ex) {
            System.out.println("Please enter a number");
        }
    }

    private void setFooter() {
        footer.setSize(900,177);
        footer.setLocation(0,423);
        footer.setLayout(null);
        footer.setBackground(new Color(159,160,159));

        setPanfile();
        setPanpeople();
        setPanrandom();

        footer.add(panfile);
        footer.add(panpeople);
        footer.add(panrandom);
        footer.add(plane);
        footer.add(rain);
    }

    private void setPanfile() {        
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
    }

    private void setPanpeople() {
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
    }

    private void setPanrandom() {
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
    }
}