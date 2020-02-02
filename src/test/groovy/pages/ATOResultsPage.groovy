package pages

import com.sun.jmx.snmp.IPAcl.Host
import geb.Page

class ATOResultsPage extends Page{

    static at =  { waitFor { heading.displayed }}
    static content = {
        heading { $('div',class:'alert-attention').find('h2',text:'Result') }
        resultText { $('div',class:'white-block',text:contains('The estimated tax on your taxable income is '))}
        resultVal { $('div',class:'white-block').find('span') }
    }
}
