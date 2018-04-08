import { Component, OnInit, Input } from '@angular/core';
import { Router } from '@angular/router/src/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  arr: object[] = [
    {
      "topic": "JAVA...",
      "desc": "topic for java queries",
      "img": "https://vignette.wikia.nocookie.net/logopedia/images/6/6a/Java-logo.jpg/revision/latest/scale-to-width-down/640?cb=20150321072347",
      "logo": "java logo",
      "contentText": "Total number of questions :",
      "contentValue": "12"
    },
    {
      "topic": "JAVASCRIPT...",
      "desc": "topic for javascript queries",
      "img": "https://www.planet-source-code.com/vb/2010Redesign/images/LangugeHomePages/Javascript.png",
      "logo": "javascript logo",
      "contentText": "Total number of questions :",
      "contentValue": "12"
    },
    {
      "topic": "PYTHON...",
      "desc": "topic for python queries",
      "img": "http://www.acsce.edu.in/blog/wp-content/uploads/2017/03/python-logo.jpg",
      "logo": "Python logo",
      "contentText": "Total number of questions :",
      "contentValue": "12"
    },
    {
      "topic": "PYTHON...",
      "desc": "topic for python queries",
      "img": "http://www.acsce.edu.in/blog/wp-content/uploads/2017/03/python-logo.jpg",
      "logo": "Python logo",
      "contentText": "Total number of questions :",
      "contentValue": "12"
    },
    {
      "topic": "PYTHON...",
      "desc": "topic for python queries",
      "img": "https://vignette.wikia.nocookie.net/logopedia/images/6/6a/Java-logo.jpg/revision/latest/scale-to-width-down/640?cb=20150321072347",
      "logo": "Python logo",
      "contentText": "Total number of questions :",
      "contentValue": "12"
    },
    {
      "topic": "PYTHON...",
      "desc": "topic for python queries",
      "img": "https://vignette.wikia.nocookie.net/logopedia/images/6/6a/Java-logo.jpg/revision/latest/scale-to-width-down/640?cb=20150321072347",
      "logo": "Python logo",
      "contentText": "Total number of questions :",
      "contentValue": "12"
    }
  ];

  // count: number[] = [1, 2, 3, 4, 5];

  // question: object[] = [
  //   {
  //     'question': 'What is real meaning of BHP in vehicals ?',
  //     'PostedBy': 'Chandan Mishra',
  //     'Date': '23/01/2018'
  //   },

  //   {
  //     'question': 'What is real meaning of Slipper clutch and how does it work ?',
  //     'PostedBy': 'Sonu Mishra',
  //     'Date': '19/01/2018'
  //   },

  //   {
  //     'question': 'How does it feel when you get to know about 4days week off ?',
  //     'PostedBy': 'Chandan Mishra',
  //     'Date': '23/01/2018'
  //   },

  // ];

  constructor( ) {
  }

  ngOnInit() {
  }


}
