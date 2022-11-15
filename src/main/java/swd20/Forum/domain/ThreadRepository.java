package swd20.Forum.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface ThreadRepository extends CrudRepository<Thread, Long> {
	
	List<Thread> findByName(String name);
	List<Thread> findByThreadId(Long ThreadId);

}
