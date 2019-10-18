import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import javax.swing.JButton;

public class dash extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	public String x,y;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dash frame = new dash();
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
	public dash() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
	
		comboBox.setBounds(176, 151, 140, 33);
		contentPane.add(comboBox);
		comboBox.addItem("Etios Cross");
		comboBox.addItem("Fortuner");
		comboBox.addItem("Glanza");
		comboBox.addItem("Innova Crysta");
		comboBox.addItem("Corolla Altis");
		
		//comboBox.addItem("Prius");
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(389, 246, 140, 33);
		contentPane.add(comboBox_1);
		
		/*JComboBox comboBox1 = new JComboBox();
		
		comboBox1.setBounds(176, 151, 140, 33);
		contentPane.add(comboBox1);*/
		comboBox_1.addItem("Red");
		comboBox_1.addItem("Blue");
		comboBox_1.addItem("Black");
		comboBox_1.addItem("Green");
		
		
		
		
		
		JLabel lblNewLabel = new JLabel("Select Car");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(176, 126, 74, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblManufactureDate = new JLabel("Import Date");
		lblManufactureDate.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblManufactureDate.setBounds(176, 221, 129, 14);
		contentPane.add(lblManufactureDate);
		
	
		
		
		textField = new JTextField();
		textField.setBounds(176, 246, 140, 33);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("Enter Car Details");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel_1.setBounds(291, 11, 160, 39);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblPlaceOfManufacturing = new JLabel("Place of Manufacturing");
		lblPlaceOfManufacturing.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblPlaceOfManufacturing.setBounds(176, 316, 160, 14);
		contentPane.add(lblPlaceOfManufacturing);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(176, 341, 140, 39);
		contentPane.add(textField_1);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\toyota(1).png"));
		lblNewLabel_2.setBounds(44, 11, 148, 89);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\toyota(1).png"));
		lblNewLabel_3.setBounds(486, 11, 140, 89);
		contentPane.add(lblNewLabel_3);
		
		JLabel label = new JLabel("TOYOTA");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(76, 98, 98, 28);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("TOYOTA");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(511, 98, 98, 28);
		contentPane.add(label_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(389, 151, 140, 33);
		contentPane.add(textField_2);
		
		JLabel lblEstimatedPrice = new JLabel("Estimated Price");
		lblEstimatedPrice.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblEstimatedPrice.setBounds(389, 127, 129, 14);
		contentPane.add(lblEstimatedPrice);
		
		JLabel lblMileage = new JLabel("Color");
		lblMileage.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblMileage.setBounds(389, 222, 129, 14);
		contentPane.add(lblMileage);
		
		JLabel lblQuantity = new JLabel("Quantity");
		lblQuantity.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblQuantity.setBounds(389, 317, 129, 14);
		contentPane.add(lblQuantity);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(389, 347, 140, 33);
		contentPane.add(textField_4);
		
		
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String selected=(String) comboBox.getSelectedItem();
				
				System.out.println("You selected "+selected);
				x=selected;
			}
		});
		
		

		
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String selected=(String) comboBox_1.getSelectedItem();
				
				System.out.println("You selected "+selected);
				y=selected;
			}
		});
		
		

		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				Connection con=null;
		        Statement stmt=null;
		        
		    

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            System.out.println("\nDriver loaded");

		            
		         
		            
		            
		            
		            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
		            System.out.print("Connection Successful");

		            System.out.println("You selected "+x);
		            System.out.println("You selected "+y);
		            System.out.println("\nInserting record....");
		            stmt=con.createStatement();
		           
		    		
		    		String t = textField.getText();
		    		System.out.print(t);
		    		
		    		String t1 = textField_1.getText();
		    		System.out.print(t1);
		    		
		    		int t2 = Integer.parseInt(textField_2.getText());
		    		System.out.print(t2);
		    		
		    		
		    		/*float t3 = Float.parseFloat(textField_3.getText());
		    		System.out.print(t3);*/
		    		
		    		int t4 = Integer.parseInt(textField_4.getText());
		    		System.out.print(t4);
		    		
		            
		            
		           String query=("INSERT INTO store (model,date,place,price,color,quantity)" +" values ('"+x+"','"+t+"','"+t1+"','"+t2+"','"+y+"','"+t4+"')");
		           
		          if( t1.isEmpty() || t2==0 || t4==0)
		           {
		        	   JOptionPane.showMessageDialog(null, "Error at Quantity / Price both must be in digits");
		           }
		           
		          else if(!t.matches("^2([0-9]{3})-([012][0-9]|3[0-2])-(0[0-9]|1[0-2])$"))
		          {
		        	  JOptionPane.showMessageDialog(null, "Date Format is Wrong");
		          }
		          
		          
		        
		          
		           else
		           {
		
		           stmt.executeUpdate(query);
		           
		           JOptionPane.showMessageDialog(null, "Insertion Successfull");
		           }
		           
		        }
		
		      
		        
		        catch(ClassNotFoundException e1)
		        {
		            System.out.print("Exception "+e1.getMessage());
		        }
		        
		        
		        catch(SQLException se){
		            //Handle errors for JDBC
		            se.printStackTrace();
		        }
		      
		        catch(Exception e3)
		        {
		        	// JOptionPane.showMessageDialog(null, "Insertion Not Successfull");
		        	 JOptionPane.showMessageDialog(null, "Error at Quantity / Price both must be in digits");
		        }

				
				
			}
		});
		btnNewButton.setBounds(317, 410, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblInLakhs = new JLabel("In lakhs");
		lblInLakhs.setFont(new Font("Sitka Banner", Font.PLAIN, 12));
		lblInLakhs.setBounds(539, 160, 46, 14);
		contentPane.add(lblInLakhs);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dashori d=new dashori();
				dispose();
				d.setLocationRelativeTo(null);
				d.setVisible(true);		
				
			}
		});
		btnBack.setBounds(49, 410, 89, 23);
		contentPane.add(btnBack);
		
		JLabel lblNewLabel_4 = new JLabel("YYYY/MM/DD");
		lblNewLabel_4.setBounds(92, 255, 74, 14);
		contentPane.add(lblNewLabel_4);
		
		
		

		
	}
}
