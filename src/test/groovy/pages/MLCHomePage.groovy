package pages

import geb.Page
import geb.navigator.Navigator

class MLCHomePage extends Page{

    static url =  'https://www.mlcinsurance.com.au'
    static content = {
        searchButton (required:false) { $('button','data-popover-id':'global-search') }
        searchInputField { $('input',class:'js-autocomplete-input') }
        lifeViewink { $('span',class:'autocomplete-results-item-title',0) }
    }
    def navigateToMenu(Navigator menu) {
        waitFor(30) { menu.displayed }
        interact {
            moveToElement(menu)
        }
        true
    }

    def navigateToSubmenu(Navigator submenu) {
        waitFor(30) { submenu.displayed }
        submenu.click()
        true
    }
}
