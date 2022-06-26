package core;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.github.tomakehurst.wiremock.http.Request;
import com.github.tomakehurst.wiremock.http.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static constants.Constants.MOCK_PORT;
import static constants.Constants.MOCK_URL;

public class ServerEngine {
    public static WireMockServer wireMockServer;
    public static void startMockServer() {
        wireMockServer = new WireMockServer(MOCK_PORT);
        wireMockServer.addMockServiceRequestListener(
                ServerEngine::requestReceived);
        wireMockServer.start();
        WireMock.configureFor(MOCK_URL, wireMockServer.port());
    }

    public static void stopMockServer() {
        wireMockServer.stop();
    }

    public static void restartMockServer() {
        wireMockServer.resetAll();
    }

    public static boolean getServerStatus() {
        return wireMockServer.isRunning();
    }

    public static String getServerURL() {
        return wireMockServer.baseUrl();
    }

    public static int getServerPort() {
        return wireMockServer.port();
    }

    protected static void requestReceived(Request inRequest,Response inResponse) {
        System.out.println("****************** REQUEST DETAILS **********************");
        System.out.println("WireMock request at URL: "+inRequest.getAbsoluteUrl());
        System.out.println("WireMock request headers: "+ inRequest.getHeaders());
        System.out.println("WireMock response body: "+ inResponse.getBodyAsString());
        System.out.println("WireMock response headers: "+ inResponse.getHeaders());
        System.out.println("********************** END ******************************");
    }
}

