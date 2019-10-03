package login;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class output extends JFrame {

	private JPanel contentPane;
	private JTextField carmod;
	private JTextField carcomp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					output frame = new output();
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
	public output() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 679, 440);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Enter Car Details ");
		lblNewLabel_1.setFont(new Font("Trebuchet MS", Font.ITALIC, 17));
		lblNewLabel_1.setBounds(257, 11, 180, 36);
		contentPane.add(lblNewLabel_1);
		
		JLabel in2 = new JLabel("Car Model\r\n");
		in2.setFont(new Font("Georgia", Font.PLAIN, 12));
		in2.setBounds(184, 194, 167, 42);
		contentPane.add(in2);
		
		carmod = new JTextField();
		carmod.setColumns(10);
		carmod.setBounds(281, 200, 212, 31);
		contentPane.add(carmod);
		
		JLabel in1 = new JLabel("Car Company\r\n");
		in1.setFont(new Font("Georgia", Font.PLAIN, 12));
		in1.setBounds(184, 118, 167, 42);
		contentPane.add(in1);
		
		carcomp = new JTextField();
		carcomp.setColumns(10);
		carcomp.setBounds(281, 118, 212, 31);
		contentPane.add(carcomp);
		
		JButton btnNewButton = new JButton("Deliver");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			    String s1=carcomp.getText();
	            String s2=carmod.getText();
	           
	            
	            
	            Connection con=null;
		        Statement stmt=null;
		        
		    

		        try {
		            Class.forName("com.mysql.cj.jdbc.Driver");
		            System.out.println("\nDriver loaded");

		            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
		            System.out.print("Connection Successful");

		            System.out.println("\nInserting record....");
		            stmt=con.createStatement();
		           
		            String query = "delete from registration where (name = ? and car = ?)";
		            PreparedStatement preparedStmt = con.prepareStatement(query);
		            preparedStmt.setString(1,s1);
		          preparedStmt.setString(2,s2);
		          // stmt.executeUpdate(query);
		            preparedStmt.execute();
		            
		            
		            JOptionPane.showMessageDialog(null, "Exported");
		            
		            
		            j2 second=new j2();
					dispose();
					second.setVisible(true);
		            
		            
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
		btnNewButton.setFont(new Font("Sitka Text", Font.PLAIN, 14));
		btnNewButton.setBounds(297, 306, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnHome = new JButton("Home");
		btnHome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				j2 second=new j2();
				dispose();
				second.setVisible(true);
				
				
			}
		});
		btnHome.setBounds(492, 348, 89, 23);
		contentPane.add(btnHome);
	}
}
