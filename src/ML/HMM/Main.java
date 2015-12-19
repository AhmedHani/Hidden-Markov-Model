package ML.HMM;

import javafx.util.Pair;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;

import java.util.Hashtable;
import org.json.*;

public class Main {
    public static void main(String[] args) throws JSONException {
        String data = readFile("G:\\Github Repositories\\Hidden-Markov-Model\\Resources\\test_HMM.json");
        JSONObject obj = new JSONObject(data);
        String name = obj.getJSONObject("modelInfo").getString("name");
        JSONArray arr = obj.getJSONArray("model_data");

    }

    public static String readFile(String filename) {
        String result = "";
        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                line = br.readLine();
            }
            result = sb.toString();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
