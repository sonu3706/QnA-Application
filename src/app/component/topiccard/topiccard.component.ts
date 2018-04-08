import { Component, OnInit, Input } from '@angular/core';

@Component({
  selector: 'app-topiccard',
  templateUrl: './topiccard.component.html',
  styleUrls: ['./topiccard.component.css']
})
export class TopiccardComponent implements OnInit {

  @Input() object;
  a: object;
  constructor() {
   }

  ngOnInit() {
    this.a = this.object;
  }


}
