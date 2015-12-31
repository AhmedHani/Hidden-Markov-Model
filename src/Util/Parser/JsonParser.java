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

    /**
     * Get the json file string data
     * @return A string which represents the hmm data
     */
    public String getData() {
        return this.data;
    }

    /**
     * Get the model name
     * @return A String which is the model name
     * @throws JSONException
     */

    public String getName() throws JSONException {
        return this.jsonObject.getJSONObject("modelInfo").getString("name");
    }

    /**
     * Get the model creation date
     * @return A String which is the model creation date
     * @throws JSONException
     */

    public String getCreationTime() throws JSONException {
        return this.jsonObject.getJSONObject("modelInfo").getString("created_at");
    }

    /**
     * Get the model creation purpose
     * @return A String which is the model creation purpose
     * @throws JSONException
     */

    public String getPurpose() throws JSONException {
        return this.jsonObject.getJSONObject("modelInfo").getString("for");
    }

    /**
     * Get the model states
     * @return A String which is the model states
     * @throws JSONException
     */

    public String getStates() throws JSONException {
        return this.jsonObject.getJSONObject("modelData").getString("states");
    }

    /**
     * Get the model initial probabilities of the states
     * @return A String which is the model initial probabilities of the states
     * @throws JSONException
     */

    public String getInitialProbabilities() throws JSONException {
        return this.jsonObject.getJSONObject("modelData").getString("initial_prop");
    }

    /**
     * Get the model observations
     * @return A String which is the model observations
     * @throws JSONException
     */

    public String getObservations() throws JSONException {
        return this.jsonObject.getJSONObject("modelData").getString("observations");
    }

    /**
     * Get the model transition matrix
     * @return A String which represents the transition between the model states
     * @throws JSONException
     */

    public String getTransitionMatrix() throws JSONException {
        return this.jsonObject.getJSONObject("modelData").getString("transition_matrix");
    }

    /**
     * Get the model emission matrix
     * @return A String which represents the emission matrix between the states and observations
     * @throws JSONException
     */

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
