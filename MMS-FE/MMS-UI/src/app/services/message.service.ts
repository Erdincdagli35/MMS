import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class MessageService {
  private apiUrl = 'http://localhost:8080/messages'; // Backend API URL

  constructor(private http: HttpClient) {}

  getAllMessages(): Observable<string[]> {
    return this.http.get<Object[]>(this.apiUrl).pipe(
      map(data => data.map(item => item.toString()))
    );
  }
}
