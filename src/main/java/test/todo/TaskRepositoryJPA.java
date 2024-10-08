package test.todo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepositoryJPA extends JpaRepository<Task,Integer>{

}
