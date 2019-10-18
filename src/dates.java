import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class dates extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	public String s_date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dates frame = new dates();
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
	public dates() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 503);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Date :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setBounds(235, 138, 46, 14);
		contentPane.add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(280, 136, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("YYYY-MM-DD");
		lblNewLabel_1.setBounds(376, 139, 95, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel totalsum = new JLabel("");
		totalsum.setFont(new Font("Tahoma", Font.BOLD, 17));
		totalsum.setBounds(555, 412, 94, 23);
		contentPane.add(totalsum);
	
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(52, 205, 597, 204);
		contentPane.add(scrollPane);
		
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		s_date=textField.getText();
		System.out.print(s_date);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				s_date=textField.getText();
				System.out.print(s_date);
				
				
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
	                
	                String query="select * from customer where date="+"'"+s_date+"'"+";";;
	                
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
		
		btnNewButton.setBounds(280, 163, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblEnterDateOf = new JLabel("Enter Date Of which You need History Off");
		lblEnterDateOf.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblEnterDateOf.setBounds(180, 23, 367, 39);
		contentPane.add(lblEnterDateOf);
		
		JLabel label = new JLabel("Total Sales:");
		label.setFont(new Font("Tahoma", Font.BOLD, 14));
		label.setBounds(440, 412, 107, 23);
		contentPane.add(label);
		
		JButton btnNewButton_1 = new JButton("Back");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				dashori d=new dashori();
				dispose();
				d.setLocationRelativeTo(null);
				d.setVisible(true);
				
				
			}
			
			
		});
		btnNewButton_1.setBounds(34, 420, 89, 23);
		contentPane.add(btnNewButton_1);
		
	
		
		
	}
}
