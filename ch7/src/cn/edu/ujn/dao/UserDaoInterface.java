package cn.edu.ujn.dao;

import java.util.ArrayList;

import cn.edu.ujn.model.User;

public interface UserDaoInterface {
	public boolean register(User user);
	public User login(String username, String password);
	public ArrayList<User> findUser();
	public boolean Delete(User user);
	public boolean Alter(User user);
	public User AlterPage(String select_user);
	public ArrayList<User> Dim(String dimName);
	
}
