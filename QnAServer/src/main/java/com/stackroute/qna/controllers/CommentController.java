package com.stackroute.qna.controllers;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.stackroute.qna.exceptions.CommentNotFoundException;
import com.stackroute.qna.model.Comment;
import com.stackroute.qna.services.CommentService;

@RestController
@RequestMapping("/comment")
public class CommentController {

 @Autowired
 private CommentService commentService;
 HashMap < String, String > map = new HashMap < > ();

 /* <===========Post Comment==============> */
 @PostMapping("/post")
 public ResponseEntity < Comment > postComment(@RequestBody Comment comment) throws CommentNotFoundException {

  if (comment != null) {

   boolean status = commentService.saveComment(comment);
   if (status == true) {
    return new ResponseEntity < Comment > (comment, HttpStatus.OK);
   } else {
    throw new CommentNotFoundException("Error in posting your comments");
   }
  } else {
   return new ResponseEntity < Comment > (HttpStatus.CONFLICT);
  }

 }

 /* <===========Delete Comment by id==============> */

 @DeleteMapping("/delete/{id}")
 public ResponseEntity < ? > deleteComment(@PathVariable Long id) {

  if (id != 0) {
   try {
    commentService.deleteComment(id);
   } catch (CommentNotFoundException e) {
    e.printStackTrace();
    map.put("success", "false");
    map.put("message", "Unable to delete message");
    return new ResponseEntity < HashMap < String, String >> (map, HttpStatus.CONFLICT);
   }
   map.put("success", "true");
   map.put("message", "Comment deleted successfully");
   return new ResponseEntity < HashMap < String, String >> (map, HttpStatus.OK);
  } else {
   map.put("success", "false");
   map.put("message", "Error in deleting comment");
   return new ResponseEntity < HashMap < String, String >> (map, HttpStatus.CONFLICT);
  }

 }

 /* <===========Update Comment by id==============> */

 @PutMapping("/update/{id}")
 public ResponseEntity < Comment > updateComment(@RequestBody Comment comment, @PathVariable Long id) {

  if (comment != null) {

   Comment cmt = commentService.getCommentById(id);
   if (cmt != null) {
    cmt.setCommentContent(comment.getCommentContent());
    cmt.setCommentDate(cmt.getCommentDate());
    cmt.setCommentedBy(comment.getCommentedBy());
    cmt.setQuestion(comment.getQuestion());
    cmt = commentService.updateComment(cmt);

    return new ResponseEntity < Comment > (cmt, HttpStatus.OK);
   } else {
    return new ResponseEntity < Comment > (HttpStatus.CONFLICT);
   }
  } else {
   return new ResponseEntity < Comment > (HttpStatus.CONFLICT);
  }

 }

 /* <===========Get all Comments==============> */

 @GetMapping("/getcomments")
 public ResponseEntity < ? > getAllComment() {

  return new ResponseEntity < > (HttpStatus.OK);
 }

 /* <===========Get Comments for specific question by quesId==============> */

 @GetMapping("/getcommentbyques/{id}")
 public ResponseEntity < List < Comment >> getAllCommentByQuestionId(@PathVariable int id) {
  List < Comment > comments = commentService.getAllCommentByQuestionId(id);
  return new ResponseEntity < List < Comment >> (comments, HttpStatus.OK);
 }

 /* <===========Get all comments for a specific user by User Id==============> */

 @GetMapping("/getcommentbyuserid/{id}")
 public ResponseEntity < List < Comment >> getAllCommentByUserId(@PathVariable("id") String userId) {

  System.out.println("userId:::" + userId);
  List < Comment > userComment = commentService.getAllCommentByUserId(userId);
  return new ResponseEntity < List < Comment >> (userComment, HttpStatus.OK);
 }
}