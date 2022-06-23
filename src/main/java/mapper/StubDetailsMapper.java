package mapper;

import enums.HTTPMethod;

public class StubDetailsMapper {

    private HTTPMethod httpMethod;
    private String APIURL;
    private int responseCode;
    private String response;

    public HTTPMethod getHttpMethod() {
        return httpMethod;
    }

    public void setHttpMethod(HTTPMethod httpMethod) {
        this.httpMethod = httpMethod;
    }

    public String getAPIURL() {
        return APIURL;
    }

    public void setAPIURL(String APIURL) {
        this.APIURL = APIURL;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }
}
