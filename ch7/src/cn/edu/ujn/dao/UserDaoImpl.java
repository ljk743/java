package cn.edu.ujn.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import cn.edu.ujn.model.User;

public class UserDaoImpl implements UserDaoInterface {

	@Override
	public boolean register(User user) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBHelper.getConnection();// �½�DBHelper��󣬿����ô˾������������5�д��롣
			String sql = "insert into user(username,password,sex) values(?,?,?)";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			st.setString(3,user.getSex());
			st.executeUpdate();
			st.close();
			con.close();
			return true;
		} catch (Exception ce) {
			System.out.println(ce);
			return false;
		}
	}

	@Override
	public User login(String username, String password) {
		// TODO Auto-generated method stub
		User user = null;
		try {
			Connection con = DBHelper.getConnection(); // �½�DBHelper��󣬿����ô˾������������5�д��롣
			String sql = "select * from user where username=? and password=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			rs.close();
			st.close();
			con.close();
			return user;
		} catch (Exception ce) {
			System.out.println(ce);
			return user;
		}
	}

	@Override
	public ArrayList<User> findUser() {
		// TODO Auto-generated method stub
		ArrayList<User> users=new ArrayList<User>();
		try {
			Connection con = DBHelper .getConnection(); //�½�DBHelper��� �����ô˾������������5�д��롣
			String sql = "select * from user";
			PreparedStatement st = con. prepareStatement(sql);
			ResultSet rs = st. executeQuery();
			while(rs.next()) {
					User user=new User();
					user.setId(rs.getInt("id"));
					user . setUsername(rs . getString("username"));
					user. setPassword(rs.getString("password"));
					user.setSex(rs.getString("sex"));
					users.add(user);
					
			}
			rs. close(); 
			st.close();
			con.close();
			return users;
		}catch (Exception ce) {
		System.out. println(ce);
		return users;
		}

		// TODO Auto-generated method stub
	}
	public ArrayList<User> Dim(String dimName) {
		// TODO Auto-generated method stub
		ArrayList<User> results=new ArrayList<User>();
		try {
			Connection con = DBHelper .getConnection(); //�½�DBHelper��� �����ô˾������������5�д��롣
			String sql = "select * from user where username LIKE \"%\"?\"%\"";
			PreparedStatement st = con. prepareStatement(sql);
			st.setString(1,dimName);
			ResultSet rs = st. executeQuery();
			while(rs.next()) {
					User user=new User();
					user.setId(rs.getInt("id"));
					user . setUsername(rs . getString("username"));
					user. setPassword(rs.getString("password"));
					user.setSex(rs.getString("sex"));
					results.add(user);
					
			}
			rs. close(); 
			st.close();
			con.close();
			return results;
		}catch (Exception ce) {
		System.out. println(ce);
		return results;
		}

		// TODO Auto-generated method stub
	}
	/*public User findOne() {
		// TODO Auto-generated method stub
		User user = null;
		try {
			Connection con = DBHelper .getConnection(); //�½�DBHelper��� �����ô˾������������5�д��롣
			String sql = "select from user name=?";
			PreparedStatement st = con. prepareStatement(sql);
			ResultSet rs = st. executeQuery();
			if(rs.next()) {
					user=new User();
					
					user . setUsername(rs . getString("username"));
					user. setPassword(rs.getString("password"));
					user.setSex(rs.getString("sex"));
					
			}
			rs. close(); 
			st.close();
			con.close();
			return user;
		}catch (Exception ce) {
		System.out. println(ce);
		return user;
		}
	}*/
	public boolean Delete(User user) {
	// TODO Auto-generated method stub
		try {
			System.out.print(user.getUsername());
			Connection con = DBHelper .getConnection(); //�½�DBHelper��� �����ô˾������������5�д��롣
			String sql = "delete from user where username=?";
			PreparedStatement st = con. prepareStatement(sql);
			st.setString(1, user.getUsername());
			st.executeUpdate(); 
			st.close();
			con.close();
			return true;
		}catch (Exception ce) {
			System.out. println(ce);
			return false;
		}
	}
	
	public User AlterPage(String username) {
		System.out.println(username);
		User user = null;
		// TODO Auto-generated method stub
		try {
			Connection con = DBHelper.getConnection(); // �½�DBHelper��󣬿����ô˾������������5�д��롣
			String sql = "select * from user where username=?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, username);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				user = new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				System.out.println(user.getUsername());
				user.setPassword(rs.getString("password"));
				System.out.println(user.getPassword());
				user.setSex(rs.getNString("sex"));
			}
			rs.close();
			st.close();
			con.close();
			return user;
		} catch (Exception ce) {
			System.out.println(ce);
			return user;
		}
	}
	public boolean Alter(User user) {
		// TODO Auto-generated method stub
		try {
			Connection con = DBHelper .getConnection(); //�½�DBHelper��� �����ô˾������������5�д��롣
			String sql = "update user set username=?,password=?,sex=? where id=?";
			PreparedStatement st = con. prepareStatement(sql);
			st.setString(1, user.getUsername());
			st.setString(2, user.getPassword());
			st.setString(3, user.getSex());
			st.setInt(4, user.getId());
			st.executeUpdate(); 
			st.close();
			con.close();
			return true;
		}catch (Exception ce) {
		System.out. println(ce);
		return false;
		} 
	}
}
