package test.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

	@Autowired
	private TaskRepositoryJPA repo;
	
	
	
	
	public List<Task> getTasks(){
		return repo.findAll();
	}
}
