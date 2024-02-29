package mysql;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.ImageIcon;

public class chatbot {
    public static void main(String[] args) {
        // create a new JFrame
        JFrame frame = new JFrame();
        frame.setSize(805, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // create a button for "Hello"
        JButton buttonHello = new JButton("Hello");
        buttonHello.setFont(new Font("Bahnschrift", Font.BOLD, 10));
        buttonHello.setBounds(109, 59, 99, 26);
        frame.getContentPane().add(buttonHello);
        
        // create a button for "How are you?"
        JButton buttonCon = new JButton("Contact us");
        buttonCon.setFont(new Font("Bahnschrift", Font.BOLD, 10));
        buttonCon.setBounds(218, 95, 99, 26);
        frame.getContentPane().add(buttonCon);
        
        JButton buttonUpl = new JButton("Uploading");
        buttonUpl.setFont(new Font("Bahnschrift", Font.BOLD, 10));
        buttonUpl.setBounds(459, 95, 99, 26);
        frame.getContentPane().add(buttonUpl);
        
        JButton btnSignUp = new JButton("Sign up");
        btnSignUp.setFont(new Font("Bahnschrift", Font.BOLD, 10));
        btnSignUp.setBounds(459, 59, 99, 26);
        frame.getContentPane().add(btnSignUp);
        
        JButton btnCollaboration = new JButton("Collaboration");
        btnCollaboration.setFont(new Font("Bahnschrift", Font.BOLD, 10));
        btnCollaboration.setBounds(218, 59, 99, 26);
        frame.getContentPane().add(btnCollaboration);
        
        JButton btnPatentStatus = new JButton("Patent");
        btnPatentStatus.setFont(new Font("Tahoma", Font.BOLD, 10));
        btnPatentStatus.setBounds(324, 59, 127, 26);
        frame.getContentPane().add(btnPatentStatus);
        
        JButton btnClaimingRewards = new JButton("Claiming Rewards");
        btnClaimingRewards.setFont(new Font("Bahnschrift", Font.BOLD, 10));
        btnClaimingRewards.setBounds(566, 59, 119, 26);
        frame.getContentPane().add(btnClaimingRewards);
        
        JButton btnBoomark = new JButton("Boomarks");
        btnBoomark.setFont(new Font("Bahnschrift", Font.BOLD, 10));
        btnBoomark.setBounds(341, 95, 97, 26);
        frame.getContentPane().add(btnBoomark);
        
        JTextArea textArea = new JTextArea();
        textArea.setBounds(57, 131, 670, 342);
        frame.getContentPane().add(textArea);
        
        JLabel lblNewLabel = new JLabel("New label");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\IMS-Logo-removebg-preview (1).png"));
        lblNewLabel.setBounds(-18, 0, 136, 41);
        frame.getContentPane().add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("New label");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\DELL\\Downloads\\340554.png"));
        lblNewLabel_1.setBounds(0, 0, 791, 513);
        frame.getContentPane().add(lblNewLabel_1);

        // add an ActionListener to the button
        buttonHello.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textArea.setText("");
            	textArea.append("Hello!"+"\n"+"Select the topics to know more about them"+"\n");
            }
        });
        buttonCon.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textArea.setText("");
            	textArea.append("The Contact number: 123456789"+"\n"+"Email id: ims@gmail.com");
               
            }
        });
        buttonUpl.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textArea.setText("");
            	textArea.append("Uploading");
               
            }
        });
        btnSignUp.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textArea.setText("");
            	textArea.append("Sign up");
               
            }
        });
        btnCollaboration.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textArea.setText("");
            	textArea.append("Collaboration");
               
            }
        });
        btnPatentStatus.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textArea.setText("");
            	textArea.append("What is patent?"+"\n"+"A patent is an exclusive right granted for an invention."+"\n"+" In other words, a patent is an exclusive right to a product or a process that"+"\n"+" generally provides a new way of doing something, or offers a new technical solution to a problem."+"\n"+" To get a patent, technical information about the invention must be disclosed to the public in a patent application.");
               
            }
        });
        btnClaimingRewards.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textArea.setText("");
            	textArea.append("Reward");
               
            }
        });
        btnBoomark.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	textArea.setText("");
            	textArea.append("Bookmark");
               
            }
        });

        // make the frame visible
        frame.setVisible(true);
    }
}