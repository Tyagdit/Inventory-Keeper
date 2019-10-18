import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;

public class cust extends JFrame {

	private JPanel contentPane;
	private JTextField custname3;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JPasswordField passwordField;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			private String a,b,c;

			public void run() {
				try {
					cust frame = new cust(a,b,c);
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
	public cust(String car,String color,String rate) 
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.controlShadow);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\toyota(1).png"));
		lblNewLabel.setBounds(10, 11, 178, 93);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Dinesh\\Downloads\\toyota(1).png"));
		lblNewLabel_1.setBounds(539, 11, 145, 93);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Customer Details And Payments");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_2.setBounds(192, 49, 311, 55);
		contentPane.add(lblNewLabel_2);
		
		JLabel label = new JLabel("TOYOTA");
		label.setForeground(Color.RED);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(33, 115, 98, 28);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("TOYOTA");
		label_1.setForeground(Color.RED);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_1.setBounds(564, 115, 98, 28);
		contentPane.add(label_1);
		
		JLabel lblNewLabel_3 = new JLabel("Customer Name :");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblNewLabel_3.setBounds(197, 153, 113, 28);
		contentPane.add(lblNewLabel_3);
		
		custname3 = new JTextField();
		custname3.setBounds(320, 158, 160, 20);
		contentPane.add(custname3);
		custname3.setColumns(10);
		
		
		
		//System.out.println(test);
		//System.out.println(custname3.getText());
		//String test= "Dinesh";
		
		
		
		
		
		
		
		JLabel lblPhoneNumber = new JLabel("Phone Number :");
		lblPhoneNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPhoneNumber.setBounds(197, 208, 113, 28);
		contentPane.add(lblPhoneNumber);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(320, 213, 160, 20);
		contentPane.add(textField_1);
		
		JLabel lblAddress = new JLabel("Address :");
		lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblAddress.setBounds(197, 271, 113, 28);
		contentPane.add(lblAddress);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(320, 271, 160, 44);
		contentPane.add(textField_2);
		
		JLabel lblCardNumber = new JLabel("Card Number :");
		lblCardNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCardNumber.setBounds(197, 352, 113, 28);
		contentPane.add(lblCardNumber);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(320, 357, 160, 20);
		contentPane.add(textField_3);
		
		JLabel lblPin = new JLabel("Pin : ");
		lblPin.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPin.setBounds(197, 402, 113, 28);
		contentPane.add(lblPin);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(320, 407, 160, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				Connection con=null;
		        Statement stmt=null;
		        
		        
		   	 
				   SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				   String date = sdf.format(new Date());
				   System.out.println(date);
		        
				   
		    

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            System.out.println("\nDriver loaded");
		            
		            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","");
		            System.out.print("Connection Successful");

		           // System.out.println("You selected "+x);
		            System.out.println("\nInserting record....");
		            stmt=(Statement) con.createStatement();
		           
		    		
		    		String t = custname3.getText();
		    		System.out.print(t);
		    		
		    		String test= custname3.getText();
		    		
		   
		    		String t1 = textField_1.getText();
		    		System.out.print(t1);
		    		
		    		String t2 = textField_2.getText();
		    		System.out.print(t2);
		    		
		    		String t5 = textField_3.getText();
		    		System.out.print(t2);
		    		
		    		
		            System.out.print(car);
		            
		            System.out.print(car);
		            System.out.print(color);
		            
		           
		            
		            //String query=("INSERT INTO customer (name,number,address,car,color,price,date)" +" values ('"+t+"','"+t1+"','"+t2+"','"+car+"','"+color+"','"+rate+"')");
		            
		            
		            String query=("INSERT INTO customer (name,number,address,car,color,price,date)" +" values ('"+t+"','"+t1+"','"+t2+"','"+car+"','"+color+"','"+rate+"','"+date+"')");	            
		            
		          if(t.isEmpty() || t1.isEmpty() || t2.isEmpty() )
		           {
		        	   JOptionPane.showMessageDialog(null, "FILL UP ALL DETAILS");
		           }
		           
		          
		          else if(test.matches("(.*)[0-9](.*)"))
		        		  {
		        	  
		        	  JOptionPane.showMessageDialog(null, "Numbers Not Allowed in name");
		        		  }
		          
		          else if(!t1.matches("^[0-9]{10}$"))  {
		        	  JOptionPane.showMessageDialog(null, "Customer no is not valid");
		          }
		          
		          
		          
		          else if(!t5.matches("^[0-9]{16}$"))  {
		        	  JOptionPane.showMessageDialog(null, "Customer card no is not valid");
		          }
		          
		           else
		           {
		        	   String q1 ="DELETE FROM store WHERE quantity ="+"'"+0+"'"+";";
			        	stmt.executeUpdate(q1);
			        	String q ="Update store set quantity = quantity-1 where model ="+"'"+car+"'"+ "and color="+"'"+color+"'"+";" ;
			        	stmt.executeUpdate(q);
			        	
			        	
			        	
		        	 
		        	   
		              stmt.executeUpdate(query);
		           
		           JOptionPane.showMessageDialog(null, "THANK YOU FOR CHOOSING US");
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
		        	 JOptionPane.showMessageDialog(null, "Insertion Not Successfull");
		        }

			
			}
		});
		btnNewButton.setBounds(564, 430, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("HOME");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashori d =new dashori();
				dispose();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(47, 430, 89, 23);
		contentPane.add(btnNewButton_1);
	}

}
