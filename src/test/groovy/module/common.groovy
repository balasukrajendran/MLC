package module

import groovyx.net.http.RESTClient

class common {

    static openRestclient(String hostname) {
        RESTClient restClient = new RESTClient(hostname, 'JSON')
        restClient
    }

    static getAPIResponse(String country) {

          def request = 'https://digitalapi.auspost.com.au/postage/v4/catalogue/service.json?category=INTERNATIONAL&from=AU&to='+ country
          RESTClient restClient = openRestclient(request)
          def response = restClient.get(
          path: request,
          headers: ['Auth-key': '62b9613ddab3f8cdaf89c47c0234729e'],
          )
        assert response.status==200
        response
    }
    // def response = restClient.get(
}
