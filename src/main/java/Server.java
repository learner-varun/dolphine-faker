import core.ServerEngine;
import core.StubbingEngine;


public class Server {
    public static void main(String[] arg) {
        String fileName = "src/main/resources/APIDetails/bookserver.json";
        if (arg.length != 0) {
            fileName = "src/main/resources/APIDetails/" + arg[0];
        }
        ServerEngine.startMockServer();
        StubbingEngine.loadStubbingData(fileName);
        StubbingEngine.loadStubs();
    }


}
