import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.filechooser.FileSystemView;
import javax.swing.table.DefaultTableModel;

import java.io.File;
//import com.sun.java.util.jar.pack.Package.File;

import javax.swing.JButton;
import javax.swing.JColorChooser; 	
import javax.swing.JFileChooser;

import java.awt.event.ActionListener;
import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class mailframe extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;
	private String path;
	public String loc;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mailframe frame = new mailframe();
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
	public mailframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 890, 587);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		textField = new JTextField();
		textField.setBounds(128, 119, 443, 29);
		contentPane.add(textField);
		textField.setColumns(10);
		
		
		
		
		
		JButton btnChooseFile = new JButton("choose file\r\n");
		btnChooseFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				JFileChooser jfile = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
				int returnvalue = jfile.showOpenDialog(null);
				if(returnvalue == JFileChooser.APPROVE_OPTION) {
					File selectedfile = jfile.getSelectedFile();
					 
					//System.out.println(selectedfile.getAbsolutePath());
					 path=selectedfile.getAbsolutePath();
					textField.setText(path);
					Send.setpath(path);
					loc=path;
					
				}
			}
		});
		
		
		
		
		btnChooseFile.setBounds(636, 117, 171, 29);
		contentPane.add(btnChooseFile);
		
		
		
		
		
		JButton btnNewButton = new JButton("Send Mail");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(loc==null)
				{
					JOptionPane.showMessageDialog(null,"File Not Selected");
				}
				else
				{
				
	    		Connection con=null;
	            Statement stmt=null;
	            ResultSet rs=null;

	            try {
	                Class.forName("com.mysql.cj.jdbc.Driver");
	                System.out.println("\nDriver loaded");

	                con=DriverManager.getConnection("jdbc:mysql://localhost:3306/db1","root","");
	                System.out.print("Connection Successful");

	    		
	                System.out.println("\nInserting record....");
	               // stmt=con.createStatement();

	                
	                String query="select email from customer";
	         
	              
	                stmt=con.createStatement();
	                rs=stmt.executeQuery(query);
	                String email=new String();
	                ArrayList<String> arr = new ArrayList<String>();
	                
	               while(rs.next())
	               {
	            	  
	            		  email=rs.getString("email");
	            		  arr.add(email);
	            
	               }
	               
	               
	               System.out.print(arr);
	               
	               int i=0;
	               for(i=0;i<arr.size();i++)
	               {
	            	   Send.sendMail(arr.get(i));
	               }
	              
	                
	                stmt=con.createStatement();
	                rs=stmt.executeQuery(query);
	               
	                
	                
	                
	                
	                DefaultTableModel model=new DefaultTableModel();
	                
	                
	                model.addColumn("Name");
	                model.addColumn("Email");
	                model.addColumn("Contact no");
	                
	                
	                String query1="select name,email,contactno from customer";
	                
	                stmt=con.createStatement();
	                rs=stmt.executeQuery(query1);
	                
	               while(rs.next())
	               {
	            	   model.addRow(new Object[]
	            	   {
	            		   rs.getString("name"),
	            		   rs.getString("email"),
	            		   rs.getString("contactno"),
	            		       
	            	   });
	               }
	               
	                
	                
	         
	               rs.close();
	               stmt.close();
	               con.close();
	                
	               
	               
	               table.setModel(model);
	               table.setAutoResizeMode(0);
	               table.getColumnModel().getColumn(0).setPreferredWidth(300);
	               table.getColumnModel().getColumn(1).setPreferredWidth(300);
	               table.getColumnModel().getColumn(2).setPreferredWidth(300);
	               
	             
	            }
				

	            catch(Exception e1)
	            {
	            	JOptionPane.showMessageDialog(null, e1);
	            }

				}
			}
		});
	
		btnNewButton.setBounds(636, 188, 171, 29);
		contentPane.add(btnNewButton);
		
		
	
		
		
		JLabel lblNewLabel = new JLabel("File Path :");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel.setBounds(48, 117, 79, 29);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(75, 242, 732, 228);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		
		
		
	}
}
