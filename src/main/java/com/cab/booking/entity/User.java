package com.cab.booking.entity;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity(name = "tbl_user")
public class User implements UserDetails {
	
	private static final long serialVersionUID = 3384860536771517130L;

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	private String firstName;
	
	private String lastName;
	
    private String username;
    
    private String password;
    
    private String passwordConfirm;
    
    /*@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "user_course", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "user_subsribed_course_id"))
    private Set<Address> courses;*/

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String emaiID) {
		this.username = emaiID;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirm() {
		return passwordConfirm;
	}

	public void setPasswordConfirm(String passwordConfirm) {
		this.passwordConfirm = passwordConfirm;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}
}
