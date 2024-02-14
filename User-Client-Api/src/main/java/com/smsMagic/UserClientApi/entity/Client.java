package com.smsMagic.UserClientApi.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;


@Entity
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToOne
    private User user;
    @ManyToOne
    private Company company;
    private String email;
    private String phone;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Company getCompany() {
		return company;
	}
	public void setCompany(Company company) {
		this.company = company;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	
	public Client() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Client [id=" + id + ", name=" + name + ", user=" + user + ", company=" + company + ", email=" + email
				+ ", phone=" + phone + "]";
	}
	public Client(Long id, String name, User user, Company company, String email, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.user = user;
		this.company = company;
		this.email = email;
		this.phone = phone;
	}

  
    
    
}
