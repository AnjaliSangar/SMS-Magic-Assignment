package com.smsMagic.UserClientApi.entity;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
   
    private Long id;
    private String username;
    
    
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}
	public User(Long id, String username) {
		super();
		this.id = id;
		this.username = username;
	}

    
    
    
}
