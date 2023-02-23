package com.dao;

import java.util.ArrayList;

import model.acsucl;

public interface AcsuclDao extends Dao{
	    //添加客户方法
	    public boolean addacsucl (acsucl acsucl) throws DaoException;
	 	// 按id查询客户方法
		public acsucl findById (String number) throws DaoException;
	    // 查询所有客户方法
		public boolean delacsual (acsucl acsucl) throws DaoException;
		
	    public ArrayList<acsucl> findAllacsual()throws DaoException;
	}
