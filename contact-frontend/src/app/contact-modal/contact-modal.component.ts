import {Component, Input} from '@angular/core';
import {NgbModal} from "@ng-bootstrap/ng-bootstrap";
import {ContactService} from "../services/contact.service";

@Component({
  selector: 'app-contact-modal',
  templateUrl: './contact-modal.component.html',
  styleUrls: ['./contact-modal.component.sass']
})
export class ContactModalComponent {

  @Input()
  userId: number;

  name: string;
  phone: string;
  email: string;

  constructor(private modalService: NgbModal, private contactService: ContactService) {
  }

  open(content) {
    this.modalService.open(content, {ariaLabelledBy: 'modal-basic-title'}).result.then((result) => {
      this.contactService.createContact(this.userId, {
        name: this.name,
        phoneNumber: this.phone,
        email: this.email
      });
    }, (reason) => {
      console.log(reason);
    });
  }

}
