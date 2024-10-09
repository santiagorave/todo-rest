package test.todo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tasks")
@CrossOrigin(origins = {"http://localhost:5173/"})
public class TaskController {

	@Autowired
	TaskService service;
	
	
	@GetMapping
	public List<Task> getTasks() {
		return service.getTasks();
	}
	
	@PostMapping
	public Task addTask(@RequestBody Task task) {
		return service.newTask(task);
	}
	
	@DeleteMapping("/{id}")
	public void removeTask(@PathVariable int id) {
		service.removeTask(id);
	}
	
	@PutMapping("/{id}")
	public Task updateTask(@PathVariable int id, @RequestBody Task task) {
		return service.updateTask(id,task);
	}
	
	
	@PatchMapping("/{id}/status")
	public Task patchTasks(@PathVariable int id, @RequestBody boolean status) {
		return service.updateStatus(id,status);
	}
	
	
	
	
}
