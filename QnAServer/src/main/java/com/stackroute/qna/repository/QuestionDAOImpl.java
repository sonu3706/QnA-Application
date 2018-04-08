package com.stackroute.qna.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;
import com.stackroute.qna.model.Question;

@Transactional
@Repository
public class QuestionDAOImpl implements QuestionDAO {

 @PersistenceContext
 private EntityManager entityManager;

 public EntityManager getEntityManager() {

  return entityManager;
 }

 public void setEntityManager(EntityManager entityManager) {
  this.entityManager = entityManager;

 }

 @Override
 public boolean saveQuestion(Question question) {
  System.out.println("3333");
  entityManager.persist(question);
  return true;
 }

 @Override
 public boolean updateQuestion(Question question) {
  entityManager.merge(question);
  return true;
 }

 @Override
 public boolean deleteQuestion(int questionId) {
  System.out.println(333);
  Question question = entityManager.find(Question.class, questionId);
  entityManager.remove(question);
  return true;
 }

 @Override
 public Question getQuestionById(int questionId) {
  System.out.println("123");
  Question ques = entityManager.find(Question.class, questionId);
  // Query query = entityManager.createNamedQuery("from Question where
  // question_id="+questionId);
  // Question ques = query.
  return ques;
 }

 @Override
 public List < Question > getAllQuestions() {

  return entityManager.createQuery("From Question").getResultList();
 }

}