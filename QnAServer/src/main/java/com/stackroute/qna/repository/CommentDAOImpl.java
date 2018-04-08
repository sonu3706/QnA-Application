package com.stackroute.qna.repository;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.stackroute.qna.exceptions.CommentNotFoundException;
import com.stackroute.qna.model.Comment;
import com.stackroute.qna.model.User;

@Transactional
@Repository
public class CommentDAOImpl implements CommentDAO {

 @PersistenceContext
 private EntityManager entityManager;

 public EntityManager getEntityManager() {

  return entityManager;
 }

 public void setEntityManager(EntityManager entityManager) {
  this.entityManager = entityManager;
 }

 @Override
 public boolean saveComment(Comment comment) {
  entityManager.persist(comment);
  return true;
 }

 @Override
 public Comment updateComment(Comment comment) {

  System.out.println(333);
  Comment updatedComment = entityManager.merge(comment);


  return updatedComment;
 }

 @Override
 public boolean deleteComment(Long commentId) throws CommentNotFoundException {
  Comment comment = entityManager.find(Comment.class, commentId);

  if (comment != null) {
   entityManager.remove(comment);
   return true;
  } else {
   throw new CommentNotFoundException("Unable to delete comment");
  }

 }

 @Override
 public Comment getCommentById(Long commentId) {
  Comment comment = entityManager.find(Comment.class, commentId);
  return comment;
 }

 @Override
 public List < Comment > getAllComments() {
  // TODO Auto-generated method stub
  return null;
 }

 @Override
 public boolean deleteAllByQuestionId(int questionId) {
  System.out.println(3);
  Query query1 = entityManager.createQuery("from Comment where question_id =" + questionId);
  List set = query1.getResultList();
  System.out.println(set.isEmpty());
  if (!set.isEmpty()) {

   Query query = entityManager.createQuery("delete from Comment where question_id=" + questionId);
   query.executeUpdate();
   return true;

  } else {
   System.out.println(12345);
   return false;
  }

 }

 @Override
 public List < Comment > getAllCommentByQuestionId(int questionId) {

  return entityManager.createQuery("From Comment where question_id=" + questionId).getResultList();
 }

 @Override
 public List < Comment > getAllCommentByUserId(String userId) {

  return entityManager.createQuery("From Comment where user_id=" + userId).getResultList();
 }

}