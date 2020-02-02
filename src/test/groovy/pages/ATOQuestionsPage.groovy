package pages

import geb.Page

class ATOQuestionsPage extends Page{
    static url =  'https://www.ato.gov.au/Calculators-and-tools/Host/?anchor=STC&amp;anchor=STC#STC/questions'
    static content = {
        heading { $('h1',text: 'Simple tax calculator') }

        incomeYear { $('select',id:'ddl-financialYear') }

        taxableIncome { $( 'input',id:'texttaxIncomeAmt') }

        residencyStatus { $('div',role:'radiogroup') }
//        nonResident { $('input',type:'radio',value:'nonResident') }
//        partYearResident { $('input',type:'radio',value:'partYearResident') }

        numberOfMonths (required:false) { $('select',id:'ddl-residentPartYearMonths').find('option',value:'1') }

        submit { $('button', text:'Submit') }
    }
}
