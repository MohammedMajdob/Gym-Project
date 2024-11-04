import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import hello.Satabase;

import javax.swing.border.CompoundBorder;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddMember extends JFrame {
    private JPanel rightPanel;
    private JPanel panel;
    private JLabel lblNewLabel;
    private JLabel lblNewLabel_1;
    private JSeparator separator;
    private JButton btnNewButton;
    private JPanel panel_1;
    private JPanel panel_4;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_5;
    private JLabel lblNewLabel_6;
    private JComboBox<String> comboBox;
    private JLabel lblNewLabel_7;
    private JTextField textField_2;
    private JTextField textField_3;
    private JButton btnNewButton_1;
    private JButton btnNewButton_2;
    private JButton btnNewButton_3;
    private JPanel panel_2;
    private DefaultTableModel model;
    private JTable table_1;
    private JTextField textField;
    private JTextField textField_1;
    private JSeparator separator_1;
    private JSeparator separator_2;
    private JSeparator separator_3;
    private JTextField txtSearch;
    private JSeparator separator_4;
    private JLabel lblNewLabel_9;
    private JComboBox<String> comboBox_1;
    private JButton btnHome;
    private JButton btnNewButton_4;

    public AddMember() {
        // Set up the frame
        setTitle("Home Page System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(902, 399);  // Same size as Login class
        setLocationRelativeTo(null);
        getContentPane().setLayout(null);
        
        rightPanel = new JPanel();
        rightPanel.setLayout(null);
        rightPanel.setBackground(new Color(0, 102, 102));
        rightPanel.setBounds(0, 0, 890, 367);
        getContentPane().add(rightPanel);
        
        panel = new JPanel();
        panel.setLayout(null);
        panel.setForeground(Color.WHITE);
        panel.setBackground(new Color(0, 102, 102));
        panel.setBounds(0, 0, 167, 365);
        rightPanel.add(panel);
        
        lblNewLabel = new JLabel("Welcome Admin");
        lblNewLabel.setForeground(new Color(245, 255, 250));
        lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 19));
        lblNewLabel.setBounds(10, 72, 176, 42);
        panel.add(lblNewLabel);
        
        lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-admin-80.png"));
        lblNewLabel_1.setBounds(46, 0, 87, 85);
        panel.add(lblNewLabel_1);
        
        separator = new JSeparator();
        separator.setBounds(0, 112, 166, 2);
        panel.add(separator);
        
        btnNewButton = new JButton("Add Member");
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-add-member-30.png"));
        btnNewButton.setForeground(Color.WHITE);
        btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 17));
        btnNewButton.setBorder(null);
        btnNewButton.setBackground(new Color(0, 102, 102));
        btnNewButton.setBounds(0, 176, 166, 48);
        panel.add(btnNewButton);
        
        btnHome = new JButton("Home");
        btnHome.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		HomePageSystem f=new HomePageSystem();
        		setVisible(false);
        		f.setVisible(true);
        		
        	}
        });
        btnHome.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-home-35.png"));
        btnHome.setForeground(Color.WHITE);
        btnHome.setFont(new Font("Segoe UI Black", Font.BOLD, 17));
        btnHome.setBorder(null);
        btnHome.setBackground(new Color(0, 102, 102));
        btnHome.setBounds(0, 117, 166, 48);
        panel.add(btnHome);
        
        panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 156, 112);
        rightPanel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_3 = new JPanel();
        panel_3.setBackground(new Color(0, 102, 102));
        panel_3.setBounds(166, 0, 724, 354);
        rightPanel.add(panel_3);
        panel_3.setLayout(null);
        
        panel_4 = new JPanel();
        panel_4.setBackground(Color.WHITE);
        panel_4.setBounds(0, 172, 714, 182);
        panel_3.add(panel_4);
        panel_4.setLayout(null);
        panel_4.setForeground(new Color(255, 255, 255));
        
        lblNewLabel_2 = new JLabel("MemberID :");
        lblNewLabel_2.setForeground(new Color(95, 158, 160));
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-checked-identification-documents-30 (1).png"));
        lblNewLabel_2.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNewLabel_2.setBounds(10, 11, 130, 30);
        panel_4.add(lblNewLabel_2);
        
        lblNewLabel_3 = new JLabel("First Name :");
        lblNewLabel_3.setForeground(new Color(95, 158, 160));
        lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-name-30 (1).png"));
        lblNewLabel_3.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNewLabel_3.setBounds(10, 54, 130, 30);
        panel_4.add(lblNewLabel_3);
        
        lblNewLabel_4 = new JLabel("Last Name :");
        lblNewLabel_4.setForeground(new Color(95, 158, 160));
        lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-name-30 (2).png"));
        lblNewLabel_4.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNewLabel_4.setBounds(10, 95, 130, 30);
        panel_4.add(lblNewLabel_4);
        
        lblNewLabel_5 = new JLabel("Phone Number :");
        lblNewLabel_5.setForeground(new Color(95, 158, 160));
        lblNewLabel_5.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-phone-32.png"));
        lblNewLabel_5.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNewLabel_5.setBounds(10, 141, 167, 30);
        panel_4.add(lblNewLabel_5);
        
        lblNewLabel_6 = new JLabel("Gender :");
        lblNewLabel_6.setForeground(new Color(95, 158, 160));
        lblNewLabel_6.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-gender-30.png"));
        lblNewLabel_6.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNewLabel_6.setBounds(298, 20, 106, 30);
        panel_4.add(lblNewLabel_6);
        
        String[] options = {"Male", "Female"};
        comboBox = new JComboBox<>(options);
        comboBox.setBounds(410, 27, 67, 22);
        panel_4.add(comboBox);

        JSpinner spinner = new JSpinner(new SpinnerDateModel());
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(spinner, "yyyy-MM-dd");
        spinner.setEditor(dateEditor);
        spinner.setBounds(454, 70, 102, 20);
        panel_4.add(spinner);
        
        lblNewLabel_7 = new JLabel("Date Member :");
        lblNewLabel_7.setForeground(new Color(95, 158, 160));
        lblNewLabel_7.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-date-30.png"));
        lblNewLabel_7.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNewLabel_7.setBounds(298, 62, 146, 30);
        panel_4.add(lblNewLabel_7);
        
        textField_2 = new JTextField();
        textField_2.setBackground(Color.WHITE);
        textField_2.setForeground(Color.BLACK);
        textField_2.setFont(new Font("Tahoma", Font.PLAIN, 11));
        textField_2.setColumns(10);
        textField_2.setBorder(null);
        textField_2.setBounds(142, 103, 96, 14);
        panel_4.add(textField_2);
        
        textField_3 = new JTextField();
        textField_3.setBackground(Color.WHITE);
        textField_3.setForeground(Color.BLACK);
        textField_3.setFont(new Font("Tahoma", Font.PLAIN, 11));
        textField_3.setColumns(10);
        textField_3.setBorder(null);
        textField_3.setBounds(176, 152, 96, 14);
        panel_4.add(textField_3);
        
        btnNewButton_1 = new JButton("Confirm");
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve values from text fields and combo box
                String memberID = textField.getText().trim();
                String firstName = textField_1.getText().trim();
                String lastName = textField_2.getText().trim();
                String phoneNumber = textField_3.getText().trim();
                String gender = comboBox.getSelectedItem().toString();
                String joinDate = ((JSpinner.DateEditor) spinner.getEditor()).getFormat().format(spinner.getValue());
                String subscriptionFor = comboBox_1.getSelectedItem().toString();

                // Phone number and ID validation patterns
                String phonePattern = "^05\\d{8}$";
                String idPattern = "^\\d{9}$";

                boolean validationPass = true;

                // Validation checks
                if (memberID.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "אחד השדות לא נכתב!", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    validationPass = false;
                }

                if (!Pattern.matches(phonePattern, phoneNumber)) {
                    JOptionPane.showMessageDialog(null, "מספר הטלפון אינו תקין! יש לוודא שהוא מתחיל ב-05 ואחריו 8 ספרות.", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    validationPass = false;
                }

                if (!Pattern.matches(idPattern, memberID)) {
                    JOptionPane.showMessageDialog(null, "תעודת הזהות חייבת להכיל בדיוק 9 ספרות.", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    validationPass = false;
                }

                if (validationPass) {
                    Connection conn = Satabase.connect();
                    String insertMemberSQL = "INSERT INTO Members (MemberID, FirstName, LastName, PhoneNumber, Gender, JoinDate, `Subscription for`, `price`, `Subscription expiration`) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
                    String checkMemberSQL = "SELECT COUNT(*) FROM Members WHERE MemberID = ?";
                    String checkPhoneSQL = "SELECT COUNT(*) FROM Members WHERE PhoneNumber = ?";

                    try {
                        // Check if member ID exists
                        PreparedStatement checkMemberStmt = conn.prepareStatement(checkMemberSQL);
                        checkMemberStmt.setString(1, memberID);
                        ResultSet memberRs = checkMemberStmt.executeQuery();
                        memberRs.next();

                        if (memberRs.getInt(1) > 0) {
                            JOptionPane.showMessageDialog(null, "ה-MemberID כבר קיים במערכת!", "שגיאה", JOptionPane.ERROR_MESSAGE);
                        } else {
                            // Check if phone number exists
                            PreparedStatement checkPhoneStmt = conn.prepareStatement(checkPhoneSQL);
                            checkPhoneStmt.setString(1, phoneNumber);
                            ResultSet phoneRs = checkPhoneStmt.executeQuery();
                            phoneRs.next();

                            if (phoneRs.getInt(1) > 0) {
                                JOptionPane.showMessageDialog(null, "מספר הטלפון כבר קיים במערכת!", "שגיאה", JOptionPane.ERROR_MESSAGE);
                            } else {
                                // Insert new member
                                PreparedStatement insertStmt = conn.prepareStatement(insertMemberSQL);
                                insertStmt.setString(1, memberID);
                                insertStmt.setString(2, firstName);
                                insertStmt.setString(3, lastName);
                                insertStmt.setString(4, phoneNumber);
                                insertStmt.setString(5, gender);
                                insertStmt.setString(6, joinDate);
                                
                                // Set subscription type and price
                                String price = "0"; // Default value
                                if (subscriptionFor.equals("Month")) {
                                    price = "350";
                                } else if (subscriptionFor.equals("3 Months")) {
                                    price = "600";
                                } else if (subscriptionFor.equals("6 Months")) {
                                    price = "1300";
                                } else if (subscriptionFor.equals("year")) {
                                    price = "2200";
                                }
                                insertStmt.setString(7, subscriptionFor);
                                insertStmt.setString(8, price);

                                // Calculate expiration date
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime((java.util.Date) spinner.getValue());
                                if (subscriptionFor.equals("Month")) {
                                    calendar.add(Calendar.MONTH, 1);
                                } else if (subscriptionFor.equals("3 Months")) {
                                    calendar.add(Calendar.MONTH, 3);
                                } else if (subscriptionFor.equals("6 Months")) {
                                    calendar.add(Calendar.MONTH, 6);
                                } else if (subscriptionFor.equals("year")) {
                                    calendar.add(Calendar.YEAR, 1);
                                }
                                String expirationDate = ((JSpinner.DateEditor) spinner.getEditor()).getFormat().format(calendar.getTime());
                                insertStmt.setString(9, expirationDate); // Set expiration date

                                // Execute insert
                                int rowsInserted = insertStmt.executeUpdate();
                                if (rowsInserted > 0) {
                                    JOptionPane.showMessageDialog(null, "חבר נוסף בהצלחה!", "הצלחה", JOptionPane.INFORMATION_MESSAGE);
                                    loadMembers(); // Reload members after successful insert
                                }
                            }
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "שגיאה בעת הוספת הנתונים.", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    } finally {
                    	
                        Satabase.disconnect(); // Ensure the connection is closed
                    }
                }
            }
        });



        btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_1.setForeground(new Color(0, 102, 102));
        btnNewButton_1.setBounds(620, 18, 94, 23);
        panel_4.add(btnNewButton_1);
        btnNewButton_2 = new JButton("Update");
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Retrieve values from text fields and combo box
                String memberID = textField.getText().trim();
                String firstName = textField_1.getText().trim();
                String lastName = textField_2.getText().trim();
                String phoneNumber = textField_3.getText().trim();
                String gender = comboBox.getSelectedItem().toString();
                String joinDate = ((JSpinner.DateEditor) spinner.getEditor()).getFormat().format(spinner.getValue());
                String subscriptionFor = comboBox_1.getSelectedItem().toString();

                // Phone number and ID validation patterns
                String phonePattern = "^05\\d{8}$";
                String idPattern = "^\\d{9}$";

                boolean validationPass = true;

                // Validation checks
                if (memberID.isEmpty() || firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "אחד השדות לא נכתב!", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    validationPass = false;
                }

                if (!Pattern.matches(phonePattern, phoneNumber)) {
                    JOptionPane.showMessageDialog(null, "מספר הטלפון אינו תקין! יש לוודא שהוא מתחיל ב-05 ואחריו 8 ספרות.", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    validationPass = false;
                }

                if (!Pattern.matches(idPattern, memberID)) {
                    JOptionPane.showMessageDialog(null, "תעודת הזהות חייבת להכיל בדיוק 9 ספרות.", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    validationPass = false;
                }

                if (validationPass) {
                    Connection conn = Satabase.connect();
                    String selectMemberSQL = "SELECT MemberID, FirstName, LastName, PhoneNumber, Gender, JoinDate, `Subscription for`, `price` FROM Members WHERE MemberID = ?";
                    String checkNewIdSQL = "SELECT COUNT(*) FROM Members WHERE MemberID = ?"; // Check if the new ID already exists
                    String checkPhoneNumberSQL = "SELECT MemberID FROM Members WHERE PhoneNumber = ?"; // Get MemberID associated with the phone number
                    String updateMemberSQL = "UPDATE Members SET MemberID = ?, FirstName = ?, LastName = ?, PhoneNumber = ?, Gender = ?, JoinDate = ?, `Subscription for` = ?, `price` = ?, `Subscription expiration` = ? WHERE MemberID = ?";

                    try {
                        // Check if the existing member exists
                        PreparedStatement selectStmt = conn.prepareStatement(selectMemberSQL);
                        selectStmt.setString(1, memberID);
                        ResultSet rs = selectStmt.executeQuery();

                        if (rs.next()) {
                            // Retrieve existing values
                            String existingMemberID = rs.getString("MemberID");
                            String existingFirstName = rs.getString("FirstName");
                            String existingLastName = rs.getString("LastName");
                            String existingPhoneNumber = rs.getString("PhoneNumber");
                            String existingGender = rs.getString("Gender");
                            String existingJoinDate = rs.getString("JoinDate");
                            String existingSubscriptionFor = rs.getString("Subscription for");
                            String existingPrice = rs.getString("price");

                            // Check for changes
                            boolean isChanged = false;

                            // Check if values have changed
                            if (!firstName.equals(existingFirstName)) isChanged = true;
                            if (!lastName.equals(existingLastName)) isChanged = true;
                            if (!phoneNumber.equals(existingPhoneNumber)) isChanged = true;
                            if (!gender.equals(existingGender)) isChanged = true;
                            if (!joinDate.equals(existingJoinDate)) isChanged = true;
                            if (!subscriptionFor.equals(existingSubscriptionFor)) isChanged = true;

                            // Check if the MemberID is changing
                            if (!memberID.equals(existingMemberID)) {
                                // Check if the new MemberID already exists
                                PreparedStatement checkNewIdStmt = conn.prepareStatement(checkNewIdSQL);
                                checkNewIdStmt.setString(1, memberID);
                                ResultSet idCheckRs = checkNewIdStmt.executeQuery();
                                idCheckRs.next();

                                if (idCheckRs.getInt(1) > 0) {
                                    JOptionPane.showMessageDialog(null, "ה-MemberID כבר קיים במערכת!", "שגיאה", JOptionPane.ERROR_MESSAGE);
                                    return; // Exit if the new ID exists
                                } else {
                                    isChanged = true; // Mark as changed because ID is changing
                                }
                            }

                            // If the phone number is changing, check if it already exists for another MemberID
                            if (!phoneNumber.equals(existingPhoneNumber)) {
                                PreparedStatement checkPhoneNumberStmt = conn.prepareStatement(checkPhoneNumberSQL);
                                checkPhoneNumberStmt.setString(1, phoneNumber);
                                ResultSet phoneCheckRs = checkPhoneNumberStmt.executeQuery();

                                if (phoneCheckRs.next()) {
                                    String phoneOwnerMemberID = phoneCheckRs.getString("MemberID");
                                    // Allow change if the phone number belongs to the same member
                                    if (!phoneOwnerMemberID.equals(existingMemberID)) {
                                        JOptionPane.showMessageDialog(null, "המספר טלפון כבר קיים במערכת תחת MemberID שונה!", "שגיאה", JOptionPane.ERROR_MESSAGE);
                                        return; // Exit if the new phone number exists under a different ID
                                    } else {
                                        isChanged = true; // Mark as changed because phone number is changing but belongs to the same member
                                    }
                                } else {
                                    isChanged = true; // Mark as changed because phone number is new
                                }
                            }

                            // If something has changed, update the member
                            if (isChanged) {
                                PreparedStatement updateStmt = conn.prepareStatement(updateMemberSQL);
                                updateStmt.setString(1, memberID); // Set the new MemberID
                                updateStmt.setString(2, firstName);
                                updateStmt.setString(3, lastName);
                                updateStmt.setString(4, phoneNumber);
                                updateStmt.setString(5, gender);
                                updateStmt.setString(6, joinDate);
                                updateStmt.setString(7, subscriptionFor);

                                // Set new price based on subscription
                                String price = "0"; // Default value
                                switch (subscriptionFor) {
                                    case "Month":
                                        price = "350";
                                        break;
                                    case "3 Months":
                                        price = "600";
                                        break;
                                    case "6 Months":
                                        price = "1300";
                                        break;
                                    case "year":
                                        price = "2200";
                                        break;
                                }
                                updateStmt.setString(8, price);

                                // Calculate new expiration date
                                Calendar calendar = Calendar.getInstance();
                                calendar.setTime((java.util.Date) spinner.getValue()); // Assuming spinner holds the join date
                                switch (subscriptionFor) {
                                    case "Month":
                                        calendar.add(Calendar.MONTH, 1);
                                        break;
                                    case "3 Months":
                                        calendar.add(Calendar.MONTH, 3);
                                        break;
                                    case "6 Months":
                                        calendar.add(Calendar.MONTH, 6);
                                        break;
                                    case "Year":
                                        calendar.add(Calendar.YEAR, 1);
                                        break;
                                }
                                String newExpirationDate = ((JSpinner.DateEditor) spinner.getEditor()).getFormat().format(calendar.getTime());
                                updateStmt.setString(9, newExpirationDate); // Set new expiration date
                                updateStmt.setString(10, existingMemberID); // Use existing MemberID for the WHERE clause

                                int rowsUpdated = updateStmt.executeUpdate();
                                if (rowsUpdated > 0) {
                                    JOptionPane.showMessageDialog(null, "הפרטים עודכנו בהצלחה!", "הצלחה", JOptionPane.INFORMATION_MESSAGE);
                                    loadMembers(); // Reload members after successful update
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "לא חל שינוי בנתונים.", "הודעה", JOptionPane.INFORMATION_MESSAGE);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "ה-MemberID לא קיים במערכת!", "שגיאה", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        JOptionPane.showMessageDialog(null, "שגיאה בעת עדכון הנתונים.", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    } finally {
                        Satabase.disconnect();
                    }
                }
            }
        });

        btnNewButton_2.setForeground(new Color(0, 102, 102));
        btnNewButton_2.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_2.setBounds(620, 54, 94, 23);
        panel_4.add(btnNewButton_2);
        
        btnNewButton_3 = new JButton("Clear");
        btnNewButton_3.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		textField.setText(null);
        		textField_1.setText(null);
        		textField_2.setText(null);
        		textField_3.setText(null);

        		
        		
        	}
        });
        btnNewButton_3.setForeground(new Color(0, 102, 102));
        btnNewButton_3.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_3.setBounds(620, 131, 94, 23);
        panel_4.add(btnNewButton_3);
        
        textField = new JTextField();
        textField.setBackground(Color.WHITE);
        textField.setSelectedTextColor(SystemColor.text);
        textField.setForeground(Color.BLACK);
        textField.setFont(new Font("Tahoma", Font.PLAIN, 11));
        textField.setColumns(10);
        textField.setBorder(null);
        textField.setBounds(142, 22, 94, 14);
        panel_4.add(textField);
        textField.setBorder(null);
        
        textField_1 = new JTextField();
        textField_1.setBackground(Color.WHITE);
        textField_1.setForeground(Color.BLACK);
        textField_1.setFont(new Font("Tahoma", Font.PLAIN, 11));
        textField_1.setColumns(10);
        textField_1.setBorder(null);
        textField_1.setBounds(144, 52, 94, 14);
        panel_4.add(textField_1);
        
        JSeparator separator_1_1 = new JSeparator();
        separator_1_1.setForeground(new Color(95, 158, 160));
        separator_1_1.setBackground(new Color(51, 204, 153));
        separator_1_1.setBounds(142, 75, 94, 2);
        panel_4.add(separator_1_1);
        
        separator_1 = new JSeparator();
        separator_1.setForeground(new Color(95, 158, 160));
        separator_1.setBackground(new Color(51, 204, 153));
        separator_1.setBounds(142, 39, 94, 2);
        panel_4.add(separator_1);
        
        separator_2 = new JSeparator();
        separator_2.setForeground(new Color(95, 158, 160));
        separator_2.setBackground(new Color(51, 204, 153));
        separator_2.setBounds(144, 123, 94, 2);
        panel_4.add(separator_2);
        
        separator_3 = new JSeparator();
        separator_3.setForeground(new Color(95, 158, 160));
        separator_3.setBackground(new Color(51, 204, 153));
        separator_3.setBounds(176, 169, 94, 2);
        panel_4.add(separator_3);
        
        lblNewLabel_9 = new JLabel("Subscription for :");
        lblNewLabel_9.setForeground(new Color(95, 158, 160));
        lblNewLabel_9.setFont(new Font("Segoe UI", Font.BOLD, 16));
        lblNewLabel_9.setBounds(308, 107, 135, 30);
        panel_4.add(lblNewLabel_9);
        
        String[] optionss = {"Month", "3 Months","6 Months","year"};
        comboBox_1 = new JComboBox<String>(optionss);
        comboBox_1.setBounds(448, 115, 82, 22);
        panel_4.add(comboBox_1);
        
        btnNewButton_4 = new JButton("Delete");
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String memberIDToDelete = textField.getText().trim();

                if (memberIDToDelete.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "אנא הכנס תעודת זהות למחיקה!", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                int confirm = JOptionPane.showConfirmDialog(null, "האם אתה בטוח שאתה רוצה למחוק את החבר?", "אישור מחיקה", JOptionPane.YES_NO_OPTION);
                if (confirm != JOptionPane.YES_OPTION) {
                    return; // User chose not to delete
                }

                Connection conn = Satabase.connect();
                String deleteMemberSQL = "DELETE FROM Members WHERE MemberID = ?";
                
                try {
                    PreparedStatement deleteStmt = conn.prepareStatement(deleteMemberSQL);
                    deleteStmt.setString(1, memberIDToDelete);

                    int rowsDeleted = deleteStmt.executeUpdate();
                    if (rowsDeleted > 0) {
                        JOptionPane.showMessageDialog(null, "החבר נמחק בהצלחה!", "הצלחה", JOptionPane.INFORMATION_MESSAGE);
                        loadMembers(); // Reload members after successful deletion

                        // Reset the input fields
                        textField.setText("");
                        textField_1.setText("");
                        textField_2.setText("");
                        textField_3.setText("");
                        comboBox.setSelectedIndex(0); // Assuming this resets to the first item
                        comboBox_1.setSelectedIndex(0); // Reset the subscription type combo box
                        spinner.setValue(new java.util.Date()); // Reset the date spinner to current date
                    } else {
                        JOptionPane.showMessageDialog(null, "לא נמצא חבר עם תעודת הזהות הזו!", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "שגיאה בעת מחיקת הנתונים.", "שגיאה", JOptionPane.ERROR_MESSAGE);
                } finally {
                    Satabase.disconnect(); // Ensure the connection is closed
                }
            }
        });
        btnNewButton_4.setForeground(new Color(0, 102, 102));
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 11));
        btnNewButton_4.setBounds(620, 94, 94, 23);
        panel_4.add(btnNewButton_4);

      
     
        
        panel_2 = new JPanel();
        panel_2.setBackground(Color.WHITE);
        panel_2.setBounds(0, 11, 714, 161);
        panel_3.add(panel_2);
        panel_2.setLayout(null);

        table_1 = new JTable(new DefaultTableModel(
        	new Object[][] {
        	},
        	new String[] {
        		"MemberId", "First Name", "Last Name", "Phone Num", "Gender", "Subscription", "price", "Date Member", "last day"
        	}
        ));
       
        JScrollPane scrollPane = new JScrollPane(table_1);
        scrollPane.setBackground(Color.GRAY);
        scrollPane.setDoubleBuffered(true);
        scrollPane.setBounds(0, 42, 719, 120);
        panel_2.add(scrollPane);
        
        txtSearch = new JTextField();
        txtSearch.setBackground(Color.WHITE);
        txtSearch.setBorder(null);
        txtSearch.setBounds(120, 11, 102, 20);
        panel_2.add(txtSearch);
        txtSearch.setFont(new Font("Tahoma", Font.BOLD, 11));
        txtSearch.setColumns(10);
     //
        JLabel lblNewLabel_8 = new JLabel("Search Member :");
        lblNewLabel_8.setForeground(new Color(46, 139, 87));
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_8.setBounds(10, 17, 106, 14);
        panel_2.add(lblNewLabel_8);
        
        separator_4 = new JSeparator();
        separator_4.setForeground(new Color(95, 158, 160));
        separator_4.setBackground(new Color(51, 204, 153));
        separator_4.setBounds(120, 31, 102, 2);
        panel_2.add(separator_4);
     // Add a mouse listener to the table
        table_1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                int row = table_1.getSelectedRow(); // Get the selected row index
                if (row != -1) { // Check if a row is selected
                    // Populate text fields with the data from the selected row
                    textField.setText(model.getValueAt(row, 0).toString()); // Member ID
                    textField_1.setText(model.getValueAt(row, 1).toString()); // First Name
                    textField_2.setText(model.getValueAt(row, 2).toString()); // Last Name
                    textField_3.setText(model.getValueAt(row, 3).toString()); // Phone Number
                    comboBox.setSelectedItem(model.getValueAt(row, 4).toString()); // Gender
                    comboBox_1.setSelectedItem(model.getValueAt(row, 5).toString()); // Gender

                    
                    spinner.setValue(java.sql.Date.valueOf(model.getValueAt(row, 7).toString())); // Date Joined
                    
                }
            }
        });

        
        txtSearch.getDocument().addDocumentListener(new DocumentListener() {
        	private void filterTable() {
        	    String filter = txtSearch.getText().toLowerCase().trim(); // קבלת הטקסט שהוזן
        	    model.setRowCount(0); // ניקוי שורות קיימות

        	    try (Connection conn = Satabase.connect()) {
        	        // עדכון השאילתה כדי לכלול את כל העמודות הדרושות עם מיון
        	        String selectSQL = "SELECT MemberID, FirstName, LastName, PhoneNumber, Gender, JoinDate, `price`, `Subscription for`, `Subscription expiration` FROM Members "
        	                         + "WHERE `Subscription expiration` >= CURRENT_DATE"; // סינון לפי תאריך הפסקה

        	        if (!filter.isEmpty()) {
        	            selectSQL += " AND (LOWER(MemberID) LIKE ? OR LOWER(FirstName) LIKE ? OR LOWER(LastName) LIKE ? OR LOWER(PhoneNumber) LIKE ? OR LOWER(Gender) LIKE ? OR `price` LIKE ? OR LOWER(JoinDate) LIKE ? OR LOWER(`Subscription for`) LIKE ? OR LOWER(`Subscription expiration`) LIKE ?)"; 
        	        }

        	        selectSQL += " ORDER BY `Subscription expiration`"; // הוספת מיון לפי Subscription expiration

        	        PreparedStatement stmt = conn.prepareStatement(selectSQL);
        	        if (!filter.isEmpty()) {
        	            String searchFilter = "%" + filter + "%"; // הוספת תו wildcards לחיפוש
        	            int index = 1; // משתנה לאינדקס של הפרמטרים
        	            stmt.setString(index++, searchFilter);
        	            stmt.setString(index++, searchFilter);
        	            stmt.setString(index++, searchFilter);
        	            stmt.setString(index++, searchFilter);
        	            stmt.setString(index++, searchFilter);
        	            stmt.setString(index++, searchFilter);
        	            stmt.setString(index++, searchFilter); // הוספת סינון לפי JoinDate
        	            stmt.setString(index++, searchFilter); // הוספת סינון לפי Subscription for
        	            stmt.setString(index++, searchFilter); // הוספת סינון לפי Subscription expiration
        	        }

        	        ResultSet rs = stmt.executeQuery();

        	        while (rs.next()) {
        	            String memberID = rs.getString("MemberID");
        	            String firstName = rs.getString("FirstName");
        	            String lastName = rs.getString("LastName");
        	            String phoneNumber = rs.getString("PhoneNumber");
        	            String gender = rs.getString("Gender");
        	            String joinDate = rs.getString("JoinDate");
        	            String price = rs.getString("price"); // קבלת מחיר
        	            String subscriptionFor = rs.getString("Subscription for"); // קבלת סוג המנוי
        	            String subscriptionExpiration = rs.getString("Subscription expiration"); // קבלת תאריך הפסקת המנוי

        	            // הוספת השורות למודל
        	            model.addRow(new Object[] {memberID, firstName, lastName, phoneNumber, gender, subscriptionFor, price, joinDate, subscriptionExpiration}); // לכלול את כל העמודות הרלוונטיות
        	        }
        	    } catch (SQLException e) {
        	        e.printStackTrace();
        	        JOptionPane.showMessageDialog(null, "שגיאה בעת טעינת חברים.", "שגיאה", JOptionPane.ERROR_MESSAGE);
        	    }
        	}

        	@Override
        	public void insertUpdate(DocumentEvent e) {
        	    filterTable();
        	}

        	@Override
        	public void removeUpdate(DocumentEvent e) {
        	    filterTable();
        	}

        	@Override
        	public void changedUpdate(DocumentEvent e) {
        	    filterTable();
        	}

        });

        model = (DefaultTableModel) table_1.getModel();
        
        // Load members when the frame is initialized
        loadMembers();
    }

    private void loadMembers() {
        model.setRowCount(0); // Clear existing rows
        Connection conn = Satabase.connect();

        // Get the current date
        LocalDate today = LocalDate.now();
        String selectSQL = "SELECT MemberID, FirstName, LastName, PhoneNumber, Gender, JoinDate, `Subscription for`, `price`, `Subscription expiration` FROM Members WHERE `Subscription expiration` >= ? ORDER BY `Subscription expiration`";

        try {
            PreparedStatement stmt = conn.prepareStatement(selectSQL);
            // Set the date parameter
            stmt.setDate(1, java.sql.Date.valueOf(today)); 
            ResultSet rs = stmt.executeQuery();

            while (rs.next()) {
                String memberID = rs.getString("MemberID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String phoneNumber = rs.getString("PhoneNumber");
                String gender = rs.getString("Gender");
                String joinDate = rs.getString("JoinDate");
                String subscription = rs.getString("Subscription for");
                String price = rs.getString("price");
                String subscriptionExpiration = rs.getString("Subscription expiration");

                // Add all retrieved values to the model
                model.addRow(new Object[] {memberID, firstName, lastName, phoneNumber, gender, subscription, price, joinDate, subscriptionExpiration});
            }
        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "שגיאה בעת טעינת חברים.", "שגיאה", JOptionPane.ERROR_MESSAGE);
        } finally {
            Satabase.disconnect();
        }
    }
    
}
