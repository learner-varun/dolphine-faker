package toolbox;

import org.json.JSONArray;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileUtils {
    static JSONArray jsonArray;

    public static JSONArray readFromJSONFile(String fileName) {
        File f = new File(fileName);
        if (f.exists()) {
            try {
                jsonArray = new JSONArray(new String(Files.readAllBytes(Paths.get(fileName))));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return jsonArray;
    }

    public static String readFromFile(String fileName) {


        byte[] s = new byte[0];
        try {
            s = Files.readAllBytes(Paths.get(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new String(s);
    }

}
