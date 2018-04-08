package com.stackroute.qna.model;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import org.hibernate.annotations.CreationTimestamp;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity

@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@jacksonVersion")
public class Question {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int questionId;
	private String questionTitle;

	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User user;

	@OneToMany(mappedBy = "question")
	//@JsonInclude(JsonInclude.Include.NON_EMPTY)
	 @JsonManagedReference
	private List<Comment> questionComment;

	@CreationTimestamp
	private Date postedOn;

	public List<Comment> getQuestionComment() {
		return questionComment;
	}

	public void setQuestionComment(List<Comment> questionComment) {
		this.questionComment = questionComment;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionTitle() {
		return questionTitle;
	}

	public void setQuestionTitle(String questionTitle) {
		this.questionTitle = questionTitle;
	}

	public Date getPostedOn() {
		return postedOn;
	}

	public void setPostedOn(Date postedOn) {
		this.postedOn = postedOn;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
