package core;

import enums.HTTPMethod;
import mapper.StubDetailsMapper;
import org.json.JSONArray;
import org.json.JSONObject;
import toolbox.FileUtils;

import java.util.ArrayList;
import java.util.List;

import static com.github.tomakehurst.wiremock.client.WireMock.*;

public class StubbingEngine {
    public static List<StubDetailsMapper> stubList = new ArrayList<>();

    public static void loadStubbingData(String fileName) {
        JSONArray jsonArray = new JSONArray(FileUtils.readFromJSONFile(fileName));

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject jsonObject = jsonArray.getJSONObject(i);
            StubDetailsMapper stubDetailsMapper = new StubDetailsMapper();
            stubDetailsMapper.setAPIURL(jsonObject.getString("URL"));
            switch (jsonObject.getString("HTTPMethod")) {
                case "GET":
                    stubDetailsMapper.setHttpMethod(HTTPMethod.GET);
                    break;
                case "POST":
                    stubDetailsMapper.setHttpMethod(HTTPMethod.POST);
                    break;
                case "DELETE":
                    stubDetailsMapper.setHttpMethod(HTTPMethod.DELETE);
                    break;
                case "PATCH":
                    stubDetailsMapper.setHttpMethod(HTTPMethod.PATCH);
                    break;
                case "PUT":
                    stubDetailsMapper.setHttpMethod(HTTPMethod.PUT);
                    break;
            }
            stubDetailsMapper.setResponseCode(jsonObject.getInt("ResponseCode"));
            if (jsonObject.getBoolean("LoadFromFile")) {
                stubDetailsMapper.setResponse(FileUtils.readFromFile(jsonObject.getString("ResponseFile")));
            } else {
                stubDetailsMapper.setResponse(jsonObject.getString("Response"));
            }
            stubList.add(stubDetailsMapper);
        }
    }

    public static void loadStubs() {
        for (StubDetailsMapper stubDetail : stubList
        ) {
            switch (stubDetail.getHttpMethod()) {
                case GET:
                    stubFor(get(urlEqualTo(stubDetail.getAPIURL()))
                            .willReturn(aResponse()
                                    .withBody(stubDetail.getResponse())
                                    .withStatus(stubDetail.getResponseCode())));
                    break;
                case POST:
                    stubFor(post(urlEqualTo(stubDetail.getAPIURL()))
                            .willReturn(aResponse()
                                    .withBody(stubDetail.getResponse())
                                    .withStatus(stubDetail.getResponseCode())));
                    break;
                case PUT:
                    stubFor(put(urlEqualTo(stubDetail.getAPIURL()))
                            .willReturn(aResponse()
                                    .withBody(stubDetail.getResponse())
                                    .withStatus(stubDetail.getResponseCode())));
                    break;
                case PATCH:
                    stubFor(patch(urlEqualTo(stubDetail.getAPIURL()))
                            .willReturn(aResponse()
                                    .withBody(stubDetail.getResponse())
                                    .withStatus(stubDetail.getResponseCode())));
                    break;
                case DELETE:
                    stubFor(delete(urlEqualTo(stubDetail.getAPIURL()))
                            .willReturn(aResponse()
                                    .withBody(stubDetail.getResponse())
                                    .withStatus(stubDetail.getResponseCode())));
                    break;
            }

        }
    }
}


