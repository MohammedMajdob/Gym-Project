import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;

import hello.Satabase;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Login extends JFrame {
    private JTextField txtUserName;
    private JButton lllll;
    private JPasswordField passwordField;

    public Login() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);
        txtUserName = new JTextField();
        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
        passwordField.setText("Password");
        passwordField.setEchoChar((char) 0);
        passwordField.setBorder(null);
        
        
        // Create the left-side panel with background color
        JPanel panel = new JPanel();
        panel.setToolTipText("");
        panel.setBackground(new Color(0, 102, 102));

        // Labels and text fields for the login form
        JLabel lblNewLabel_1 = new JLabel("Sign in");
        lblNewLabel_1.setForeground(new Color(0, 102, 102));
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 36));
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-sign-in-100.png"));

        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 14));
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-checked-identification-documents-30.png"));

       
        txtUserName.setBorder(null);
        txtUserName.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		if(txtUserName.getText().equals("User Name"))
        		{
        		txtUserName.setText(null);
        		}
        	}
        	
        	
        	
        });
       
        
        
        
        	
        	
        
        txtUserName.setForeground(new Color(0, 0, 0));
        txtUserName.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtUserName.setText("User Name");
        txtUserName.setColumns(10);

        JLabel lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 14));
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-password-30 (1).png"));

        lllll = new JButton("Login");
        lllll.setBackground(new Color(0,102, 102));
        lllll.setForeground(new Color(245, 255, 250));
        lllll.setFont(new Font("Aharoni", Font.ITALIC, 11));
       
        JLabel nnnn = new JLabel("");
       
     
        lllll.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Show the icon when the login button is pressed
                

                // Run the delayed logic in a new thread to avoid blocking the UI
                new Thread(() -> {
                   

                    // Once sleep is over, hide the icon and validate input
                    SwingUtilities.invokeLater(() -> {
                        // Hide the icon after 1.5 seconds
                        

                        // Validate if the username or password fields are empty
                        if (txtUserName.getText().isEmpty() || passwordField.getPassword().length == 0) {
                            // Show an error message if either field is empty
                            JOptionPane.showMessageDialog(
                                nnnn,  // Parent component (for centering the dialog)
                                "Username or Password cannot be empty!",  // Message to display
                                "Error",  // Title of the dialog
                                JOptionPane.ERROR_MESSAGE  // Error icon
                            );
                        } else {
                            // Proceed with checking the database for username and password
                            String username = txtUserName.getText();
                            String password = String.valueOf(passwordField.getPassword());

                            // Database connection
                            Connection conn = Satabase.connect(); // Make sure Satabase is your class for DB connection
                            String sql = "SELECT COUNT(*) FROM admins WHERE `User Name` = ? AND Password = ?";

                            try {
                                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                                preparedStatement.setString(1, username);
                                preparedStatement.setString(2, password);

                                ResultSet resultSet = preparedStatement.executeQuery();
                                resultSet.next();

                                // Check if a matching user is found
                                if (resultSet.getInt(1) > 0) {
                                    // Successful login
                                   
                                    HomePageSystem a=new HomePageSystem();
                                    setVisible(false);
                                    a.setVisible(true);
                                    
                                    
                                    
                                    
                                    // You can add further logic here for successful login
                                } else {
                                    // Invalid username or password
                                    JOptionPane.showMessageDialog(nnnn, "Invalid Username or Password!", "Error", JOptionPane.ERROR_MESSAGE);
                                }
                            } catch (SQLException ex) {
                                ex.printStackTrace();
                                JOptionPane.showMessageDialog(nnnn, "Database error. Please try again later.", "Error", JOptionPane.ERROR_MESSAGE);
                            } finally {
                                Satabase.disconnect(); // Ensure to close the connection
                            }
                        }
                    });
                }).start();
            }
        });

        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        	}
        });
        
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mousePressed(MouseEvent e) {
        		  passwordField.setEchoChar((char) 0);
        	}
        	@Override
        	public void mouseReleased(MouseEvent e) {
        		 passwordField.setEchoChar('*');
        	}
        });
       
        
       
        
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-show-password-30 (1).png"));
        
        JButton btnForgetPassword = new JButton("Sign Up");
        btnForgetPassword.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		SignUp s=new SignUp();
        		setVisible(false);
        		s.setVisible(true);
        		
        	}
        });
        btnForgetPassword.setForeground(new Color(245, 255, 250));
        btnForgetPassword.setFont(new Font("Aharoni", Font.ITALIC, 11));
        btnForgetPassword.setBackground(new Color(0,102,102));
        ImageIcon img =new ImageIcon(this.getClass().getResource("/kkk.png"));
        
        JLabel lblNewLabel_6 = new JLabel("New label");
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-pullups.gif"));
        
        JLabel lblNewLabel_4 = new JLabel("New label");
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-pullups.gif"));
        
        
        passwordField.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		 if (String.valueOf(passwordField.getPassword()).equals("Password")) {
                     passwordField.setText(""); // Clear the field
                     passwordField.setEchoChar('•'); // Show dots when user types
                     passwordField.setForeground(Color.BLACK); // Set text color to black
                 }
        	}
        });
     
        
        JSeparator separator = new JSeparator();
        
        JSeparator separator_1 = new JSeparator();
        
        JSeparator separator_2 = new JSeparator();
        // Create the layout manager for the content pane
        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, 300, GroupLayout.PREFERRED_SIZE)
        			.addGap(60)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblNewLabel_1)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createParallelGroup(Alignment.LEADING)
        					.addGroup(layout.createSequentialGroup()
        						.addGroup(layout.createParallelGroup(Alignment.LEADING)
        							.addGroup(layout.createSequentialGroup()
        								.addComponent(lblNewLabel_3)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        									.addComponent(passwordField)
        									.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 81, Short.MAX_VALUE))
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 47, GroupLayout.PREFERRED_SIZE)
        								.addPreferredGap(ComponentPlacement.RELATED, 185, Short.MAX_VALUE)
        								.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        								.addGap(47))
        							.addGroup(layout.createSequentialGroup()
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addComponent(lblNewLabel_2)
        								.addPreferredGap(ComponentPlacement.RELATED)
        								.addGroup(layout.createParallelGroup(Alignment.LEADING)
        									.addComponent(separator, GroupLayout.PREFERRED_SIZE, 81, GroupLayout.PREFERRED_SIZE)
        									.addComponent(txtUserName, 136, 136, 136)))
        							.addComponent(nnnn))
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 0, GroupLayout.PREFERRED_SIZE)
        						.addGap(230))
        					.addGroup(layout.createSequentialGroup()
        						.addComponent(lllll)
        						.addPreferredGap(ComponentPlacement.RELATED)
        						.addComponent(btnForgetPassword))))
        			.addGap(267))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addComponent(panel, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 869, Short.MAX_VALUE)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lblNewLabel_1)
        				.addComponent(lblNewLabel_4, GroupLayout.PREFERRED_SIZE, 71, GroupLayout.PREFERRED_SIZE))
        			.addGap(20)
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(txtUserName, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        					.addComponent(separator, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
        					.addGap(18))
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(lblNewLabel_2)
        					.addPreferredGap(ComponentPlacement.RELATED)))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addComponent(lblNewLabel_3)
        				.addGroup(layout.createSequentialGroup()
        					.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)
        						.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 13, GroupLayout.PREFERRED_SIZE)))
        				.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 33, Short.MAX_VALUE))
        			.addGap(18)
        			.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        				.addComponent(lllll)
        				.addComponent(btnForgetPassword, GroupLayout.PREFERRED_SIZE, 21, GroupLayout.PREFERRED_SIZE))
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGap(32)
        					.addComponent(lblNewLabel_6, GroupLayout.PREFERRED_SIZE, 176, GroupLayout.PREFERRED_SIZE))
        				.addGroup(layout.createSequentialGroup()
        					.addGap(18)
        					.addComponent(nnnn)))
        			.addGap(420))
        );
        panel.setLayout(null);
        
        JLabel lblNewLabel_7 = new JLabel("");
        lblNewLabel_7.setBounds(26, 29, 264, 325);
        panel.add(lblNewLabel_7);
        lblNewLabel_7.setIcon(img);
        getContentPane().setLayout(layout);

        // Automatically create gaps between components
        layout.setAutoCreateGaps(true);
        layout.setAutoCreateContainerGaps(true);

        // Frame settings
        setSize(700, 400);
        setLocationRelativeTo(null);
        
    }
}
