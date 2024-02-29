package mysql;
import java.sql.*;
import org.postgresql.Driver;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JRadioButton;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Color;

public class Signup extends JFrame {

	private JPanel contentPane;
	private JTextField txtName;
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private JTextField txtage;
	private JTextField txtmobile;
	private JTextField txtmail;
	private JTextField txtusername;
	private JPasswordField txtpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Signup frame = new Signup();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Signup() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\SEMESTER -3\\JAVA PROJECT\\signupuser.jpg"));
		setTitle("SignUp");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name:");
		lblNewLabel.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		lblNewLabel.setBounds(85, 112, 108, 20);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Address:");
		lblNewLabel_1.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		lblNewLabel_1.setBounds(85, 142, 125, 20);
		contentPane.add(lblNewLabel_1);
		
		JLabel rb = new JLabel("Gender:");
		rb.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		rb.setBounds(85, 216, 125, 20);
		contentPane.add(rb);
		
		JLabel lblNewLabel_3 = new JLabel("Age:");
		lblNewLabel_3.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		lblNewLabel_3.setBounds(85, 301, 45, 25);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Mobile No:");
		lblNewLabel_4.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		lblNewLabel_4.setBounds(85, 349, 108, 20);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Email:");
		lblNewLabel_5.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		lblNewLabel_5.setBounds(85, 387, 84, 20);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Username: ");
		lblNewLabel_6.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		lblNewLabel_6.setBounds(85, 421, 84, 28);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Password: ");
		lblNewLabel_7.setFont(new Font("Bahnschrift", Font.BOLD, 14));
		lblNewLabel_7.setBounds(85, 467, 84, 20);
		contentPane.add(lblNewLabel_7);
		
		txtName = new JTextField();
		txtName.setBounds(192, 112, 151, 19);
		contentPane.add(txtName);
		txtName.setColumns(10);
		
		JTextArea txtAddress = new JTextArea();
		txtAddress.setBounds(192, 142, 149, 58);
		contentPane.add(txtAddress);
		
		JRadioButton rbMale = new JRadioButton("Male");
		rbMale.setForeground(new Color(0, 0, 0));
		rbMale.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonGroup.add(rbMale);
		rbMale.setBounds(192, 239, 103, 21);
		contentPane.add(rbMale);
		
		JRadioButton rbFemale = new JRadioButton("Female");
		rbFemale.setFont(new Font("Tahoma", Font.BOLD, 14));
		buttonGroup.add(rbFemale);
		rbFemale.setBounds(192, 262, 103, 21);
		contentPane.add(rbFemale);
		
		txtage = new JTextField();
		txtage.setBounds(192, 303, 45, 19);
		contentPane.add(txtage);
		txtage.setColumns(10);
		
		txtmobile = new JTextField();
		txtmobile.setBounds(194, 349, 149, 19);
		contentPane.add(txtmobile);
		txtmobile.setColumns(10);
		
		txtmail = new JTextField();
		txtmail.setBounds(194, 387, 149, 19);
		contentPane.add(txtmail);
		txtmail.setColumns(10);
		
		txtusername = new JTextField();
		txtusername.setBounds(194, 425, 149, 19);
		contentPane.add(txtusername);
		txtusername.setColumns(10);
		
		txtpassword = new JPasswordField();
		txtpassword.setBounds(194, 467, 149, 18);
		contentPane.add(txtpassword);
		
		JButton btnValidate = new JButton("Validate");
		btnValidate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				
					Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/SignUp", "postgres", "venugopalkp");
					String query = "insert into signup values(?,?,?,?,?,?,?,?)";
					PreparedStatement ps= con.prepareStatement(query);
					ps.setString(1, txtName.getText());
					ps.setString(2, txtAddress.getText());
					if(rbMale.isSelected())
						ps.setString(3, rbMale.getText());
					else
						ps.setString(3, rbFemale.getText());
					ps.setInt(4,  Integer.parseInt(txtage.getText()));
					ps.setInt(5,  Integer.parseInt(txtmobile.getText()));
					ps.setString(6, txtmail.getText());
					ps.setString(7, txtusername.getText());
					ps.setString(8, new String(txtpassword.getPassword()));
					
					int i  = ps.executeUpdate();
					JOptionPane.showMessageDialog(btnValidate, i+" Record added Successfully");
					
					ps.close();
					con.close();
					}catch(Exception e1) {
						
					e1.printStackTrace();
					}
				

				  
			 
			}
		});
		btnValidate.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		btnValidate.setBounds(192, 513, 118, 40);
		contentPane.add(btnValidate);
		
		
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtName.setText(" ");
				txtAddress.setText(" ");
				txtage.setText(" ");
				txtmobile.setText(" ");
				txtmail.setText(" ");
				txtusername.setText(" ");
				txtpassword.setText(" ");
				buttonGroup.clearSelection();
			}
		});
		btnReset.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		btnReset.setBounds(351, 513, 118, 40);
		contentPane.add(btnReset);
		
		JLabel lblNewLabel_8 = new JLabel("SIGNUP");
		lblNewLabel_8.setFont(new Font("Bahnschrift", Font.BOLD, 36));
		lblNewLabel_8.setBounds(328, 48, 151, 40);
		contentPane.add(lblNewLabel_8);
		
		JButton bthSubmit = new JButton("Submit");
		
		bthSubmit.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent e) {
		        try {
		            Class.forName("org.postgresql.Driver");
		            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost/Login", "postgres", "venugopalkp");
		            PreparedStatement st = con.prepareStatement("insert into login(username,password) values(?,?)");
		            st.setString(1, txtusername.getText());
		            st.setString(2, new String(txtpassword.getPassword()));
		            int i = st.executeUpdate();
		            if (i > 0) {
		                JOptionPane.showMessageDialog(null, "Data Saved");
		            } else {
		                JOptionPane.showMessageDialog(null, "Data Not Saved");
		            }
		        } catch (Exception ex) {
		            ex.printStackTrace();
		        }
		    }
		});
		bthSubmit.setFont(new Font("Bahnschrift", Font.BOLD, 16));
		bthSubmit.setBounds(500, 513, 125, 40);
		contentPane.add(bthSubmit);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\IMS-Logo-removebg-preview (1).png"));
		lblNewLabel_2.setBounds(-16, 0, 140, 48);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_9 = new JLabel("New label");
		lblNewLabel_9.setBackground(new Color(0, 128, 255));
		lblNewLabel_9.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\340554.png"));
		lblNewLabel_9.setBounds(-6, 0, 803, 563);
		contentPane.add(lblNewLabel_9);
	}
}
