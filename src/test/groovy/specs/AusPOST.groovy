package specs
//------------------------------------------------------------------------
//requirement
//For the API test, please use the Australia Post API to calculate shipping costs for parcels of
//different weights to at least three countries.
//In your test add what you believe should be verified/checked as part of the API.
//------------------------------------------------------------------------
import module.common
import geb.spock.GebReportingSpec


class AusPOST extends GebReportingSpec {

    def 'Call AusPostAPI' () {
        def response
        when: 'for NZ'
        response=common.getAPIResponse('NZ')

        then: 'verify api status'
        assert response.status == 200
        println ('AUS API called for delivery to NZ successfully')

        when: 'for NZ'
        response=common.getAPIResponse('US')

        then: 'verify api status'
        assert response.status == 200
        println ('AUS API called for delivery to USA successfully')

        when: 'for NZ'
        response=common.getAPIResponse('IN')

        then: 'verify api status'
        assert response.status == 200
        println ('AUS API called for delivery to India successfully')

       }

    }




