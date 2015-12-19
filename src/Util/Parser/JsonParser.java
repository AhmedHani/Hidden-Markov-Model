package Util.Parser;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.FileReader;

/**
 * Created by Ahmed Hani Ibrahim on 12/19/2015.
 */
public class JsonParser {
    private String data;
    private JSONObject jsonObject;

    public JsonParser(String filepath) {
        this.data = this.readFile(filepath);
        try {
            this.jsonObject = new JSONObject(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String getData() {
        return this.data;
    }

    public String getName() throws JSONException {
        return this.jsonObject.getJSONObject("modelInfo").getString("name");
    }

    public String getCreationTime() throws JSONException {
        return this.jsonObject.getJSONObject("modelInfo").getString("created_at");
    }

    public String getPurpose() throws JSONException {
        return this.jsonObject.getJSONObject("modelInfo").getString("for");
    }

    public String getStates() throws JSONException {
        return this.jsonObject.getJSONObject("modelData").getString("states");
    }

    public String getInitialProbabilities() throws JSONException {
        return this.jsonObject.getJSONObject("modelData").getString("initial_prop");
    }

    public String getObservations() throws JSONException {
        return this.jsonObject.getJSONObject("modelData").getString("observations");
    }

    public String getTransitionMatrix() throws JSONException {
        return this.jsonObject.getJSONObject("modelData").getString("transition_matrix");
    }

    public String getEmissionMatrix() throws JSONException {
        return this.jsonObject.getJSONObject("modelData").getString("emission_matrix");
    }


    private String readFile(String filename) {
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
