package specs
//------------------------------------------------------------------------
//requirement:
//Automate the following scenario on https://www.mlcinsurance.com.au/
//Search for 'Lifeview' on the Homepage
//Click on 'Lifeview' link
//In the 'LifeView' page, verify the bread crumbs on the top is 'Home Partnering with us Superannuation funds LifeView'
//Click on 'Request a demo' button
//Enter relevant data in the form
//DO NOT SUBMIT THE FORM
//------------------------------------------------------------------------
import geb.spock.GebReportingSpec
import pages.LifeViewPage
import pages.MLCHomePage
import pages.RequestDemoPage


class MLCSpec extends GebReportingSpec {

    def 'Verify MLC page' (){
        when: 'open homepage'
        MLCHomePage mlcHomePage = to MLCHomePage
        then: 'wait for homepage is loaded'
        waitFor (10) { mlcHomePage.searchButton.displayed }

        when: 'user enters a search string and select from list'
        mlcHomePage.searchButton.click()
        mlcHomePage.searchInputField << 'Lifeview'
        waitFor(30) { mlcHomePage.lifeViewink.displayed }
        mlcHomePage.navigateToMenu(mlcHomePage.lifeViewink)
        mlcHomePage.navigateToSubmenu(mlcHomePage.lifeViewink)

        then: 'Lifeview page should be displayed'
        LifeViewPage lifeViewPage = at LifeViewPage

        and: 'verify breadcrumbs are displayed'
        lifeViewPage.pageBreadCrumbs.text() == 'Home Partnering with us Superannuation funds LifeView'

        when: 'user clicks on RequestDemo button'
        lifeViewPage.requestDemoButton.click()
        then: 'RequestDemo page should be displayed'
        RequestDemoPage requestDemoPage = at RequestDemoPage

        when: 'user enters data on Request demo page fields'
            requestDemoPage.name.click()
            requestDemoPage.name << 'testname'
            requestDemoPage.company << 'testcompany'
            requestDemoPage.email << 'testemail@test.com'
            requestDemoPage.phone << '04901111111'
            requestDemoPage.contactTimeAM.click()
            requestDemoPage.requestDetails << 'as per requirement'
            sleep(3000)
        then: 'verify data in all fields'
            !requestDemoPage.name.isEmpty()
            !requestDemoPage.name.isEmpty()
            !requestDemoPage.company.isEmpty()
            !requestDemoPage.email.isEmpty()
            !requestDemoPage.phone.isEmpty()
            !requestDemoPage.prefContactDate.isEmpty()
            !requestDemoPage.requestDetails.isEmpty()
    }
}
