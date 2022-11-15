package swd20.Forum.domain;

import java.util.List;

import org.springframework.data.repository.CrudRepository;



public interface TopicRepository extends CrudRepository<Topic, Long>{

	List<Topic> findByName(String name);
	List<Topic> findByTopicId(Long id);
}

