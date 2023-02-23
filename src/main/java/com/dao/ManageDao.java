package com.dao;
import java.util.ArrayList;
import model.manage;
public interface ManageDao extends Dao{
    //添加客户方法
    public boolean addmanage (manage manage) throws DaoException;
 	// 按id查询客户方法
	public manage findById (String number) throws DaoException;
    // 查询所有客户方法
	public boolean delmanage (manage manage) throws DaoException;
	
    public ArrayList<manage> findAllmanage ()throws DaoException;
}

