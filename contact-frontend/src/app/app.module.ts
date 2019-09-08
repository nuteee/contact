import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {HttpClientModule} from "@angular/common/http";
import {AgGridModule} from "ag-grid-angular";
import {NgSelectModule} from "@ng-select/ng-select";
import {FormsModule} from "@angular/forms";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {ContactModalComponent} from './contact-modal/contact-modal.component';
import {ContactService} from "./services/contact.service";

@NgModule({
  declarations: [
    AppComponent,
    ContactModalComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    NgSelectModule,
    AgGridModule.withComponents([])
  ],
  providers: [ContactService],
  bootstrap: [AppComponent]
})
export class AppModule {
}
