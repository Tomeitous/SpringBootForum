package swd20.Forum.domain;


import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonIgnore;






@Entity

public class Thread {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long threadId;
	@NotEmpty
	private String name;
	private Date dateCreated = new Date();
	
	
	@JsonIgnore
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "thread")
	private List<Comment> comment;
	
	@ManyToOne
	@JoinColumn(name = "TopicId")
	private Topic topic;	
	

	public Thread() {}
	
	

	public Thread(String name, Topic topic) {
		super();
		this.name = name;
		this.topic = topic;
	}



	public Long getThreadId() {
		return threadId;
	}



	public void setThreadId(Long threadId) {
		this.threadId = threadId;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public Date getDateCreated() {
		return dateCreated;
	}



	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}



	public List<Comment> getComments() {
		return comment;
	}



	public void setComments(List<Comment> comment) {
		this.comment = comment;
	}



	public Topic getTopic() {
		return topic;
	}



	public void setTopic(Topic topic) {
		this.topic = topic;
	}



	@Override
	public String toString() {
		return "Thread [threadId=" + threadId + ", name=" + name + ", dateCreated=" + dateCreated + ", comment="
				+ comment + ", topic=" + topic + "]";
	}


}
