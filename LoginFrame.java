import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class LoginFrame extends JFrame {

    JTextField name;

    LoginFrame(){

        getContentPane().setBackground(
                new Color(240,245,250)
        );

        setTitle("Smart Complaint System");

        setSize(600,500);

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
                0,0,600,80
        );

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
                100,20,400,40
        );

        topPanel.add(heading);



        JPanel card =
                new JPanel();

        card.setLayout(null);

        card.setBackground(
                Color.WHITE
        );

        card.setBorder(
                new LineBorder(
                        Color.LIGHT_GRAY,
                        1
                )
        );

        card.setBounds(
                120,140,350,220
        );

        add(card);



        JLabel title =
                new JLabel(
                        "👤 Login"
                );

        title.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        title.setBounds(
                130,10,150,30
        );

        card.add(title);



        JLabel l =
                new JLabel(
                        "Username:"
                );

        l.setBounds(
                40,70,100,30
        );

        card.add(l);



        name =
                new JTextField();

        name.setBounds(
                140,70,160,30
        );

        card.add(name);



        JButton login =
                new JButton(
                        "🔑 Login"
                );

        login.setBounds(
                40,150,120,35
        );

        login.setBackground(
                new Color(25,118,210)
        );

        login.setForeground(
                Color.WHITE
        );

        login.setFocusPainted(false);

        card.add(login);



        JButton register =
                new JButton(
                        "📝 Register"
                );

        register.setBounds(
                180,150,120,35
        );

        register.setBackground(
                new Color(76,175,80)
        );

        register.setForeground(
                Color.WHITE
        );

        register.setFocusPainted(false);

        card.add(register);



        login.addActionListener(
                e->checkLogin()
        );



        register.addActionListener(
                e->new RegisterFrame()
        );



        setVisible(true);
    }



    void checkLogin(){

        String user =
                name.getText();



        if(
                DataStore.users.contains(user)
        ){

            dispose();



            if(
                    user.equals("admin")
            ){

                new AdminDashboard();

            }else{

                new DashboardFrame(
                        user
                );
            }

        }else{

            JOptionPane.showMessageDialog(
                    this,
                    "User not found"
            );
        }
    }
}
