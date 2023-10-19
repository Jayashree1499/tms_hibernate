package com.tms.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Task {
	@Id
	private int t_id;
	private String dicription;
	private String status;
	private String created_date_time;
	private String completed_date_time;
	@ManyToOne
	private User user;

}
