import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;

public class RegisterFrame extends JFrame {

    JTextField name;

    RegisterFrame(){

        getContentPane().setBackground(
                new Color(240,245,250)
        );

        setTitle("Register");

        setSize(500,400);

        setLayout(null);



        JPanel topPanel =
                new JPanel();

        topPanel.setLayout(null);

        topPanel.setBackground(
                new Color(25,118,210)
        );

        topPanel.setBounds(
                0,0,500,70
        );

        add(topPanel);



        JLabel heading =
                new JLabel(
                        "📝 Create Account"
                );

        heading.setForeground(
                Color.WHITE
        );

        heading.setFont(
                new Font(
                        "Arial",
                        Font.BOLD,
                        22
                )
        );

        heading.setBounds(
                130,15,250,40
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
                80,120,320,180
        );

        add(card);



        JLabel l =
                new JLabel(
                        "👤 Username:"
                );

        l.setBounds(
                30,40,120,30
        );

        card.add(l);



        name =
                new JTextField();

        name.setBounds(
                140,40,140,30
        );

        card.add(name);



        JButton btn =
                new JButton(
                        "✅ Register"
                );

        btn.setBounds(
                90,110,140,35
        );

        btn.setBackground(
                new Color(76,175,80)
        );

        btn.setForeground(
                Color.WHITE
        );

        btn.setFocusPainted(false);

        card.add(btn);



        btn.addActionListener(
                e->register()
        );



        setVisible(true);
    }



    void register(){

        DataStore.users.add(
                name.getText()
        );

        JOptionPane.showMessageDialog(
                this,
                "Registration Successful!"
        );

        dispose();
    }
}
