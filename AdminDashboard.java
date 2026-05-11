import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class AdminDashboard extends JFrame {

    JTextArea area;

    JTextField idField;

    AdminDashboard(){

        getContentPane().setBackground(
                new Color(240,245,250)
        );

        setTitle("Admin Dashboard");

        setSize(700,600);

        setLayout(null);

        setDefaultCloseOperation(
                EXIT_ON_CLOSE
        );



        JPanel topPanel =
                new JPanel();

        topPanel.setLayout(null);

        topPanel.setBackground(
                new Color(25,118,210)
        );

        topPanel.setBounds(
                0,0,700,70
        );

        add(topPanel);



        JLabel heading =
                new JLabel(
                        "🛠️ Admin Dashboard"
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
                20,15,300,40
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



        JLabel listLabel =
                new JLabel(
                        "📋 All Complaints"
                );

        listLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        18
                )
        );

        listLabel.setBounds(
                40,90,250,30
        );

        add(listLabel);



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
                40,130,600,220
        );

        scroll.setBorder(
                new LineBorder(
                        Color.LIGHT_GRAY,
                        1
                )
        );

        add(scroll);



        JPanel actionPanel =
                new JPanel();

        actionPanel.setLayout(null);

        actionPanel.setBackground(
                Color.WHITE
        );

        actionPanel.setBorder(
                new LineBorder(
                        Color.LIGHT_GRAY,
                        1
                )
        );

        actionPanel.setBounds(
                40,390,600,120
        );

        add(actionPanel);



        JLabel idLabel =
                new JLabel(
                        "🆔 Complaint ID:"
                );

        idLabel.setBounds(
                30,30,140,30
        );

        idLabel.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        14
                )
        );

        actionPanel.add(idLabel);



        idField =
                new JTextField();

        idField.setBounds(
                180,30,120,30
        );

        actionPanel.add(idField);



        JButton resolveBtn =
                new JButton(
                        "✅ Resolve"
                );

        resolveBtn.setBounds(
                350,30,150,35
        );

        resolveBtn.setBackground(
                new Color(76,175,80)
        );

        resolveBtn.setForeground(
                Color.WHITE
        );

        resolveBtn.setFocusPainted(false);

        actionPanel.add(resolveBtn);



        resolveBtn.addActionListener(
                e->resolveComplaint()
        );



        refresh();

        setVisible(true);
    }



    void resolveComplaint(){

        int id =
                Integer.parseInt(
                        idField.getText()
                );



        for(Complaint c :
                DataStore.complaints){

            if(c.id == id){

                c.status =
                        "Resolved";
            }
        }



        refresh();

        idField.setText("");



        JOptionPane.showMessageDialog(
                this,
                "Complaint Resolved!"
        );
    }



    void refresh(){

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
