package com.seantayler.tmpm.services;

import com.seantayler.tmpm.domain.Backlog;
import com.seantayler.tmpm.domain.ProjectTask;
import com.seantayler.tmpm.repositories.BacklogRepository;
import com.seantayler.tmpm.repositories.ProjectTaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProjectTaskService {

    @Autowired
    private BacklogRepository backlogRepository;

    @Autowired
    private ProjectTaskRepository projectTaskRepository;

    public ProjectTask addProjectTask(String projectIdentifier, ProjectTask projectTask){
        Backlog backlog = backlogRepository.findByProjectIdentifier(projectIdentifier);
        projectTask.setBacklog(backlog);
        Integer BacklogSequence = backlog.getPTSequence();
        BacklogSequence++;
        projectTask.setProjectSequence(backlog.getProjectIdentifier() + "-" + BacklogSequence);
        projectTask.setProjectIdentifier(projectIdentifier);

        if(projectTask.getPriority() == 0 || projectTask.getPriority() == null){
            projectTask.setPriority(3);
        }
        if(projectTask.getStatus() == "" || projectTask.getStatus() == null){
            projectTask.setStatus("TO_DO");
        }

        return projectTaskRepository.save(projectTask);
    }

}
