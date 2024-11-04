import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import hello.Satabase;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingUtilities;
import javax.swing.JSeparator;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Pattern;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class SignUp extends JFrame {
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField pwdConfirmPassword;
	private JTextField txtEmail;
	private JTextField txtPhoneNumber;
	private JLabel iconLabel;

    public SignUp() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.WHITE);

        // Title label
        JLabel lblNewLabel_1 = new JLabel("Sign UP");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-sign-up-100.png"));
        lblNewLabel_1.setForeground(new Color(100, 149, 237));
        lblNewLabel_1.setFont(new Font("Segoe UI", Font.BOLD, 36));

        // Right-side image label
        JLabel lblNewLabel = new JLabel("");
        lblNewLabel.setIcon(new ImageIcon("C:\\Users\\imaxp\\OneDrive - OAC - Ono Academic College\\תמונות\\vv.png"));

        // Password icon label
        JLabel lblNewLabel2 = new JLabel("");
        lblNewLabel2.setFont(new Font("Gill Sans Ultra Bold", Font.PLAIN, 14));
        lblNewLabel2.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-password-key-30.png"));

        // Create the left-side panel with background color
        JPanel panel = new JPanel();
        panel.setToolTipText("");
        panel.setBackground(new Color(0, 102, 102));
        
        JLabel lblNewLabel_2 = new JLabel("");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-name-30.png"));
        
        textField = new JTextField();
        textField.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		if(textField.getText().equals("User Name"))
        		{
        			textField.setText(null);
        		}
        	}
        });
        textField.setText("User Name");
        textField.setForeground(new Color(0, 0, 0));
        textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
        textField.setColumns(10);
        textField.setBorder(null);
        
        JLabel lblNewLabel_2_1 = new JLabel("");
        lblNewLabel_2_1.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-password-30.png"));
        
        JSeparator separator = new JSeparator();
        passwordField = new JPasswordField();
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
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 11));
        passwordField.setText("Password");
        passwordField.setEchoChar((char) 0);
        passwordField.setBorder(null);
        
        JLabel lblNewLabel_2_1_1 = new JLabel("");
        lblNewLabel_2_1_1.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-password-30.png"));
        
        pwdConfirmPassword = new JPasswordField();
        pwdConfirmPassword.setFont(new Font("Tahoma", Font.PLAIN, 11));
        pwdConfirmPassword.setText(" Confirm Password");
        pwdConfirmPassword.setEchoChar((char) 0);
        pwdConfirmPassword.setBorder(null);
        
        pwdConfirmPassword.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		if (String.valueOf(pwdConfirmPassword.getPassword()).equals(" Confirm Password")) {
        			pwdConfirmPassword.setText(""); // Clear the field
        			pwdConfirmPassword.setEchoChar('•'); // Show dots when user types
        			pwdConfirmPassword.setForeground(Color.BLACK); // Set text color to black
                }
        	}
        });
       
        JSeparator separator_1 = new JSeparator();
        
        JSeparator separator_1_1 = new JSeparator();
        
        JLabel lblNewLabel_2_2 = new JLabel("");
        lblNewLabel_2_2.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-email-30.png"));
        
        txtEmail = new JTextField();
        txtEmail.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		if(txtEmail.getText().equals("Email"))
        		{
        			txtEmail.setText(null);
        		}
        	}
        });
        txtEmail.setText("Email");
        txtEmail.setForeground(new Color(0, 0, 0));
        txtEmail.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtEmail.setColumns(10);
        txtEmail.setBorder(null);
        
        JSeparator separator_2 = new JSeparator();
        
        JLabel lblNewLabel_2_2_1 = new JLabel("");
        lblNewLabel_2_2_1.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-phone-30.png"));
        
        txtPhoneNumber = new JTextField();
        txtPhoneNumber.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseEntered(MouseEvent e) {
        		if(txtPhoneNumber.getText().equals("Phone"))
        		{
        			txtPhoneNumber.setText(null);
        		}
        	}
        });
        txtPhoneNumber.setText("Phone");
        txtPhoneNumber.setForeground(new Color(0, 0, 0));
        txtPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 11));
        txtPhoneNumber.setColumns(10);
        txtPhoneNumber.setBorder(null);
        
        JLabel lblNewLabel_3 = new JLabel("");
        JSeparator separator_2_1 = new JSeparator();
        iconLabel = new JLabel("");
        JButton btnNewButton = new JButton("Create");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String emailPattern = "^[a-zA-Z]+@gmail\\.com$";
                String phonePattern = "^05\\d{8}$";
                boolean bdeka = true;

                if (textField.getText().isEmpty() || passwordField.getText().isEmpty() || pwdConfirmPassword.getText().isEmpty() || txtEmail.getText().isEmpty() || txtPhoneNumber.getText().isEmpty()) {
                    JOptionPane.showMessageDialog(null, "אחד השדות לא נכתב!", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    bdeka = false;
                }
                if (!passwordField.getText().equals(pwdConfirmPassword.getText())) {
                    JOptionPane.showMessageDialog(null, "הסיסמאות אינן תואמות!", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    bdeka = false;
                }
                if (txtEmail.getText() == null || !Pattern.matches(emailPattern, txtEmail.getText())) {
                    JOptionPane.showMessageDialog(null, "כתובת המייל אינה תקינה! יש לוודא שהיא בפורמט a..@gmail.com", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    bdeka = false;
                }
                if (txtPhoneNumber.getText() == null || !Pattern.matches(phonePattern, txtPhoneNumber.getText())) {
                    JOptionPane.showMessageDialog(null, "מספר הטלפון אינו תקין! יש לוודא שהוא מתחיל ב-05 ואחריו 8 ספרות.", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    bdeka = false;
                }

                if (bdeka == true) {
                	
                    // Show the icon
                  
                    
                    
                    String username = textField.getText();
                    String email = txtEmail.getText();
                    String password = String.valueOf(passwordField.getPassword());
                    String phone = txtPhoneNumber.getText();

                    Connection conn = Satabase.connect(); // Connect to the database

                    // SQL queries to check if the email or username already exists
                    String checkEmailSQL = "SELECT COUNT(*) FROM admins WHERE Email = ?";
                    String checkUsernameSQL = "SELECT COUNT(*) FROM admins WHERE `User Name` = ?";
                    String sql = "INSERT INTO admins (`User Name`, Email, Password, `Phone Number`) VALUES (?, ?, ?, ?)";

                    try {
                        // Check if the email already exists
                        PreparedStatement checkEmailStmt = conn.prepareStatement(checkEmailSQL);
                        checkEmailStmt.setString(1, email);
                        ResultSet emailResultSet = checkEmailStmt.executeQuery();
                        emailResultSet.next();

                        // If the email already exists, show an error message
                        if (emailResultSet.getInt(1) > 0) {
                            JOptionPane.showMessageDialog(null, "Email already exists. Please use a different email.", "Error", JOptionPane.ERROR_MESSAGE);
                        } else {
                            // Check if the username already exists
                            PreparedStatement checkUsernameStmt = conn.prepareStatement(checkUsernameSQL);
                            checkUsernameStmt.setString(1, username);
                            ResultSet usernameResultSet = checkUsernameStmt.executeQuery();
                            usernameResultSet.next();

                            // If the username already exists, show an error message
                            if (usernameResultSet.getInt(1) > 0) {
                            	
                                JOptionPane.showMessageDialog(null, "Username already exists. Please choose a different username.", "Error", JOptionPane.ERROR_MESSAGE);
                            } else {
                                // Proceed with the insert since both email and username are unique
                                PreparedStatement preparedStatement = conn.prepareStatement(sql);
                                preparedStatement.setString(1, username);
                                preparedStatement.setString(2, email);
                                preparedStatement.setString(3, password);
                                preparedStatement.setString(4, phone);

                                int rowsInserted = preparedStatement.executeUpdate(); // Execute the insert
                                if (rowsInserted > 0) {
                                    JOptionPane.showMessageDialog(null, "החשבון שלך נוצר בהצלחה! ברוך הבא!", "הצלחה", JOptionPane.INFORMATION_MESSAGE);
                                    Login l=new Login();
                                    l.setVisible(true); 
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "שגיאה בעת שמירת הנתונים בבסיס הנתונים.", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        Satabase.disconnect(); // Close the connection
                    }

                    
                    }
            }});

        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
        btnNewButton.setBackground(new Color(0,102,102));
        
        JButton btnNewButton_1 = new JButton("");
        btnNewButton_1.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		setVisible(false);
        		Login h=new Login();
        		h.setVisible(true);
        	}
        });
        btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-right-50.png"));
        
        

        // GroupLayout for responsiveness
        GroupLayout layout = new GroupLayout(getContentPane());
        layout.setHorizontalGroup(
        	layout.createParallelGroup(Alignment.LEADING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.TRAILING)
        						.addGroup(layout.createSequentialGroup()
        							.addContainerGap()
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addGroup(layout.createSequentialGroup()
        											.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        											.addPreferredGap(ComponentPlacement.RELATED))
        										.addComponent(separator_1, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(txtEmail, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)
        										.addComponent(separator_2, GroupLayout.DEFAULT_SIZE, 270, Short.MAX_VALUE)))
        								.addGroup(layout.createSequentialGroup()
        									.addComponent(lblNewLabel_2)
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(textField, 138, 138, 138)
        										.addComponent(separator, GroupLayout.PREFERRED_SIZE, 138, GroupLayout.PREFERRED_SIZE))
        									.addGap(6)))
        							.addGap(24)
        							.addComponent(lblNewLabel_3, GroupLayout.PREFERRED_SIZE, 48, GroupLayout.PREFERRED_SIZE))
        						.addGroup(layout.createSequentialGroup()
        							.addGap(27)
        							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 253, GroupLayout.PREFERRED_SIZE)))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 61, GroupLayout.PREFERRED_SIZE)
        					.addGap(16))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 152, GroupLayout.PREFERRED_SIZE)
        						.addComponent(pwdConfirmPassword, GroupLayout.DEFAULT_SIZE, 429, Short.MAX_VALUE)))
        				.addGroup(layout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(lblNewLabel_2_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING, false)
        						.addComponent(separator_2_1, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 152, Short.MAX_VALUE)
        						.addComponent(txtPhoneNumber, Alignment.TRAILING))
        					.addPreferredGap(ComponentPlacement.RELATED)
        					.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 92, GroupLayout.PREFERRED_SIZE)))
        			.addPreferredGap(ComponentPlacement.RELATED)
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 485, GroupLayout.PREFERRED_SIZE)
        			.addGap(6))
        );
        layout.setVerticalGroup(
        	layout.createParallelGroup(Alignment.TRAILING)
        		.addGroup(layout.createSequentialGroup()
        			.addGroup(layout.createParallelGroup(Alignment.LEADING)
        				.addGroup(layout.createSequentialGroup()
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGap(21)
        							.addComponent(lblNewLabel_1, GroupLayout.PREFERRED_SIZE, 100, GroupLayout.PREFERRED_SIZE)
        							.addGroup(layout.createParallelGroup(Alignment.LEADING)
        								.addGroup(layout.createSequentialGroup()
        									.addGap(38)
        									.addGroup(layout.createParallelGroup(Alignment.TRAILING, false)
        										.addComponent(lblNewLabel_2)
        										.addGroup(layout.createSequentialGroup()
        											.addComponent(textField, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        											.addPreferredGap(ComponentPlacement.RELATED, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        											.addComponent(separator, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)))
        									.addPreferredGap(ComponentPlacement.UNRELATED)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addComponent(lblNewLabel_2_2, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        										.addGroup(layout.createSequentialGroup()
        											.addComponent(txtEmail, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        											.addPreferredGap(ComponentPlacement.RELATED)
        											.addComponent(separator_2, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)))
        									.addPreferredGap(ComponentPlacement.RELATED)
        									.addGroup(layout.createParallelGroup(Alignment.LEADING)
        										.addGroup(layout.createSequentialGroup()
        											.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        											.addPreferredGap(ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
        											.addComponent(separator_1, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
        										.addComponent(lblNewLabel_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)))
        								.addGroup(layout.createSequentialGroup()
        									.addGap(45)
        									.addComponent(lblNewLabel_3))))
        						.addComponent(btnNewButton_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE))
        					.addPreferredGap(ComponentPlacement.UNRELATED)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addComponent(lblNewLabel_2_1_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE)
        						.addGroup(layout.createSequentialGroup()
        							.addComponent(pwdConfirmPassword, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(separator_1_1, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE)))
        					.addGap(19)
        					.addGroup(layout.createParallelGroup(Alignment.LEADING)
        						.addGroup(layout.createSequentialGroup()
        							.addGroup(layout.createParallelGroup(Alignment.BASELINE)
        								.addComponent(txtPhoneNumber, GroupLayout.PREFERRED_SIZE, 14, GroupLayout.PREFERRED_SIZE)
        								.addComponent(btnNewButton))
        							.addPreferredGap(ComponentPlacement.RELATED)
        							.addComponent(separator_2_1, GroupLayout.PREFERRED_SIZE, 11, GroupLayout.PREFERRED_SIZE))
        						.addComponent(lblNewLabel_2_2_1, GroupLayout.PREFERRED_SIZE, 30, GroupLayout.PREFERRED_SIZE))
        					.addGap(125))
        				.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 482, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(52, Short.MAX_VALUE))
        );
        getContentPane().setLayout(layout);

        // Frame settings
        setSize(700, 400); // Set the size of the frame
        setLocationRelativeTo(null); // Center the frame on the screen
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new SignUp().setVisible(true); // Make the frame visible
        });
    }
}
