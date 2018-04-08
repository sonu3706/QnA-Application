import { Component, OnInit, Input } from '@angular/core';
import { PageEvent } from '@angular/material';

@Component({
  selector: 'app-querycard',
  templateUrl: './querycard.component.html',
  styleUrls: ['./querycard.component.css']
})
export class QuerycardComponent implements OnInit {


  query: object[] = [
    {
      'question': 'What is real meaning of BHP in vehicals ?',
      'PostedBy': 'Chandan Mishra',
      'Date': '23/01/2018'
    },

    {
      'question': 'What is real meaning of Slipper clutch and how does it work ?',
      'PostedBy': 'Sonu Mishra',
      'Date': '19/01/2018'
    },

    {
      'question': 'How does it feel when you get to know about 4days week off ?',
      'PostedBy': 'Chandan Mishra',
      'Date': '23/01/2018'
    },

    {
      'question': 'How can I bake cake in pressure cooker ?',
      'PostedBy': 'Anup Sinha',
      'Date': '03/01/2018'
    },

    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    },
    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    },
    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    },
    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    },
    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    },
    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    },
    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    },
    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    },
    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    },
    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    },
    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    },
    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    },
    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    },
    {
      'question': 'How to deal with sadness in life ?',
      'PostedBy': 'Ankit ',
      'Date': '10/01/2018'
    }

  ];

  constructor() { }

  ngOnInit() {
  }

}
