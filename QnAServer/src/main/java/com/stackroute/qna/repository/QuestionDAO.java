package com.stackroute.qna.repository;

import java.util.List;

import com.stackroute.qna.model.Question;

public interface QuestionDAO {
	public boolean saveQuestion(Question question);

	public boolean updateQuestion(Question question);

	public boolean deleteQuestion(int questionId);

	public Question getQuestionById(int questionId);

	public List<Question> getAllQuestions();

}
