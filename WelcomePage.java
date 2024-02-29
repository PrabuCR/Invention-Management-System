package mysql;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class WelcomePage extends JFrame {
	private static final long serialVersionUID = 1L;
		private JTextField searchField;
	    private JButton searchButton;
	    Connection con;
	    String[] arr = new String[50];
	    JLabel lblNewLabel_1;
	    String link;
	    
	    public WelcomePage() {
	        setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\SEMESTER -3\\JAVA PROJECT\\signupuser.jpg"));

	        // set the properties of the window
	        
	    	
	    	
	    	

	    	
	        setTitle("Invention Management System");
	        setSize(932, 581);
	        setLocationRelativeTo(null);
	        setDefaultCloseOperation(EXIT_ON_CLOSE);
	        Container contentPane = getContentPane();
	        getContentPane().setLayout(null);
	        
	        JLabel userIcon = new JLabel();
	        userIcon.setBounds(850, 10, 32, 32);
	        userIcon.setIcon(new ImageIcon("D:\\SEMESTER -3\\JAVA PROJECT\\usericon.png"));
	        contentPane.add(userIcon);
	        
	     
	        JButton userName = new JButton("User name");
	        userName.setBounds(792, 10, 95, 21);
	        contentPane.add(userName);
	        
	        // create a button
	        JButton loginBtn = new JButton("Login");
	        loginBtn.setBounds(314, 162, 95, 21);
	        JButton signupBtn = new JButton("SignUp");
	        signupBtn.setBounds(424, 162, 91, 21);

	        // add an action listener to the button
	        loginBtn.addActionListener(new ActionListener() {
	            public void actionPerformed(ActionEvent e) {
	                Login login = new Login();
	                login.setVisible(true);
	                dispose();

	            }
	        });

	        // add the buttons to the contentPane
	        contentPane.add(loginBtn);
	        contentPane.add(signupBtn);
	        searchField = new JTextField(20);
	        searchField.setBounds(235, 121, 350, 19);
	        getContentPane().add(searchField);
	        searchButton = new JButton("Search");
	        searchButton.setBounds(595, 120, 95, 21);
	        getContentPane().add(searchButton);
	        JLabel lblNewLabel = new JLabel("IMS SCHOLAR");
	        lblNewLabel.setBounds(347, 76, 168, 13);
	        lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
	        getContentPane().add(lblNewLabel);
	        
	        JTextArea textArea = new JTextArea("");
	        textArea.setBounds(196, 422, 389, 84);
	        getContentPane().add(textArea);
	        
	       
	        
	       
	        

	                searchButton.addActionListener(new ActionListener() {
	                    public void actionPerformed(ActionEvent e) {
	                        String searchTerm = searchField.getText();
	                        String bb="select invention_url from Research_Archive where title like '"+searchTerm+"%';";
	                        textArea.setText("");


	                        try {
	                        	con = DriverManager.getConnection("jdbc:postgresql://Localhost/Login","postgres","venugopalkp");
	                        	Statement s=con.createStatement();
								ResultSet result=s.executeQuery(bb);
								while(result.next()) {
									link = result.getString(1);
									textArea.append(link + '\n'+'\n');
;
								}


								} catch (SQLException e1) {
								e1.printStackTrace();
								System.out.println("Searching for: " + searchTerm);
							}
	                        System.out.println(link);
	                    }
	                });

	                
//	                JTextArea textArea = new JTextArea();
//	                textArea.setBounds(124, 366, 402, 147);
//	                getContentPane().add(textArea);
//	                textArea.setEditable(false);
//	                
//	                
//	                for(int i=0;i<arr.length;i++) {
//	                    textArea.append(arr[i]+"\n");
//	                }

	        // display the window
	        setVisible(true);
	    }

	    public static void main(String[] args) {
	        WelcomePage welcomePage = new WelcomePage();
	        
	    }
}
