package swd20.Forum.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;






@Entity

public class Topic {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long topicId;
	@NotEmpty
	private String name;
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "topic")
	private List<Thread> thread;
	
	

	public Topic() {}
	
	

	public Topic(String name) {
		super();
		this.name = name;
	}



	public Long getId() {
		return topicId;
	}

	public void setId(Long id) {
		this.topicId = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Thread> getThreads() {
		return thread;
	}

	public void setThreads(List<Thread> thread) {
		this.thread = thread;
	}



	@Override
	public String toString() {
		return "Topic [, name=" + name + "]";
	}
	
	
	
	
}
