package pages

import geb.Page
import geb.navigator.Navigator

class RequestDemoPage extends Page{
    static at = { waitFor { heading.displayed } }
    static content = {
        heading { $('header',class:'content-header').find('h1',text:'Request a LifeView demo') }
        name { $('div',class:'js-wffm-form').find('div',class:'form-group',0).find('input',1) }
        company { $('div',class:'js-wffm-form').find('div',class:'form-group',1).find('input',1) }
        email { $('div',class:'js-wffm-form').find('div',class:'form-group',2).find('input',1) }
        phone { $('div',class:'js-wffm-form').find('div',class:'form-group',3).find('input',1) }
        prefContactDate { $('div',class:'js-wffm-form').find('div',class:'form-group',4).find('input',1) }
        contactTimeAM { $('input',value:'AM') }
        requestDetails { $('textarea',class:'form-control') }
    }
}
