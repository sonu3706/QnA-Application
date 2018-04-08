package com.stackroute.qna.services;

import java.util.List;
import java.util.Set;

import com.stackroute.qna.exceptions.CommentNotFoundException;
import com.stackroute.qna.model.Comment;
import com.stackroute.qna.model.User;

public interface CommentService {

	public boolean saveComment(Comment comment);

	public Comment updateComment(Comment comment);

	public boolean deleteComment(Long commentId) throws CommentNotFoundException;

	public List<Comment> getAllComments();
	
	public Comment getCommentById(Long id);

	public boolean deleteAllByQuestionId(int questionId);
	
	public List<Comment> getAllCommentByQuestionId(int questionId);
	
	public List<Comment> getAllCommentByUserId(String userId);

}
