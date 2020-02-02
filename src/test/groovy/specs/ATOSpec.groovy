package specs
//------------------------------------------------------------------------
//requirements
//On the ATO page https://www.ato.gov.au/Calculators-and-tools/Host/?anchor=STC&anchor=STC#STC/questions
//Navigate to the page
//Create a test to verify calculated tax for at least three combinations of assessment year, Income and residency status
//------------------------------------------------------------------------
import geb.spock.GebReportingSpec
import pages.ATOQuestionsPage
import pages.ATOResultsPage
import spock.lang.*

class ATOSpec extends GebReportingSpec {
    @Unroll
    def 'Verify ATO Estimated tax'() {
        when: 'open ATO page'
        ATOQuestionsPage atoQuestionsPage = to ATOQuestionsPage

        then: 'wait for ATO page is loaded'
        waitFor { atoQuestionsPage.heading.displayed }

        when: 'Enter data and submit'

        atoQuestionsPage.incomeYear.find('option',value:year).click()
        atoQuestionsPage.taxableIncome << taxincome
        atoQuestionsPage.residencyStatus.find('span',text:residency).click()
        if (residency == 'Part-year resident') {
            waitFor { atoQuestionsPage.numberOfMonths.displayed }
            atoQuestionsPage.numberOfMonths.click()
        }
        atoQuestionsPage.submit.click()
        then: 'verify the estimated tax amount'
        ATOResultsPage atoResultsPage = at ATOResultsPage
        atoResultsPage.resultText.displayed
        atoResultsPage.resultVal.text() == estimatedTax

        sleep(3000)

        where: 'verify for 3 combinations'
        year   | taxincome  | residency                   |estimatedTax
        '2019' | '160000'   |'Resident for full year'     |'$46,697.00'
        '2018' | '140000'   |'Non-resident for full year' |'$47,885.00'
        '2017' | '120000'   |'Part-year resident'         |'$32,856.79'
    }

}
