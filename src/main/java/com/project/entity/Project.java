package com.project.entity;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Project {

	@Id
	@GeneratedValue
	private int projectId;
	@NotEmpty(message = "Name may not be empty")
	private String projectName;
	private int teamMembers;
	private String teamLead;
	@JsonFormat(pattern="dd/MM/yyyy")
	private LocalDate deadLine;

}
