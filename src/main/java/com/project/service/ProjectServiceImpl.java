package com.project.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.entity.Project;
import com.project.exception.ProjectExistsException;
import com.project.exception.ProjectNotFoundException;
import com.project.repository.IProjectRepository;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	IProjectRepository proRepo;

	@Override
	public Project addProject(Project p) throws ProjectExistsException {
		Optional<Project> project1 = proRepo.findByProjectName(p.getProjectName());
		if (project1.isPresent()) {
			throw new ProjectExistsException("Project already Exists with the name: " + p.getProjectName());
		} else {
			return proRepo.save(p);
		}
	}

	@Override
	public Project deleteProjectById(int pId) throws ProjectNotFoundException {
		Optional<Project> pntOpt = proRepo.findById(pId);
		if (pntOpt.isPresent()) {
			Project deletedProject = pntOpt.get();
			proRepo.deleteById(pId);
			return deletedProject;
		} else {
			throw new ProjectNotFoundException("Project not found with given id: " + pId);
		}
	}

	@Override
	public Project updateProject(int pId, Project pName) throws ProjectNotFoundException {
		Optional<Project> pntOpt = proRepo.findById(pId);
		if (pntOpt.isPresent()) {
			Project updatedProject = pntOpt.get();
			updatedProject.setProjectName(pName.getProjectName());
			updatedProject.setTeamMembers(pName.getTeamMembers());
			updatedProject.setTeamLead(pName.getTeamLead());
			updatedProject.setDeadLine(pName.getDeadLine());
			proRepo.save(updatedProject);
			return updatedProject;
		} else {
			throw new ProjectNotFoundException("Project not found with id: " + pId);
		}
	}

	@Override
	public Project getProjectById(int pId) throws ProjectNotFoundException {
		Optional<Project> pntOpt = proRepo.findById(pId);
		if (pntOpt.isPresent()) {
			return pntOpt.get();
		} else {
			throw new ProjectNotFoundException("Project not found with given id: " + pId);
		}
	}

	@Override
	public List<Project> getAllProjects() {
		return proRepo.findAll();
	}

}
