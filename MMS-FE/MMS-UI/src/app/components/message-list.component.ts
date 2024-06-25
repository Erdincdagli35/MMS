import { Component, OnInit } from '@angular/core';
import { MessageService } from '../services/message.service';
import { Subscription } from 'rxjs';

@Component({
  selector: 'app-message-list',
  templateUrl: './message-list.component.html',
  styleUrls: ['./message-list.component.css']
})
export class MessageListComponent implements OnInit {
  messages: string[] = [];
  intervalId: any;
  subscription: Subscription = new Subscription();

  constructor(private messageService: MessageService) {}

 ngOnInit() {
    this.fetchMessages();
    this.intervalId = setInterval(() => {
      this.fetchMessages();
    }, 1000); // 1000 milisaniye (1 saniye) aralıklarla tekrar eder
  }

  fetchMessages() {
    const sub = this.messageService.getAllMessages().subscribe(data => {
      this.messages = data;
    });
    this.subscription.add(sub);
  }

  ngOnDestroy() {
    if (this.intervalId) {
      clearInterval(this.intervalId); // Bileşen yok edildiğinde interval'ı temizler
    }
    this.subscription.unsubscribe(); // Tüm abonelikleri iptal eder
  }
}
