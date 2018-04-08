package com.stackroute.qna.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@JsonIdentityInfo(generator = ObjectIdGenerators.IntSequenceGenerator.class, property = "@jacksonVersion")
public class Comment {

 @Id
 @GeneratedValue(strategy = GenerationType.AUTO)
 private Long commentId;
 private String commentContent;

 @ManyToOne
 @JoinColumn(name = "user_id", nullable = false)
 private User commentedBy;

 @CreationTimestamp
 private Date commentDate;

 @ManyToOne
 @JoinColumn(name = "question_id", nullable = false)
 private Question question;

 public Long getCommentId() {
  return commentId;
 }

 public void setCommentId(Long commentId) {
  this.commentId = commentId;
 }

 public String getCommentContent() {
  return commentContent;
 }

 public void setCommentContent(String commentContent) {
  this.commentContent = commentContent;
 }

 public User getCommentedBy() {
  return commentedBy;
 }

 public void setCommentedBy(User commentedBy) {
  this.commentedBy = commentedBy;
 }

 public Date getCommentDate() {
  return commentDate;
 }

 public void setCommentDate(Date commentDate) {
  this.commentDate = commentDate;
 }

 public Question getQuestion() {
  return question;
 }

 public void setQuestion(Question question) {
  this.question = question;
 }

}