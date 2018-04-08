package com.stackroute.qna.services;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.qna.exceptions.CommentNotFoundException;
import com.stackroute.qna.model.Comment;
import com.stackroute.qna.model.User;
import com.stackroute.qna.repository.CommentDAO;

@Service
public class CommentServiceImpl implements CommentService {

 @Autowired
 private CommentDAO commentDAO;

 @Override
 public boolean saveComment(Comment comment) {
  commentDAO.saveComment(comment);
  return true;
 }

 @Override
 public Comment updateComment(Comment comment) {
  System.out.println(222);
  return commentDAO.updateComment(comment);
 }

 @Override
 public boolean deleteComment(Long commentId) throws CommentNotFoundException {
  boolean status = commentDAO.deleteComment(commentId);
  if (status == true) {
   return true;
  } else {
   return false;
  }
 }

 @Override
 public List < Comment > getAllComments() {
  // TODO Auto-generated method stub
  return null;
 }

 @Override
 public boolean deleteAllByQuestionId(int questionId) {
  System.out.println(2);
  boolean status = commentDAO.deleteAllByQuestionId(questionId);
  if (status) {
   return true;
  } else {
   return false;
  }
 }

 @Override
 public Comment getCommentById(Long id) {
  Comment comment = commentDAO.getCommentById(id);
  return comment;
 }

 @Override
 public List < Comment > getAllCommentByQuestionId(int questionId) {

  return commentDAO.getAllCommentByQuestionId(questionId);
 }

 @Override
 public List < Comment > getAllCommentByUserId(String userId) {

  return commentDAO.getAllCommentByUserId(userId);
 }

}