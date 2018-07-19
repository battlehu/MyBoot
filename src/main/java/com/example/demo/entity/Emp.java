/**
 * 
 */
package com.example.demo.entity;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author LOL
 * 2017年2月13日下午1:33:28
 */

@Component
@Lazy
public class Emp {
	private int sid;
	private String name;
	private double salary;
	private int age;
	
	public Emp() {
		super();
	}
	public Emp(String name, double salary, int age) {
		super();
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	public Emp(int sid, String name, double salary, int age) {
		super();
		this.sid = sid;
		this.name = name;
		this.salary = salary;
		this.age = age;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age){ this.age = age;}
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		long temp;
		temp = Double.doubleToLongBits(salary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + sid;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Emp other = (Emp) obj;
		if (age != other.age)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (Double.doubleToLongBits(salary) != Double.doubleToLongBits(other.salary))
			return false;
		if (sid != other.sid)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Emp [sid=" + sid + ", name=" + name + ", salary=" + salary + ", age=" + age + "]";
	}
	public Emp(int sid) {
		super();
		this.sid = sid;
	}
}
