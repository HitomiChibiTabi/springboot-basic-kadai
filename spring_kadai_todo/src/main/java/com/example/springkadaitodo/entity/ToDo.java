package com.example.springkadaitodo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "todos")
@Data

public class ToDo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer toDoId;
	
	@Column(name = "title")
	private String toDoTitle;
	
	@Column(name = "priority")
	private String toDoPriority;
	
	@Column(name = "status")
	private String toDoStatus;
	
	
}
