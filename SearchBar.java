package mysql;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SearchBar extends JFrame {

    private JTextField searchField;
    private JButton searchButton;

    public SearchBar() {
        super("Search Bar");

        JPanel searchPanel = new JPanel();
        searchPanel.setBorder(BorderFactory.createTitledBorder("Search"));
        searchField = new JTextField(20);
        searchButton = new JButton("Search");

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String searchTerm = searchField.getText();
                // perform search here, for example by calling a function
                System.out.println("Searching for: " + searchTerm);
            }
        });

        searchPanel.add(searchField);
        searchPanel.add(searchButton);

        add(searchPanel);

        // create a button
        JButton loginBtn = new JButton("Login");
        loginBtn.setBounds(714, 10, 95, 21);
        JButton signupBtn = new JButton("SignUp");
        signupBtn.setBounds(819, 10, 91, 21);

        // add an action listener to the button
        loginBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Login login = new Login();
                login.setVisible(true);
                dispose();

            }
        });

        signupBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Signup signup = new Signup();
                signup.setVisible(true);
                dispose();
            }
        });
        getContentPane().setLayout(null);

        // add the buttons to the contentPane
        add(loginBtn);
        add(signupBtn);

        setSize(932, 581);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public static void main(String[] args) {
        SearchBar searchBar = new SearchBar();
        searchBar.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}