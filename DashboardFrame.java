import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class DashboardFrame extends JFrame {

    JComboBox<String> category;
    JTextField complaint;
    JTextArea area;

    DashboardFrame(String user){

        getContentPane().setBackground(
                new Color(240,245,250)
        );

        setTitle("Smart Complaint System");

        setSize(700,600);

        setLayout(null);

        setDefaultCloseOperation(
                EXIT_ON_CLOSE
        );



        JPanel topPanel =
                new JPanel();

        topPanel.setBackground(
                new Color(25,118,210)
        );

        topPanel.setBounds(
                0,0,700,70
        );

        topPanel.setLayout(null);

        add(topPanel);



        JLabel heading =
                new JLabel(
                        "📢 Smart Complaint System"
                );

        heading.setForeground(
                Color.WHITE
        );

        heading.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        24
                )
        );

        heading.setBounds(
                20,15,350,40
        );

        topPanel.add(heading);



        JButton logout =
                new JButton(
                        "Logout"
                );

        logout.setBounds(
                560,20,100,30
        );

        logout.setFocusPainted(false);

        topPanel.add(logout);

        logout.addActionListener(e->{

            dispose();

            new LoginFrame();
        });



        JLabel welcome =
                new JLabel(
                        "👋 Welcome, " + user
                );

        welcome.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        welcome.setBounds(
                40,90,250,30
        );

        add(welcome);



        JPanel formPanel =
                new JPanel();

        formPanel.setLayout(null);

        formPanel.setBackground(
                Color.WHITE
        );

        formPanel.setBorder(
                new LineBorder(
                        Color.LIGHT_GRAY,
                        1
                )
        );

        formPanel.setBounds(
                40,140,600,180
        );

        add(formPanel);



        JLabel catLabel =
                new JLabel(
                        "📂 Category:"
                );

        catLabel.setBounds(
                30,30,120,30
        );

        catLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        formPanel.add(catLabel);



        String[] categories = {

                "Road Issue",
                "Water Leakage",
                "Electricity Fault",
                "Garbage Issue"
        };

        category =
                new JComboBox<>(
                        categories
                );

        category.setBounds(
                180,30,250,30
        );

        formPanel.add(category);



        JLabel descLabel =
                new JLabel(
                        "📝 Description:"
                );

        descLabel.setBounds(
                30,80,120,30
        );

        descLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        formPanel.add(descLabel);



        complaint =
                new JTextField();

        complaint.setBounds(
                180,80,250,30
        );

        formPanel.add(complaint);



        JButton submit =
                new JButton(
                        "✅ Submit Complaint"
                );

        submit.setBounds(
                180,130,180,35
        );

        submit.setBackground(
                new Color(76,175,80)
        );

        submit.setForeground(
                Color.WHITE
        );

        submit.setFocusPainted(false);

        formPanel.add(submit);



        JLabel history =
                new JLabel(
                        "📋 Complaint History"
                );

        history.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        history.setBounds(
                40,340,250,30
        );

        add(history);



        area =
                new JTextArea();

        area.setEditable(false);

        area.setFont(
                new Font(
                        "Monospaced",
                        Font.PLAIN,
                        14
                )
        );

        JScrollPane scroll =
                new JScrollPane(
                        area
                );

        scroll.setBounds(
                40,380,600,150
        );

        add(scroll);



        submit.addActionListener(e->{

            Complaint c =
                    new Complaint(
                            category
                                    .getSelectedItem()
                                    .toString(),

                            complaint
                                    .getText()
                    );

            DataStore
                    .complaints
                    .add(c);

            updateArea();

            complaint.setText("");

            JOptionPane.showMessageDialog(
                    this,
                    "Complaint Submitted Successfully!"
            );
        });



        updateArea();

        setVisible(true);
    }



    void updateArea(){

        area.setText("");

        for(Complaint c :
                DataStore.complaints){

            area.append(
                    c.toString()
                    + "\n"
            );
        }
    }
}
