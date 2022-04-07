import { Component } from '@angular/core';

import { Login } from '../videoclub-login';

@Component({
    selector: 'app-videoclub-login',
    templateUrl: './videoclub-login.component.html',
    styleUrls: ['./videoclub-login.component.css']
})

export class VideoClubComponent{
    model = new Login('', '')

    showFormControls(form: any) {
        return form && form.controls.name && form.controls.name.value;
    }
}

