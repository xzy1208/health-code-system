package com.dao;

import java.util.ArrayList;

import model.student;
public interface StudentDao extends Dao{
    //添加客户方法
    public boolean addstudent (student student) throws DaoException;
 	// 按id查询客户方法
	public student findById (String number) throws DaoException;
    // 查询所有客户方法
	public boolean delstudent (student student) throws DaoException;
	
    public ArrayList<student> findAllstudent()throws DaoException;
}
