package com.example.ui_basetest;

public class Persion {
	private String usename;
	private String sex;
	private Foods food;
	public String getUsename() {
		return usename;
	}
	public void setUsename(String usename) {
		this.usename = usename;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public Foods getFood() {
		return food;
	}
	public void setFood(Foods food) {
		this.food = food;
	}
	
	
	
	public Persion(String usename, String sex, Foods food) {
		super();
		this.usename = usename;
		this.sex = sex;
		this.food = food;
	}
	public Persion() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Persion [usename=" + usename + ", sex=" + sex + ", food=" + food + "]";
	}
	
	

}
