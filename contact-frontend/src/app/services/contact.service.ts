import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Contact} from "../entities/contact";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  constructor(private http: HttpClient) {
  }

  public deleteContact(userId: number, id: number) {
    this.http.delete(environment.address + "/user/" + userId + "/contacts/delete/" + id).subscribe(success => {
      console.log(success);
    }, error => {
      console.log(error);
    })
  }

  public createContact(userId: number, contact: Contact) {
    this.http.put(environment.address + "/user/" + userId + "/contacts/add", contact).subscribe(success => {
      console.log(success);
    }, error => {
      console.log(error);
    })
  }

  public editContact(contact: Contact) {
    this.http.post("/contacts/edit", contact).subscribe(success => {
      console.log(success);
    }, error => {
      console.log(error);
    })
  }
}
