import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTable;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;

import java.util.*;
import java.text.SimpleDateFormat;
import javax.swing.JLabel;
import java.awt.Font;

public class cust_table extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton button;
	private JLabel lblNewLabel;
	private JLabel totalsum;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cust_table frame = new cust_table();
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
	public cust_table() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(89, 82, 554, 258);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("LOAD DATA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				
	    		Connection con=null;
	            Statement stmt=null;
	            ResultSet rs=null;

	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                System.out.println("\nDriver loaded");

	                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","root");
	                System.out.print("Connection Successful");

	    		
	                System.out.println("\nInserting record....");
	               // stmt=con.createStatement();

	                DefaultTableModel model=new DefaultTableModel();
	                
	                model.addColumn("Name");
	                model.addColumn("Number");
	                model.addColumn("Address");
	                model.addColumn("Car");
	                model.addColumn("Color");
	                model.addColumn("Price");
	                model.addColumn("Date");
	              
	                
	                String query="select * from customer";
	         
	              
	              
	                
	                
	                stmt=con.createStatement();
	                rs=stmt.executeQuery(query);
	                
	               while(rs.next())
	               {
	            	   model.addRow(new Object[]
	            	   {
	            		   rs.getString("name"),
	            		   rs.getString("number"),
	            		   rs.getString("address"),
	            		   rs.getString("car"),
	            		   rs.getString("color"),
	            		  rs.getString("price"),
	            		  rs.getString("date")
	            		     
	            	   });
	               }
	               
	              
	                
	                stmt=con.createStatement();
	                rs=stmt.executeQuery(query);
	               
	               
	               
	               rs.close();
	               stmt.close();
	               con.close();
	                
	               table.setModel(model);
	               table.setAutoResizeMode(0);
	               table.getColumnModel().getColumn(0).setPreferredWidth(150);
	               table.getColumnModel().getColumn(1).setPreferredWidth(150);
	               table.getColumnModel().getColumn(2).setPreferredWidth(120);
	               table.getColumnModel().getColumn(3).setPreferredWidth(150);
	               table.getColumnModel().getColumn(4).setPreferredWidth(120);
	               table.getColumnModel().getColumn(5).setPreferredWidth(120);
	               table.getColumnModel().getColumn(6).setPreferredWidth(120);
	               
	               
	               
	               double total=0;
		              for(int i=0;i<model.getRowCount();i++)
		              {
		            	  int amount=Integer.parseInt((String) model.getValueAt(i,5));
		            	  total=total+amount;
		              }
		              
		              totalsum.setText(String.valueOf(total+" Lakhs"));
	               
	               
	            }
	     

	            catch(Exception e1)
	            {
	            	JOptionPane.showMessageDialog(null, e1);
	            }

					
				
				
				
			}
		});
		btnNewButton.setBounds(319, 31, 119, 23);
		contentPane.add(btnNewButton);
		
		button = new JButton("HOME");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dashori d =new dashori();
				dispose();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
				
			}
		});
		button.setBounds(319, 397, 89, 23);
		contentPane.add(button);
		
		lblNewLabel = new JLabel("Total Sales:");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(456, 340, 107, 23);
		contentPane.add(lblNewLabel);
		
		totalsum = new JLabel("");
		totalsum.setFont(new Font("Tahoma", Font.BOLD, 17));
		totalsum.setBounds(549, 340, 94, 23);
		contentPane.add(totalsum);
	}

}
