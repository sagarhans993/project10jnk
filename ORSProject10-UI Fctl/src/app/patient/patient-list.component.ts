import { Component, OnInit } from '@angular/core';

import { ActivatedRoute } from '@angular/router';
import { BaseListCtl } from 'src/app/base-list.component';
import { ServiceLocatorService } from 'src/app/service-locator.service';

@Component({
  selector: 'app-Patient-list',
  templateUrl: './Patient-list.component.html',
  styleUrls: ['./Patient-list.component.css']
})
export class PatientListComponent extends BaseListCtl implements OnInit {
  myKey = "";

  public form = {
    error: false,
    message: null,
    preload: [],
    data: { id: null },
    inputerror: {},
    searchParams: {},
    searchMessage: null,
    list: [],
    pageNo: 0
  };

  base64Data: any;
  retrieveResonse: any;
  message: string;
  isValidexperienceInput: boolean = true; // Property to track validity of cost input
  isValidtitleInput: boolean = true; // Property to track validity of description input

  constructor(public locator: ServiceLocatorService, public route: ActivatedRoute) {
    super(locator.endpoints.PATIENT, locator, route);
  }
  
}
