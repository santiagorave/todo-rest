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
	
	
	public Task newTask(Task task) {
		return repo.save(task);
	}
	
	public void removeTask(int id) {
		repo.deleteById(id);
	}
	public Task updateTask(int id, Task task) {
		Task t = repo.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with id:" + id));
		if(t.getName()!=task.getName()) {
			t.setName(task.getName());
		}
		if(t.getDescription()!=task.getDescription()) {
			t.setDescription(task.getDescription());
		}
		if(t.getTag()!=task.getTag()) {
			t.setTag(task.getTag());
		}
		
		return repo.save(t);
}
	
	public Task updateStatus(int id, boolean completed) {
		Task t = repo.findById(id).orElseThrow(() -> new TaskNotFoundException("Task not found with id:" + id));
		if(completed) {
			t.setStatus("Completed");
		}
		return repo.save(t);
	}
}
