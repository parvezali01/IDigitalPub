package com.project.service;

import java.util.List;

import com.project.entity.Project;
import com.project.exception.ProjectExistsException;
import com.project.exception.ProjectNotFoundException;

public interface IProjectService {
	Project addProject(Project p) throws ProjectExistsException;
	Project deleteProjectById(int pId) throws ProjectNotFoundException;
	Project updateProject(int pId, Project pName)throws ProjectNotFoundException;
	Project getProjectById(int pId) throws ProjectNotFoundException;
	List<Project> getAllProjects();
}
