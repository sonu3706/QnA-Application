package com.stackroute.qna.controllers;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

import com.stackroute.qna.model.Question;
import com.stackroute.qna.services.CommentService;
import com.stackroute.qna.services.QuestionService;

@RestController
@RequestMapping("QnA/question/")
public class QuestionController {

 @Autowired
 private QuestionService questionService;
 @Autowired
 private CommentService commentService;
 HashMap < String, String > map = new HashMap < > ();

 /* <===========Post a Question============> */
 @PostMapping("/postQues")
 public ResponseEntity < ? > saveQuestion(@RequestBody Question question) {

  if (question != null) {
   System.out.println(question.getUser());
   System.out.println(question.getQuestionTitle());
   questionService.saveQuestion(question);
   map.put("success", "true");
   map.put("message", "question posted successfully");
   return new ResponseEntity < HashMap < String, String >> (map, HttpStatus.OK);

  } else {
   map.put("success", "false");
   map.put("message", "Error in posting question");
   return new ResponseEntity < HashMap < String, String >> (map, HttpStatus.BAD_REQUEST);
  }

 }

 /* <===========Delete a Question by ID============> */
 @DeleteMapping("/delete/{id}")
 public ResponseEntity < ? > deleteQuestion(@PathVariable("id") int id) {

  if (commentService.deleteAllByQuestionId(id)) {
   questionService.deleteQuestion(id);
   map.put("success", "true");
   map.put("message", "Question deleted successfully");
   return new ResponseEntity < HashMap < String, String >> (map, HttpStatus.ACCEPTED);
  } else {
   questionService.deleteQuestion(id);
   map.put("success", "false");
   map.put("message", "Error in deleting question");
   return new ResponseEntity < HashMap < String, String >> (map, HttpStatus.CONFLICT);
  }

 }

 /* <===========Update a Question by ID============> */

 @PutMapping("/update/{id}")
 public ResponseEntity < ? > updateQuestion(@RequestBody Question question, @PathVariable() int id) {

  if (question != null) {
   Question ques = questionService.getQuestionById(id);

   if (ques != null) {

    System.out.println(ques.getPostedOn());
    ques.setQuestionTitle(question.getQuestionTitle());
    ques.setUser(question.getUser());
    ques.setPostedOn(ques.getPostedOn());
    questionService.updateQuestion(ques);
    map.put("success", "true");
    map.put("message", "updated successfully");
    return new ResponseEntity < HashMap < String, String >> (map, HttpStatus.OK);
   } else {
    map.put("success", "false");
    map.put("message", "error in updating question");
    return new ResponseEntity < HashMap < String, String >> (map, HttpStatus.NOT_FOUND);
   }
  } else {
   map.put("success", "false");
   map.put("message", "error in updating question");
   return new ResponseEntity < HashMap < String, String >> (map, HttpStatus.CONFLICT);
  }
 }

 /* <===========GetAll Question============> */
 @GetMapping("/getall")
 public ResponseEntity < List < Question >> getAllQuestion() {

  List < Question > questions = questionService.getAllQuestion();

  return new ResponseEntity < List < Question >> (questions, HttpStatus.OK);
 }

 /* <===========Get Question by ID============> */
 @GetMapping("/getques/{id}")
 public ResponseEntity < ? > getQuestionById(@PathVariable() int id) {
  System.out.println(111);
  Question ques = questionService.getQuestionById(id);

  return new ResponseEntity < Question > (ques, HttpStatus.OK);
 }

 /* <===========Get all Question by UserID============> */

 public ResponseEntity < ? > getQuestionByUserId(@PathVariable() String id) {

  return new ResponseEntity < > (HttpStatus.OK);
 }

}