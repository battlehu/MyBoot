/**
 * 
 */
package com.example.demo.mapper;

import java.util.List;

import com.example.demo.entity.Emp;
import com.example.demo.entity.FenYe;
import com.example.demo.entity.PageBean;

/**
 * @author LOL
 * 2017年2月13日下午12:49:32
 */
public interface EmpDao {
	public List<Emp> findAll(FenYe fenYe);
	
	public void savaEmp(Emp emp); 
	
	public void deleteEmpById(int sid);
	
	public Emp findById(int sid);
	
	public void updateEmp(Emp emp);
	
	public int getTotalCount();
}
