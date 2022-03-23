package com.example.sprint1.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class RoleEntity {

	public static final int ADMIN = 1;
	public static final int FACULTY = 2;
	
    @Id
    @GeneratedValue
	private long id;
	private String name;
	private String description;
	
}
