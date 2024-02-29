package mysql;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;


public class MainPage extends JFrame {
    private JTextField searchField;
    private JButton searchButton;
    Connection con;
    String[] arr = new String[50];
    JLabel lblNewLabel_1;
    String link;

    public MainPage() {
        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\SEMESTER -3\\JAVA PROJECT\\signupuser.jpg"));

        // set the properties of the window
        setTitle("Invention Management System");
        setSize(932, 581);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        Container contentPane = getContentPane();
        
        JLabel userIcon = new JLabel();
        userIcon.setIcon(new ImageIcon("D:\\SEMESTER -3\\JAVA PROJECT\\usericon.png"));
        userIcon.setBounds(850, 10, 32, 32);
        contentPane.add(userIcon);

        JButton userName = new JButton("User Name");
        userName.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        userName.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\user-3296.png"));
        userName.setBounds(777, 10, 131, 32);
        contentPane.add(userName);

        // create a button
        JButton loginBtn = new JButton("Login");
        loginBtn.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        loginBtn.setBounds(296, 355, 111, 32);
        JButton signupBtn = new JButton("SignUp");
        signupBtn.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        signupBtn.setBounds(474, 355, 104, 32);

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
        contentPane.add(loginBtn);
        contentPane.add(signupBtn);
        searchField = new JTextField(20);
        getContentPane().add(searchField);
        searchField.setBounds(201, 273, 451, 32);
        searchButton = new JButton("Search");
        searchButton.setFont(new Font("Bahnschrift", Font.BOLD, 16));
        getContentPane().add(searchButton);
        searchButton.setBounds(662, 273, 104, 33);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\IMS-Logo-removebg-preview (1) (1).png"));
        lblNewLabel_1.setBounds(330, 142, 304, 110);
        getContentPane().add(lblNewLabel_1);
        
        
        
        
        JButton btnNewButton = new JButton("");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JMenuBar menuBar = new JMenuBar();
        		JMenu menu = new JMenu("File");
        		menuBar.add(menu);
        		JMenuItem menuItem = new JMenuItem("Open");
        		menu.add(menuItem);

        		// add the menu bar to the frame
        		
        	}
        });
        
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\noun-more-2412390 (1) (1) (2) (1).png"));
        btnNewButton.setFont(new Font("Bahnschrift", Font.BOLD, 12));
        btnNewButton.setBounds(10, 10, 23, 29);
        getContentPane().add(btnNewButton);
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\noun-chat-bot-1913797 (3).png"));
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		
        		
        	}
        });
        btnNewButton_1.setBounds(857, 490, 51, 44);
        getContentPane().add(btnNewButton_1);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\340554.png"));
        lblNewLabel.setBounds(0, 0, 918, 544);
        getContentPane().add(lblNewLabel);
        
        JTree tree = new JTree();
        tree.setBounds(20, 53, 70, 64);
        getContentPane().add(tree);
        
        JTextArea textArea1 = new JTextArea();
        textArea1.setBounds(196, 422, 389, 84);
        getContentPane().add(textArea1);
        
   
        
                searchButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {
                    	
                        String searchTerm = searchField.getText();
                        // perform search here, for example by calling a function
                        
                        String bb="select invention_url from Research_Archive where title like '"+searchTerm+"%';";
                        textArea1.setText("");


                        try {
                        	con = DriverManager.getConnection("jdbc:postgresql://Localhost/Login","postgres","venugopalkp");
                        	Statement s=con.createStatement();
							ResultSet result=s.executeQuery(bb);
							while(result.next()) {
								link = result.getString(1);
								textArea1.append(link + '\n'+'\n');
;
							}


							} catch (SQLException e1) {
							e1.printStackTrace();
							System.out.println("Searching for: " + searchTerm);
						}
                        System.out.println(link);
                    }
                

                    
                });

        // display the window
        setVisible(true);
    }

    public static void main(String[] args) {
        MainPage mainPage = new MainPage();
        
    }
}