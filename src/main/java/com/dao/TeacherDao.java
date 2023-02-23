package com.dao;
import java.util.ArrayList;
import model.teacher;
public interface TeacherDao extends Dao{
    //添加客户方法
    public boolean addteacher (teacher teacher) throws DaoException;
 	// 按id查询客户方法
	public teacher findById (String number) throws DaoException;
    // 查询所有客户方法
	public boolean delteacher (teacher teacher) throws DaoException;
	
    public ArrayList<teacher> findAllteacher ()throws DaoException;
}

