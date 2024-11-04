import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import hello.Satabase;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HomePageSystem extends JFrame {
    private JPanel leftPanel, rightPanel;
    private JPanel panel_1;
    private JTable table;
    private DefaultTableModel tableModel;
    private JTextField textField;
    private JTextField text_price;
    JCheckBox All_Members = new JCheckBox("");
    JCheckBox all = new JCheckBox("");
    JCheckBox male = new JCheckBox("");
    JCheckBox female = new JCheckBox("");
    JCheckBox Former_members = new JCheckBox("");
    JCheckBox Active_members = new JCheckBox("");
    JCheckBox specific_period = new JCheckBox("");
 // Ensure your spinners are using a SpinnerDateModel
    JSpinner fromSpinner = new JSpinner(new SpinnerDateModel());
    JSpinner untilSpinner = new JSpinner(new SpinnerDateModel());

    
    JCheckBox All_22 = new JCheckBox("");
    JCheckBox Month_22 = new JCheckBox("");
    JCheckBox m3_Months22 = new JCheckBox("");
    JCheckBox m6_Months22 = new JCheckBox("");
    JCheckBox Year22 = new JCheckBox("");
    Date fromDate ;
	Date toDate ;
	JButton btnNewButton_1 = new JButton("Search");
	boolean flag=false;
	private JTextField textField_1;
	  private void dateChanged() {
          // Call your filter function here
          filterMembers1(); // Assuming this is the function you want to call
      }
      
    public HomePageSystem() {
        // Set up the frame
        setTitle("Gym Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(969, 658);  // Same size as Login class
        setLocationRelativeTo(null);  // Center the frame

        // Create the left-side panel
        leftPanel = new JPanel();
        leftPanel.setBackground(Color.WHITE);
        leftPanel.setLayout(new BorderLayout());

        // Create the right-side panel
        rightPanel = new JPanel();
        rightPanel.setBackground(new Color(95, 158, 160));

        // Add both panels to the frame
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(leftPanel, BorderLayout.WEST);  // Add left panel
        getContentPane().add(rightPanel, BorderLayout.CENTER);  // Add right panel
        rightPanel.setLayout(null);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(0, 456, 957, 2);
        rightPanel.add(separator_1);
        separator_1.setForeground(new Color(95, 158, 160));
        separator_1.setBackground(SystemColor.WHITE);
        
        JPanel panel = new JPanel();
        panel.setForeground(new Color(255, 255, 255));
        panel.setBackground(new Color(0, 102, 102));
        panel.setBounds(0, 0, 167, 395);
        rightPanel.add(panel);
        panel.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("Welcome Admin");
        lblNewLabel.setForeground(new Color(245, 255, 250));
        lblNewLabel.setFont(new Font("Segoe UI Emoji", Font.BOLD, 19));
        lblNewLabel.setBounds(10, 72, 157, 42);
        panel.add(lblNewLabel);
        
        JLabel lblNewLabel_1 = new JLabel("");
        lblNewLabel_1.setForeground(new Color(128, 0, 0));
        lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-admin-80.png"));
        lblNewLabel_1.setBounds(46, 0, 87, 85);
        panel.add(lblNewLabel_1);
        
        JSeparator separator = new JSeparator();
        separator.setBounds(0, 112, 166, 2);
        panel.add(separator);
        
        JButton btnNewButton = new JButton("Add Member");
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                AddMember m = new AddMember();
                setVisible(false);
                m.setVisible(true);
            }
        });
        btnNewButton.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-add-member-30.png"));
        btnNewButton.setFont(new Font("Segoe UI Black", Font.BOLD, 17));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBorder(null);
        btnNewButton.setBackground(new Color(0, 102, 102));
        btnNewButton.setBounds(0, 182, 166, 48);
        panel.add(btnNewButton);
        
        JButton btnHome = new JButton("Home");
        btnHome.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-home-35.png"));
        btnHome.setForeground(Color.WHITE);
        btnHome.setFont(new Font("Segoe UI Black", Font.BOLD, 17));
        btnHome.setBorder(null);
        btnHome.setBackground(new Color(0, 102, 102));
        btnHome.setBounds(0, 115, 166, 48);
        panel.add(btnHome);
        
        panel_1 = new JPanel();
        panel_1.setBounds(0, 0, 156, 112);
        rightPanel.add(panel_1);
        panel_1.setLayout(new BorderLayout(0, 0));
        
        JPanel panel_2 = new JPanel();
        panel_2.setForeground(new Color(0, 128, 128));
        panel_2.setBounds(166, 11, 716, 384);
        rightPanel.add(panel_2);
        panel_2.setBackground(new Color(0, 102, 102));
        panel_2.setLayout(null);
        
        // Create the table with a DefaultTableModel
        tableModel = new DefaultTableModel(
            new Object[][] {},
            new String[] {
                "Member ID", "First Name", "Last Name", "Phone Num", "Gender", "Subscription", "Price", "Date Joined", "last day"
            }
        );
        table = new JTable(tableModel);
        
        // Add the table to a scroll pane
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(0, 94, 716, 290); // Adjust height to fit the layout
        panel_2.add(scrollPane);
        
        JPanel panel_3 = new JPanel();
        panel_3.setBounds(0, 0, 716, 57);
        panel_2.add(panel_3);
        panel_3.setLayout(null);
        
        JLabel lblNewLabel_2 = new JLabel("Membership Details and Analytics");
        lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\imaxp\\Downloads\\icons8-control-50.png"));
        lblNewLabel_2.setFont(new Font("Tahoma", Font.ITALIC, 27));
        lblNewLabel_2.setBounds(85, 0, 621, 57);
        panel_3.add(lblNewLabel_2);
        
        JLabel lblNewLabel_8 = new JLabel("Search Member :");
        lblNewLabel_8.setForeground(new Color(240, 248, 255));
        lblNewLabel_8.setFont(new Font("Tahoma", Font.BOLD, 11));
        lblNewLabel_8.setBounds(10, 68, 106, 14);
        panel_2.add(lblNewLabel_8);
        textField = new JTextField();
        textField.setFont(new Font("Tahoma", Font.BOLD, 11));
        textField.setColumns(10);
        textField.setBorder(null);
        textField.setBackground(new Color(0, 128, 128));
        textField.setBounds(110, 63, 102, 20);
        panel_2.add(textField);

        // הוספת מאזין לאירועים לשדה הטקסט
        textField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String searchTerm = textField.getText().trim(); // Get input from the text field
                searchMembers(searchTerm); // Call the new search function
            }
        });


        JSeparator separator_4 = new JSeparator();
        separator_4.setForeground(new Color(95, 158, 160));
        separator_4.setBackground(new Color(51, 204, 153));
        separator_4.setBounds(110, 81, 102, 2);
        panel_2.add(separator_4);
        
        JLabel lblNewLabel_2_1 = new JLabel("Data Filtering: Member Details");
        lblNewLabel_2_1.setFont(new Font("Tahoma", Font.ITALIC, 27));
        lblNewLabel_2_1.setBounds(257, 394, 459, 64);
        rightPanel.add(lblNewLabel_2_1);
        
        JPanel panel_4 = new JPanel();
        panel_4.setBackground(new Color(95, 158, 160));
        panel_4.setBounds(0, 461, 957, 162);
        rightPanel.add(panel_4);
        panel_4.setLayout(null);
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        textField_1.setBounds(875, 63, 36, 20);
        panel_4.add(textField_1);
        
        
        text_price = new JTextField();
        text_price.setBounds(809, 20, 65, 20);
        panel_4.add(text_price);
        text_price.setColumns(10);
        
        JLabel lblNewLabel_3_2_1_1_1 = new JLabel("Number Of Members:");
        lblNewLabel_3_2_1_1_1.setToolTipText(" ");
        lblNewLabel_3_2_1_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
        lblNewLabel_3_2_1_1_1.setBounds(701, 54, 178, 32);
        panel_4.add(lblNewLabel_3_2_1_1_1);
        
        JLabel Year = new JLabel("Year");
        Year.setFont(new Font("Tahoma", Font.ITALIC, 13));
        Year.setBounds(620, 66, 36, 32);
        panel_4.add(Year);
        
        
        Year22.setSelected(false);
        Year22.setEnabled(true);
        Year22.setBounds(659, 73, 23, 23);
        panel_4.add(Year22);
        
        JLabel m6_Months = new JLabel("6 Months");
        m6_Months.setFont(new Font("Tahoma", Font.ITALIC, 13));
        m6_Months.setBounds(595, 40, 58, 32);
        panel_4.add(m6_Months);
        
      
        m6_Months22.setSelected(false);
        m6_Months22.setEnabled(true);
        m6_Months22.setBounds(659, 40, 23, 23);
        panel_4.add(m6_Months22);
        
        JLabel m3_Months = new JLabel("3 Months");
        m3_Months.setFont(new Font("Tahoma", Font.ITALIC, 13));
        m3_Months.setBounds(483, 102, 58, 32);
        panel_4.add(m3_Months);
        
      
        m3_Months22.setSelected(false);
        m3_Months22.setEnabled(true);
        m3_Months22.setBounds(540, 109, 23, 23);
        panel_4.add(m3_Months22);
        
        JLabel Month = new JLabel("Month");
        Month.setFont(new Font("Tahoma", Font.ITALIC, 13));
        Month.setBounds(496, 66, 46, 32);
        panel_4.add(Month);
        
       
        Month_22.setSelected(false);
        Month_22.setEnabled(true);
        Month_22.setBounds(540, 73, 23, 23);
        panel_4.add(Month_22);
        
        JLabel All_2 = new JLabel("All");
        All_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
        All_2.setBounds(514, 34, 36, 32);
        panel_4.add(All_2);
        
       
        All_22.setSelected(false);
        All_22.setEnabled(true);
        All_22.setBounds(540, 40, 23, 23);
        panel_4.add(All_22);
        
        if(!(male.isSelected())&&!(all.isSelected())&&!(female.isSelected()))
        {
        	All_22.setEnabled(false);
        	 Month_22.setEnabled(false);
             m3_Months22.setEnabled(false);
             m6_Months22.setEnabled(false);
             Year22.setEnabled(false);
        }
        
        All_22.addActionListener(e -> {
            if (All_22.isSelected()) {
          

                Month_22.setSelected(false);
                m3_Months22.setSelected(false);
                m6_Months22.setSelected(false);
                Year22.setSelected(false);
                Month_22.setEnabled(false);
                m3_Months22.setEnabled(false);
                m6_Months22.setEnabled(false);
                Year22.setEnabled(false);
              	filterMembers1() ;
            } else {

                Month_22.setEnabled(true);
                m3_Months22.setEnabled(true);
                Year22.setEnabled(true);
                m6_Months22.setEnabled(true);
                Month_22.setSelected(false);
                m3_Months22.setSelected(false);
                m6_Months22.setSelected(false);
                Year22.setSelected(false);
              	filterMembers1() ;
            }
        });

        // Add action listeners for the other buttons
        ActionListener buttonListener = e -> {
        	filterMembers1() ;

            // Check if All_22 should be selected based on other buttons
            if (Month_22.isSelected() && m3_Months22.isSelected() && m6_Months22.isSelected() && Year22.isSelected()) {
            	

                All_22.setSelected(true);
                All_22.setEnabled(true);
            } else {
                All_22.setSelected(false);
                All_22.setEnabled(true);
            }

            // Enable or disable the buttons based on the selections
            Month_22.setEnabled(!All_22.isSelected());
            m3_Months22.setEnabled(!All_22.isSelected());
            m6_Months22.setEnabled(!All_22.isSelected());
            Year22.setEnabled(!All_22.isSelected());
        };

        // Add the listener to all relevant buttons
        Month_22.addActionListener(buttonListener);
        m3_Months22.addActionListener(buttonListener);
        m6_Months22.addActionListener(buttonListener);
        Year22.addActionListener(buttonListener);

        
        
        
        
        JLabel lblNewLabel_3_2_1 = new JLabel("Subscription Period");
        lblNewLabel_3_2_1.setToolTipText(" ");
        lblNewLabel_3_2_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
        lblNewLabel_3_2_1.setBounds(483, 0, 160, 32);
        panel_4.add(lblNewLabel_3_2_1);
        
       
        
        
        specific_period.setSelected(false);
        specific_period.setEnabled(true);
        specific_period.setBounds(285, 40, 23, 23);
        panel_4.add(specific_period);
              JLabel lblUntil = new JLabel("Until:");
        JLabel lblFrom = new JLabel("From:");

        
        
        specific_period.addActionListener(e -> {
            if (specific_period.isSelected()) {
                // יצירת והוספת תוויות וספינרים
                lblFrom.setFont(new Font("Tahoma", Font.ITALIC, 18));
                lblFrom.setBounds(159, 64, 58, 32);
                panel_4.add(lblFrom);

                lblUntil.setFont(new Font("Tahoma", Font.ITALIC, 18));
                lblUntil.setBounds(159, 100, 46, 32);
                panel_4.add(lblUntil);

                JSpinner.DateEditor fromEditor = new JSpinner.DateEditor(fromSpinner, "yyyy-MM-dd");
                fromSpinner.setEditor(fromEditor);
                fromSpinner.setBounds(211, 73, 97, 20);
                panel_4.add(fromSpinner);

                JSpinner.DateEditor untilEditor = new JSpinner.DateEditor(untilSpinner, "yyyy-MM-dd");
                untilSpinner.setEditor(untilEditor);
                untilSpinner.setBounds(211, 109, 97, 20);
                panel_4.add(untilSpinner);

                btnNewButton_1.setBounds(211, 139, 97, 23);
                panel_4.add(btnNewButton_1);

                // מאזין לאירוע כפתור
                btnNewButton_1.addActionListener(e3 -> filterMembers1());

                // רענון הפנל
                panel_4.revalidate();
                panel_4.repaint();
            } else {
                // הסרת תוויות וספינרים כשאין צורך
                panel_4.remove(lblFrom);
                panel_4.remove(lblUntil);
                panel_4.remove(fromSpinner);
                panel_4.remove(untilSpinner);
                panel_4.remove(btnNewButton_1);
                // רענון הפנל
                panel_4.revalidate();
                panel_4.repaint();
                filterMembers1() ;

            }
        });

      
        JLabel lblNewLabel_3_1_2_1_2 = new JLabel("specific period");
        lblNewLabel_3_1_2_1_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
        lblNewLabel_3_1_2_1_2.setBounds(181, 34, 97, 32);
        panel_4.add(lblNewLabel_3_1_2_1_2);
        
       
        Former_members.setSelected(false);
        Former_members.setEnabled(true);
        Former_members.setBounds(120, 122, 23, 23);
        panel_4.add(Former_members);
        
        
        Active_members.setSelected(false);
        Active_members.setEnabled(true);
        Active_members.setBounds(120, 86, 23, 23);
        panel_4.add(Active_members);
        
        
        All_Members.setSelected(false);
        All_Members.setEnabled(true);
        All_Members.setBounds(120, 40, 23, 23);
        panel_4.add(All_Members);
        
        All_Members.addActionListener(e -> {
        	
        
            if (All_Members.isSelected()) {
          
            	male.setEnabled(true);
            	female.setEnabled(true);
            	all.setEnabled(true);
            	
                Active_members.setEnabled(false);
                Former_members.setEnabled(false);
                Active_members.setSelected(false);
                Former_members.setSelected(false);
            	filterMembers1() ;
            } else {
            	male.setEnabled(false);
            	female.setEnabled(false);
            	all.setEnabled(false);
            	male.setSelected(false);
            	female.setSelected(false);
            	all.setSelected(false);
            	Active_members.setEnabled(true);
            	Former_members.setEnabled(true);
                Active_members.setSelected(false);
                Former_members.setSelected(false);
                All_22.setEnabled(false);
             	 Month_22.setEnabled(false);
                  m3_Months22.setEnabled(false);
                  m6_Months22.setEnabled(false);
                  Year22.setEnabled(false);
                  All_22.setSelected(false);
               	 Month_22.setSelected(false);
                    m3_Months22.setSelected(false);
                    m6_Months22.setSelected(false);
                    Year22.setSelected(false);
                    text_price.setText("0.0");
                    textField_1.setText("0");

                flag=true;
                filterMembers1() ;
            }
        });
       
            Active_members.addActionListener(e5 -> {
            	filterMembers1() ;
                if (Active_members.isSelected()) {
                	male.setEnabled(true);
                	female.setEnabled(true);
                	all.setEnabled(true);
                	Former_members.setSelected(false);
                	Former_members.setEnabled(false);
                	All_Members.setSelected(false);
                	All_Members.setEnabled(true);
                } else {
                	male.setSelected(false);
                	female.setSelected(false);
                	all.setSelected(false);
                	male.setEnabled(false);
                	female.setEnabled(false);
                	all.setEnabled(false);
                	Former_members.setEnabled(true);
                    All_Members.setEnabled(true);
                    All_22.setEnabled(false);
                 	 Month_22.setEnabled(false);
                      m3_Months22.setEnabled(false);
                      m6_Months22.setEnabled(false);
                      Year22.setEnabled(false);
                      All_22.setSelected(false);
                   	 Month_22.setSelected(false);
                        m3_Months22.setSelected(false);
                        m6_Months22.setSelected(false);
                        Year22.setSelected(false);
                        text_price.setText("0.0");
                        textField_1.setText("0");

                    flag=true;
                    filterMembers1() ;
                }
            });
            Former_members.addActionListener(e5 -> {
            	filterMembers1() ;
                if (Former_members.isSelected()) {
                	male.setEnabled(true);
                	female.setEnabled(true);
                	all.setEnabled(true);
                	Active_members.setSelected(false);
                	Active_members.setEnabled(false);
                	All_Members.setSelected(false);
                	All_Members.setEnabled(true);
                } else {
                	male.setSelected(false);
                	female.setSelected(false);
                	all.setSelected(false);
                	male.setEnabled(false);
                	female.setEnabled(false);
                	all.setEnabled(false);
                	Active_members.setEnabled(true);
                    All_Members.setEnabled(true);
                    All_22.setEnabled(false);
                 	 Month_22.setEnabled(false);
                      m3_Months22.setEnabled(false);
                      m6_Months22.setEnabled(false);
                      Year22.setEnabled(false);
                      All_22.setSelected(false);
                   	 Month_22.setSelected(false);
                        m3_Months22.setSelected(false);
                        m6_Months22.setSelected(false);
                        Year22.setSelected(false);
                        text_price.setText("0.0");
                        textField_1.setText("0");

                    flag=true;

                    filterMembers1() ;
                }
            });
            
            JLabel lblNewLabel_3_2_1_1 = new JLabel("Total Price :");
            lblNewLabel_3_2_1_1.setToolTipText(" ");
            lblNewLabel_3_2_1_1.setFont(new Font("Tahoma", Font.ITALIC, 18));
            lblNewLabel_3_2_1_1.setBounds(701, 11, 98, 32);
            panel_4.add(lblNewLabel_3_2_1_1);
            
            JPanel panel_5 = new JPanel();
            panel_5.setBounds(166, 0, 716, 10);
            rightPanel.add(panel_5);
            panel_5.setBackground(new Color(0,102,102));                
            
        JLabel lblNewLabel_3_1_3_1 = new JLabel("Former members");
        lblNewLabel_3_1_3_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
        lblNewLabel_3_1_3_1.setBounds(3, 122, 111, 32);
        panel_4.add(lblNewLabel_3_1_3_1);
        
        JLabel s = new JLabel("Active members");
        s.setFont(new Font("Tahoma", Font.ITALIC, 13));
        s.setBounds(17, 77, 97, 32);
        panel_4.add(s);
        
        JLabel lblNewLabel_3_1_2_1 = new JLabel("All Members");
        lblNewLabel_3_1_2_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
        lblNewLabel_3_1_2_1.setBounds(27, 34, 75, 32);
        panel_4.add(lblNewLabel_3_1_2_1);
        
        JLabel lblNewLabel_3 = new JLabel("Gender ");
        lblNewLabel_3.setFont(new Font("Tahoma", Font.ITALIC, 18));
        lblNewLabel_3.setBounds(375, 0, 64, 32);
        panel_4.add(lblNewLabel_3);
        
        JLabel lblNewLabel_3_1 = new JLabel("male");
        lblNewLabel_3_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
        lblNewLabel_3_1.setBounds(372, 73, 36, 32);
        panel_4.add(lblNewLabel_3_1);
        
       
        male.setBounds(416, 86, 23, 23);
        panel_4.add(male);
     
        
       
        female.setBounds(416, 122, 23, 23);
        
        panel_4.add(female);
      
        
        JLabel lblNewLabel_3_1_1 = new JLabel("female");
        lblNewLabel_3_1_1.setFont(new Font("Tahoma", Font.ITALIC, 13));
        lblNewLabel_3_1_1.setBounds(359, 113, 46, 32);
        panel_4.add(lblNewLabel_3_1_1);
        
        JLabel lblNewLabel_3_2 = new JLabel("Date Member ");
        lblNewLabel_3_2.setToolTipText(" ");
        lblNewLabel_3_2.setFont(new Font("Tahoma", Font.ITALIC, 18));
        lblNewLabel_3_2.setBounds(91, 0, 127, 32);
        panel_4.add(lblNewLabel_3_2);
      
        
        JLabel lblNewLabel_3_1_2 = new JLabel("All");
        lblNewLabel_3_1_2.setFont(new Font("Tahoma", Font.ITALIC, 13));
        lblNewLabel_3_1_2.setBounds(385, 40, 23, 32);
        panel_4.add(lblNewLabel_3_1_2);
        
        
        all.setBounds(414, 49, 23, 23);
        panel_4.add(all);
        if(!(All_Members.isSelected())&&!(Active_members.isSelected())&&!(Former_members.isSelected()))
        {
        	female.setEnabled(false);
        	all.setEnabled(false);
        	male.setEnabled(false);
        }
       
        
        male.addActionListener(e -> {
        	
            if (male.isSelected()) {
            	  All_22.setEnabled(true);
                	 Month_22.setEnabled(true);
                     m3_Months22.setEnabled(true);
                     m6_Months22.setEnabled(true);
                     Year22.setEnabled(true);
                female.setSelected(false);
                female.setEnabled(false);
                all.setSelected(false);
                all.setEnabled(true);
                filterMembers1() ;
            } else {
            	  All_22.setEnabled(false);
             	 Month_22.setEnabled(false);
                  m3_Months22.setEnabled(false);
                  m6_Months22.setEnabled(false);
                  Year22.setEnabled(false);
                  All_22.setSelected(false);
              	 Month_22.setSelected(false);
                   m3_Months22.setSelected(false);
                   m6_Months22.setSelected(false);
                   Year22.setSelected(false);
                female.setEnabled(true);
                all.setEnabled(true);
                filterMembers1() ;
            }
        });

        // Action Listener for Female Checkbox
        female.addActionListener(e -> {
        	
            if (female.isSelected()) {
                male.setSelected(false);
                male.setEnabled(false);
                all.setSelected(false);
                all.setEnabled(true);
                All_22.setEnabled(true);
           	 Month_22.setEnabled(true);
                m3_Months22.setEnabled(true);
                m6_Months22.setEnabled(true);
                Year22.setEnabled(true);
                filterMembers1() ;
            } else {
            	  All_22.setEnabled(false);
              	 Month_22.setEnabled(false);
                   m3_Months22.setEnabled(false);
                   m6_Months22.setEnabled(false);
                   Year22.setEnabled(false);
                   All_22.setSelected(false);
                	 Month_22.setSelected(false);
                     m3_Months22.setSelected(false);
                     m6_Months22.setSelected(false);
                     Year22.setSelected(false);
                male.setEnabled(true);
                all.setEnabled(true);
                filterMembers1() ;
            }
        });

        // Action Listener for All Checkbox
        all.addActionListener(e -> {
        	
            if (all.isSelected()) {
            	  All_22.setEnabled(true);
                	 Month_22.setEnabled(true);
                     m3_Months22.setEnabled(true);
                     m6_Months22.setEnabled(true);
                     Year22.setEnabled(true);
                male.setEnabled(false);
                female.setEnabled(false);
                male.setSelected(false);
                female.setSelected(false);
                filterMembers1() ;
            } else {
            	  All_22.setEnabled(false);
              	 Month_22.setEnabled(false);
                   m3_Months22.setEnabled(false);
                   m6_Months22.setEnabled(false);
                   Year22.setEnabled(false);
                male.setEnabled(true);
                female.setEnabled(true);
                male.setSelected(false);
                female.setSelected(false);
                All_22.setSelected(false);
             	 Month_22.setSelected(false);
                  m3_Months22.setSelected(false);
                  m6_Months22.setSelected(false);
                  Year22.setSelected(false);
                 
                filterMembers1() ;
                
             
              
            }
        });
        // Load all members when the frame is initialized
       
    }
    private void filterMembers1() {
        // If the flag is enabled, clear the table and return
        if (flag) {
            tableModel.setRowCount(0);
            flag = false;
            return;
        }

        // ניקוי השורות הקיימות בטבלה
        tableModel.setRowCount(0);
        
        // Reset the total price and member count fields
        text_price.setText("0.0");
        textField_1.setText("0");

        // Database connection variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        double totalPrice = 0.0; // Total price
        int memberCount = 0; // Member count

        try {
            conn = Satabase.connect(); // Connect to the database

            // Prepare the base query
            StringBuilder query = new StringBuilder("SELECT MemberID, FirstName, LastName, PhoneNumber, Gender, JoinDate, `Subscription for`, `price`, `Subscription expiration` FROM Members WHERE 1=1");

            // Adding subscription filters
            List<String> subscriptionFilters = new ArrayList<>();
            if (Month_22.isSelected()) subscriptionFilters.add("'Month'");
            if (m3_Months22.isSelected()) subscriptionFilters.add("'3 Months'");
            if (m6_Months22.isSelected()) subscriptionFilters.add("'6 Months'");
            if (Year22.isSelected()) subscriptionFilters.add("'Year'");

            if (!subscriptionFilters.isEmpty()) {
                query.append(" AND `Subscription for` IN (").append(String.join(", ", subscriptionFilters)).append(")");
            }

            // Gender selection
            if (male.isSelected()) query.append(" AND Gender = 'Male'");
            if (female.isSelected()) query.append(" AND Gender = 'Female'");

            // Current date
            Date currentDate = new Date(System.currentTimeMillis());

            // Status selection
            if (Active_members.isSelected()) {
                query.append(" AND `Subscription expiration` >= ?");
            }
            if (Former_members.isSelected()) {
                query.append(" AND `Subscription expiration` < ?");
            }

            // Specific period selection for JoinDate
            if (specific_period.isSelected()) {
                query.append(" AND JoinDate BETWEEN ? AND ?"); // Filter for JoinDate
            }

            // Order by Subscription expiration date (ascending)
            query.append(" ORDER BY `Subscription expiration` ASC"); // שינוי לסדר עולה לפי תאריך תפוגה

            // Prepare the statement
            stmt = conn.prepareStatement(query.toString());

            // Set parameters for the statement
            int paramIndex = 1;
            if (Active_members.isSelected()) {
                stmt.setDate(paramIndex++, new java.sql.Date(currentDate.getTime()));
            }
            if (Former_members.isSelected()) {
                stmt.setDate(paramIndex++, new java.sql.Date(currentDate.getTime()));
            }
            if (specific_period.isSelected()) {
                // Retrieve the values directly as Date
                java.util.Date fromDate = (java.util.Date) fromSpinner.getValue(); 
                java.util.Date toDate = (java.util.Date) untilSpinner.getValue();

                // Ensure dates are not null before setting
                if (fromDate != null && toDate != null) {
                    stmt.setDate(paramIndex++, new java.sql.Date(fromDate.getTime())); // Start date
                    stmt.setDate(paramIndex++, new java.sql.Date(toDate.getTime()));   // End date
                } else {
                    // Show an error message if dates are invalid
                    JOptionPane.showMessageDialog(null, "אנא בחר תאריכים תקינים.", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method if dates are invalid
                }
            }

            // Execute the query
            rs = stmt.executeQuery();

            // Process the results
            while (rs.next()) {
                String memberID = rs.getString("MemberID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String phoneNumber = rs.getString("PhoneNumber");
                String gender = rs.getString("Gender");
                String joinDate = rs.getString("JoinDate");
                String subscription = rs.getString("Subscription for");
                double price = rs.getDouble("price");
                String subscriptionExpiration = rs.getString("Subscription expiration");

                // Add values to the table model
                tableModel.addRow(new Object[] {
                    memberID, firstName, lastName, phoneNumber, gender, subscription, price, joinDate, subscriptionExpiration
                });

                // Calculate total price and member count
                totalPrice += price;
                memberCount++;
            }

            // Update total price and member count fields
            text_price.setText(String.valueOf(totalPrice));
            textField_1.setText(String.valueOf(memberCount));

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "שגיאה בעת טעינת חברים.", "שגיאה", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    private void searchMembers(String searchTerm) {
        // Clear the existing rows in the table model
        tableModel.setRowCount(0);
        
        // Database connection variables
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            conn = Satabase.connect(); // Connect to the database

            // Prepare the base search query
            StringBuilder query = new StringBuilder("SELECT MemberID, FirstName, LastName, PhoneNumber, Gender, JoinDate, `Subscription for`, `price`, `Subscription expiration` FROM Members WHERE 1=1");

            // Add the search conditions
            query.append(" AND (LOWER(FirstName) LIKE ? OR LOWER(LastName) LIKE ? OR PhoneNumber LIKE ?)");

            // Add the subscription filters from filterMembers1
            List<String> subscriptionFilters = new ArrayList<>();
            if (Month_22.isSelected()) subscriptionFilters.add("'Month'");
            if (m3_Months22.isSelected()) subscriptionFilters.add("'3 Months'");
            if (m6_Months22.isSelected()) subscriptionFilters.add("'6 Months'");
            if (Year22.isSelected()) subscriptionFilters.add("'Year'");

            if (!subscriptionFilters.isEmpty()) {
                query.append(" AND `Subscription for` IN (").append(String.join(", ", subscriptionFilters)).append(")");
            }

            // Gender selection
            if (male.isSelected()) query.append(" AND Gender = 'Male'");
            if (female.isSelected()) query.append(" AND Gender = 'Female'");

            // Current date
            Date currentDate = new Date(System.currentTimeMillis());

            // Status selection
            if (Active_members.isSelected()) {
                query.append(" AND `Subscription expiration` >= ?");
            }
            if (Former_members.isSelected()) {
                query.append(" AND `Subscription expiration` < ?");
            }

            // Specific period selection for JoinDate
            if (specific_period.isSelected()) {
                query.append(" AND JoinDate BETWEEN ? AND ?");
            }

            // Prepare the statement
            stmt = conn.prepareStatement(query.toString());

            // Set parameters for the search
            int paramIndex = 1;
            String likeTerm = "%" + searchTerm.toLowerCase() + "%";
            stmt.setString(paramIndex++, likeTerm);
            stmt.setString(paramIndex++, likeTerm);
            stmt.setString(paramIndex++, likeTerm);

            // Set additional parameters
            if (Active_members.isSelected()) {
                stmt.setDate(paramIndex++, new java.sql.Date(currentDate.getTime()));
            }
            if (Former_members.isSelected()) {
                stmt.setDate(paramIndex++, new java.sql.Date(currentDate.getTime()));
            }
            if (specific_period.isSelected()) {
                java.util.Date fromDate = (java.util.Date) fromSpinner.getValue();
                java.util.Date toDate = (java.util.Date) untilSpinner.getValue();

                // Ensure dates are not null before setting
                if (fromDate != null && toDate != null) {
                    stmt.setDate(paramIndex++, new java.sql.Date(fromDate.getTime())); // Start date
                    stmt.setDate(paramIndex++, new java.sql.Date(toDate.getTime()));   // End date
                } else {
                    JOptionPane.showMessageDialog(null, "אנא בחר תאריכים תקינים.", "שגיאה", JOptionPane.ERROR_MESSAGE);
                    return; // Exit the method if dates are invalid
                }
            }

            // Execute the query
            rs = stmt.executeQuery();

            // Process the results
            while (rs.next()) {
                String memberID = rs.getString("MemberID");
                String firstName = rs.getString("FirstName");
                String lastName = rs.getString("LastName");
                String phoneNumber = rs.getString("PhoneNumber");
                String gender = rs.getString("Gender");
                String joinDate = rs.getString("JoinDate");
                String subscription = rs.getString("Subscription for");
                double price = rs.getDouble("price");
                String subscriptionExpiration = rs.getString("Subscription expiration");

                // Add values to the table model
                tableModel.addRow(new Object[] {
                    memberID, firstName, lastName, phoneNumber, gender, subscription, price, joinDate, subscriptionExpiration
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "שגיאה בעת חיפוש חברים.", "שגיאה", JOptionPane.ERROR_MESSAGE);
        } finally {
            try {
                if (rs != null) rs.close();
                if (stmt != null) stmt.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
