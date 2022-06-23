package core;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import static constants.Constants.MOCK_PORT;
import static constants.Constants.MOCK_URL;

public class ServerEngine {
    public static WireMockServer wireMockServer;

    public static void startMockServer() {
        wireMockServer = new WireMockServer(MOCK_PORT);
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
}

