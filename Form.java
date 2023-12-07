import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * form
 */
public class Form extends JFrame{ 

    public void initialize(){
        
        JLabel firLabel = new JLabel("First Name: ");
        JTextField firField = new JTextField();
        JLabel firMess = new JLabel(" ");
        JPanel firPanel = new JPanel();
        firPanel.setLayout(new GridLayout(1, 2, 5, 7));
        firPanel.add(firLabel);
        firPanel.add(firField);

        JLabel lasLabel = new JLabel("Last Name: ");
        JTextField lasField = new JTextField();
        JLabel lasMess = new JLabel(" ");
        JPanel lasPanel = new JPanel();
        lasPanel.setLayout(new GridLayout(1, 2, 5, 7));
        lasPanel.add(lasLabel);
        lasPanel.add(lasField);

        JLabel userLabel = new JLabel("Username: ");
        JTextField userField = new JTextField();
        JLabel userMess = new JLabel();
        JPanel userPanel = new JPanel();
        userPanel.setLayout(new GridLayout(1, 2, 5, 7));
        userPanel.add(userLabel);
        userPanel.add(userField);

        JLabel passLabel = new JLabel("Password: ");
        JPasswordField passwordField = new JPasswordField();
        JLabel passMess = new JLabel();
        JPanel passPanel = new JPanel();
        passPanel.setLayout(new GridLayout(1, 2, 5, 7));
        passPanel.add(passLabel);
        passPanel.add(passwordField);

        JPanel formPanel = new JPanel();
        formPanel.setBorder(BorderFactory.createLineBorder(Color.black, 1));
        formPanel.setLayout(new GridLayout(8, 2, 5, 7));
        formPanel.add(firPanel);
        formPanel.add(firMess);
        formPanel.add(lasPanel);
        formPanel.add(lasMess);
        formPanel.add(userPanel);
        formPanel.add(userMess);
        formPanel.add(passPanel);
        formPanel.add(passMess);

        JButton btn = new JButton("Submit");
        btn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                String fregex = "^[a-zA-Z0-9_-]{3,16}$";
                Pattern fpattern = Pattern.compile(fregex);
                Matcher fmatcher = fpattern.matcher(userField.getText());
                if (fmatcher.matches()){
                    userMess.setText("Nice");
                } else {
                    userMess.setText("Username must contain at least one letter");
                }

                String pregex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\\\S+$).{8,}$";
                Pattern ppattern = Pattern.compile(pregex);
                Matcher pmatcher = ppattern.matcher(passwordField.getText());
                if (pmatcher.matches()){
                    passMess.setText("Nice");
                } else {
                    passMess.setText("Password must meet the requirements");
                }

            }
            
        });
        
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());
        buttonPanel.add(btn);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());
        mainPanel.add(formPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setTitle("JFrame");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(new Dimension(350, 500));
        setVisible(true);
        
    }

    public static void main(String[] args) {
        Form frm = new Form();
        frm.initialize();
    }
}