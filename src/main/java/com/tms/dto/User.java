package com.tms.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="user1")
public class User {
	@Id
	 private int user_id;
	@Column(nullable = false)
	 private String name;
	@Column(nullable = false)
	 private String email;
	 private String password;
	 private String role;
	

}
