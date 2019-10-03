package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextField;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.JButton;

public class customer_detail extends JFrame {

	private JPanel contentPane;
	private JTextField customer_name;
	private JTextField customer_no;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					customer_detail frame = new customer_detail();
					frame.setLocationRelativeTo(null);
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
	public customer_detail() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setBounds(100, 100, 679, 440);
		
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("                  Customer Details");
		lblNewLabel.setFont(new Font("Calisto MT", Font.BOLD, 17));
		lblNewLabel.setBounds(177, 11, 258, 33);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Customer Name");
		lblNewLabel_1.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(159, 81, 145, 20);
		contentPane.add(lblNewLabel_1);
		
		customer_name = new JTextField();
		
		customer_name.setBounds(324, 83, 208, 20);
		contentPane.add(customer_name);
		customer_name.setColumns(10);
		
		
		
		
		
		
		JLabel lblNewLabel_2 = new JLabel("Customer Number");
		lblNewLabel_2.setFont(new Font("Nirmala UI Semilight", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(159, 147, 145, 20);
		contentPane.add(lblNewLabel_2);
		
		customer_no = new JTextField();
		customer_no.setColumns(10);
		customer_no.setBounds(324, 149, 208, 20);
		contentPane.add(customer_no);
		String c=customer_name.getText();
		System.out.print(c);
		
		
		
		
	  
	     
		
		
		JButton btnNewButton = new JButton("submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				


				Connection con=null;
		        Statement stmt=null;

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            System.out.println("\nDriver loaded");

		            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
		            System.out.print("Connection Successful");

				
		            System.out.println("\nInserting record....");
		            stmt=con.createStatement();
		            String s1=customer_name.getText();
		            String s2=customer_no.getText();
		            stmt.executeUpdate("insert into customer (name,number) values('"+s1+"','"+s2+"')");

		           
		            
		        }
		        catch(ClassNotFoundException e)
		        {
		            System.out.print("Exception "+e.getMessage());
		        }
		        
		        
		        catch(SQLException se){
		            //Handle errors for JDBC
		            se.printStackTrace();
		        }
				
		        
		        
			
			}
		});


		btnNewButton.setBounds(268, 218, 89, 23);
		contentPane.add(btnNewButton);
	}
}
