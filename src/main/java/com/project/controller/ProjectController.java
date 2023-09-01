package com.project.controller;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.entity.Project;
import com.project.exception.ProjectExistsException;
import com.project.exception.ProjectNotFoundException;
import com.project.service.ProjectServiceImpl;

@RestController
@RequestMapping("/Project")
@CrossOrigin(origins="http://localhost:4200")
public class ProjectController {
	@Autowired
	ProjectServiceImpl projServ;

	private static Logger logger = LogManager.getLogger();

	@PostMapping("/add")
	ResponseEntity<Project> addProject(@RequestBody Project project) throws ProjectExistsException{
		logger.info("Sending Request to Add new Project");
		Project addProject = projServ.addProject(project);
		return new ResponseEntity<>(addProject,HttpStatus.CREATED);
	}

	@DeleteMapping("/delete/{pId}")
	ResponseEntity<Project> deleteProjectById(@PathVariable int pId) throws ProjectNotFoundException{
		logger.info("Sending Request to deleteProject");
		Project deleteProject = projServ.deleteProjectById(pId);
		return new ResponseEntity<>(deleteProject,HttpStatus.OK);
	}

	@PutMapping("/update/{pId}")
	ResponseEntity<Project> updateProjectById(@PathVariable int pId,@RequestBody Project project) throws ProjectNotFoundException{
		logger.info("Sending Request to update Project");
		Project updateProject = projServ.updateProject(pId, project);
		return new ResponseEntity<>(updateProject,HttpStatus.CREATED);
	}
	@GetMapping("/get/{pId}")
	ResponseEntity<Project> getProjectById(@PathVariable int pId) throws ProjectNotFoundException{
		logger.info("Sending Request to get the Project by Id");
		Project getProject = projServ.getProjectById(pId);
		return new ResponseEntity<>(getProject,HttpStatus.OK);
	}
	@GetMapping("/getAll")
	ResponseEntity<List<Project>> getAllPatients() {
		logger.info("Sending Request to get all the Projects");
	List<Project> projects= projServ.getAllProjects();
	return new ResponseEntity<>(projects, HttpStatus.OK);
	}


}
