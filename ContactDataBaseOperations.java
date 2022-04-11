package edu.spiders.mycontacts.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import edu.jspiders.mycontacts.dto.MyContacts;



public class ContactDataBaseOperations 
{
	private final static String DRIVER_CLASS = "com.mysql.jdbc.Driver";
	private final static String DB_URL = "jdbc:mysql://localhost:3306/ContactFile?user=root&password=root";
	
	public boolean addContact(MyContacts contacts) 
	{

		Connection con = null;
		PreparedStatement pstmt = null;		
		try
		{
			Class.forName(DRIVER_CLASS);

			con = DriverManager.getConnection(DB_URL);

			String query="INSERT INTO Contact VALUES(?,?,?,?)";
			pstmt=con.prepareStatement(query);
			pstmt.setLong(1, contacts.getNumber());
			pstmt.setString(2, contacts.getName());
			pstmt.setString(3, contacts.getEmailId());
			pstmt.setString(4, contacts.getDOB());
			
			int rowsAffected=pstmt.executeUpdate();

			return (rowsAffected > 0);

		} 
		catch (Exception e)
		{
			e.printStackTrace();
		} 
		finally 
		{

			if(con != null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

			if(pstmt != null)
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public MyContacts searchContact(String name)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			Class.forName(DRIVER_CLASS);

			con = DriverManager.getConnection(DB_URL);

			String query = "SELECT * FROM Contact WHERE Name = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);

			rs = pstmt.executeQuery();

			if(rs.next())
			{
				int contactNum = rs.getInt(1);
				String contactName = rs.getString(2);
				String emailId = rs.getString(3);
				String DOB = rs.getString(4);


				MyContacts contact = new MyContacts();
				
				contact.setNumber(contactNum);
				contact.setName(contactName);
				contact.setEmailId(emailId);
				contact.setDOB(DOB);
				
				return contact ;
			}

		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(con != null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

			if(pstmt != null)
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

			if(rs != null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public ArrayList<MyContacts> getAllContacts() 
	{
		ArrayList<MyContacts> ContactList = new ArrayList<MyContacts>();

		Connection con =  null;
		Statement stmt =null;
		ResultSet rs = null;
		try 
		{
			Class.forName(DRIVER_CLASS);
			con = DriverManager.getConnection(DB_URL);
			stmt = con.createStatement();
			rs = stmt.executeQuery("SELECT * FROM Contact");

			while (rs.next()) 
			{
				MyContacts contact = new MyContacts();

				contact.setNumber(rs.getInt(1));
				contact.setName(rs.getString(2));
				contact.setEmailId(rs.getString(3));
				contact.setDOB(rs.getString(4));

				ContactList.add(contact);
			}

		} 
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		}
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally
		{
			if(con != null)
			{
				try
				{
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(stmt != null)
			{
				try 
				{
					stmt.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(rs != null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return ContactList;
	}
	
	public MyContacts searchContacts(String name)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try
		{
			Class.forName(DRIVER_CLASS);

			con = DriverManager.getConnection(DB_URL);

			String query = "SELECT * FROM Contact WHERE Name = ?";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);

			rs = pstmt.executeQuery();

			if(rs.next())
			{
				int contactNum = rs.getInt(1);
				String contactName = rs.getString(2);
				String emailId = rs.getString(3);
				String DOB = rs.getString(4);


				MyContacts contact = new MyContacts();
				
				contact.setNumber(contactNum);
				contact.setName(contactName);
				contact.setEmailId(emailId);
				contact.setDOB(DOB);
				
				return contact ;
			}

		} 
		catch (ClassNotFoundException e)
		{
			e.printStackTrace();
		} 
		catch (SQLException e) 
		{
			e.printStackTrace();
		}
		finally 
		{
			if(con != null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

			if(pstmt != null)
			{
				try 
				{
					pstmt.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}

			if(rs != null)
			{
				try 
				{
					rs.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	public boolean updateContacts(MyContacts cntct) 
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		try 
		{
			Class.forName(DRIVER_CLASS);
			con = DriverManager.getConnection(DB_URL);

			String query = "UPDATE Contact set  Name = ? , emailId = ?, Date_Of_Birth = ? WHERE Number = ?";
			pstmt = con.prepareStatement(query);
			
			pstmt.setString(1, cntct.getName());
			pstmt.setString(2, cntct.getEmailId());
			pstmt.setString(3, cntct.getDOB());
			pstmt.setLong(4, cntct.getNumber());
			
			int rowsAffected = pstmt.executeUpdate();
		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(con != null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt != null)
			{
				try
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return true;
	}
	
	public boolean deleteContacts(String name)
	{
		Connection con = null;
		PreparedStatement pstmt = null;
		try 
		{
			Class.forName(DRIVER_CLASS);
			con = DriverManager.getConnection(DB_URL);

			String query = "DELETE FROM Contact WHERE Name = ? ";
			pstmt = con.prepareStatement(query);
			pstmt.setString(1, name);

			int rowsAffected = pstmt.executeUpdate();



		}
		catch (ClassNotFoundException e) 
		{
			e.printStackTrace();
		} 
		catch (SQLException e)
		{
			e.printStackTrace();
		}
		finally 
		{
			if(con != null)
			{
				try 
				{
					con.close();
				} 
				catch (SQLException e)
				{
					e.printStackTrace();
				}
			}
			if(pstmt != null)
			{
				try
				{
					pstmt.close();
				} 
				catch (SQLException e) 
				{
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	
}
