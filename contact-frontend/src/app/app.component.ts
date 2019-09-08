import {Component, OnInit} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Contact} from "./entities/contact";
import {environment} from "../environments/environment";
import {Observable} from "rxjs";
import {User} from "./entities/user";
import {ContactService} from "./services/contact.service";

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.sass']
})
export class AppComponent implements OnInit {
  title = 'contact-frontend';

  private gridApi;
  private gridColumnApi;

  columnDefs;

  allUsers$: Observable<Array<User>>;
  contactData$: Observable<Array<Contact>>;
  userData$: Observable<User>;
  selectedUserId = 0;

  constructor(private http: HttpClient, private contactService: ContactService) {
    this.columnDefs = [
      {headerName: 'ID', field: 'id', sortable: true, filter: true, hide: true},
      {headerName: "Name", field: "name", sortable: true, filter: true, editable: true},
      {headerName: "Phone #", field: "phoneNumber", sortable: true, filter: true, editable: true},
      {headerName: "Email", field: "email", sortable: true, filter: true, editable: true}
    ];

  }

  ngOnInit(): void {
    this.allUsers$ = this.http.get<Array<User>>(environment.address + "/user");
    this.updateUser();
  }

  updateUser() {
    this.userData$ = this.http.get<User>(environment.address + "/user/" + this.selectedUserId);
    this.contactData$ = this.http.get<Array<Contact>>(environment.address + "/user/" + this.selectedUserId + "/contacts");
  }

  onGridReady(params) {
    this.gridApi = params.api;
    this.gridApi.gridOptions.getRowStyle = function(params) {
      if (params.node.node.getData().unsaved) {
        return { background: 'red' }
      }
    }
    this.gridColumnApi = params.columnApi;
  }

  addRow() {
    const newItem = AppComponent.createNewRowData();
    const res = this.gridApi.updateRowData({add: [newItem]});
  }

  private static createNewRowData() {
    var newData: Contact = {
      name: "REPLACE_ME",
      phoneNumber: "REPLACE_ME",
      email: "REPLACE_ME"
    };
    return newData;
  }

  updateContact() {

  }
}
