package pages

import geb.Page

class LifeViewPage extends Page{
    static at = { waitFor { pageBreadCrumbs.displayed } }
    static content = {
        pageBreadCrumbs { $('ul',itemprop: 'breadcrumb') }
        requestDemoButton { $('span',class:'cta',text:'Request a demo') }
    }
}
