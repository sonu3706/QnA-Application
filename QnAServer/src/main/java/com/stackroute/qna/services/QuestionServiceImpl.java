package com.stackroute.qna.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.stackroute.qna.model.Question;
import com.stackroute.qna.repository.QuestionDAO;

@Service
public class QuestionServiceImpl implements QuestionService {

 @Autowired
 private QuestionDAO questionDAO;

 @Override
 public boolean saveQuestion(Question ques) {
  System.out.println("2222");
  return questionDAO.saveQuestion(ques);
 }

 @Override
 public boolean updateQuestion(Question ques) {

  return questionDAO.updateQuestion(ques);

 }

 @Override
 public boolean deleteQuestion(int quesId) {

  System.out.println(222);
  return questionDAO.deleteQuestion(quesId);
 }

 @Override
 public Question getQuestionById(int questionId) {
  System.out.println("12");
  return questionDAO.getQuestionById(questionId);
 }

 @Override
 public List < Question > getAllQuestion() {
  System.out.println(1234);
  List ll = questionDAO.getAllQuestions();
  //		return questionDAO.getAllQuestions();
  return ll;
 }

}