package com.stackroute.qna.services;

import java.util.List;

import com.stackroute.qna.model.Question;

public interface QuestionService {

	public boolean saveQuestion(Question ques);

	public boolean updateQuestion(Question ques);

	public boolean deleteQuestion(int quesId);

	public Question getQuestionById(int questionId);

	public List<Question> getAllQuestion();

}
