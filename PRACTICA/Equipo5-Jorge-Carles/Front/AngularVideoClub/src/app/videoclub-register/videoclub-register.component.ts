import { Component } from '@angular/core';

import { Register } from '../videoclub-register';

@Component({
    selector: 'app-videoclub-register',
    templateUrl: './videoclub-register.component.html',
    styleUrls: ['./videoclub-register.component.css']
})

export class VideoClubRegsiterComponent{
    model = new Register('', '', '', '')

    showFormControls(form: any) {
        return form && form.controls.name && form.controls.name.value;
    }
}