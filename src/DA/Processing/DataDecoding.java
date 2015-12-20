package DA.Processing;

import javafx.util.Pair;

import javax.swing.text.rtf.RTFEditorKit;
import java.util.Collections;
import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by Ahmed Hani Ibrahim on 12/20/2015.
 */
public class DataDecoding {
    private final String OUTER_SPLITTER = ", ";
    private final String INNER_SPLITTER = "->";
    private static DataDecoding ourInstance = new DataDecoding();

    public static DataDecoding getInstance() {
        return ourInstance;
    }

    private DataDecoding() {
    }

    /**
     * Get the HMM model name that is written in the Json file
     * @param nameInJson A string that hold the json expression of the model name
     * @return A String that is the name of the model
     */

    public String getModelName(String nameInJson) {
        return nameInJson;
    }

    /**
     * Get the HMM model creation date that is written in the Json file
     * @param dateInJson A string that hold the json expression of the model creation date
     * @return A String that is the creation date of the model
     */

    public String getModelCreationDate(String dateInJson) {
        return dateInJson;
    }

    /**
     * Get the purpose of the model creation, such as "Weather prediction"
     * @param purposeInJson A string that hold the json expression of the model purpose
     * @return A String that is the purpose of the model
     */

    public String getModelCreationPurpose(String purposeInJson) {
        return purposeInJson;
    }

    /**
     * Get the model states
     * @param statesInJson A string that hold the json expression of the model states
     * @return A Vector that is the states of the model
     */

    public Vector<String> getStates(String statesInJson) {
        Vector<String> states = new Vector<String>();
        String[] statesArray = statesInJson.split(OUTER_SPLITTER);

        Collections.addAll(states, statesArray);

        return states;
    }

    /**
     * Get the initial probabilities of the states
     * @param initialProbabilitiesInJson A string that hold the json expression of the model initial probabilities
     * @return A Hashtable that is the initial probabilities of the model states
     */

    public Hashtable<String, Double> getInitialProbabilities(String initialProbabilitiesInJson) {
        Hashtable<String, Double> initialProbabilities = new Hashtable<String, Double>();

        String[] initialProb = initialProbabilitiesInJson.split(OUTER_SPLITTER);

        for (String expression : initialProb) {
            String[] tempExpression = expression.split(INNER_SPLITTER);

            for (int i = 0; i < tempExpression.length; i += 2) {
                initialProbabilities.put(tempExpression[i], Double.parseDouble(tempExpression[i + 1]));
            }
        }

        return initialProbabilities;
    }

    /**
     * Get the observations of the model
     * @param observationsInJson A string that hold the json expression of the model observations
     * @return A Hashtable that is the observations of the model
     */

    public Vector<String> getObservations(String observationsInJson) {
        Vector<String> observations = new Vector<String>();
        String[] expressionArray = observationsInJson.split(OUTER_SPLITTER);

        Collections.addAll(observations, expressionArray);

        return observations;
    }

    /**
     * Get the transition matrix of the model
     * @param transitionMatrixInJson A string that hold the json expression of the model transition matrix
     * @return A Hasshtable that is the transition matrix of the model
     */

    public Hashtable<Pair<String, String>, Double> getTransitionMatrix(String transitionMatrixInJson) {
        Hashtable<Pair<String, String>, Double> transitionMatrix = new Hashtable<Pair<String, String>, Double>();
        String[] tempExpressionArray = transitionMatrixInJson.split(OUTER_SPLITTER);

        for (String expression : tempExpressionArray) {
            String[] transitionExpression = expression.split(INNER_SPLITTER);

            for (int i = 0; i < transitionExpression.length; i += 3) {
                transitionMatrix.put(new Pair<String, String>(transitionExpression[i], transitionExpression[i + 1]),
                        Double.parseDouble(transitionExpression[i + 2]));
            }
        }

        return transitionMatrix;
    }

    /**
     * Get the emission matrix
     * @param emissionMatrixInJson A string that hold the json expression of the model emission matrix
     * @return A Hasshtable that is the emission matrix of the model
     */

    public Hashtable<Pair<String, String>, Double> getEmissionMatrix(String emissionMatrixInJson) {
        Hashtable<Pair<String, String>, Double> emissionMatrix = new Hashtable<Pair<String, String>, Double>();
        String[] tempExpressionArray = emissionMatrixInJson.split(OUTER_SPLITTER);

        for (String expression : tempExpressionArray) {
            String[] emissionExpression = expression.split(INNER_SPLITTER);

            for (int i = 0; i < emissionExpression.length; i += 3) {
                emissionMatrix.put(new Pair<String, String>(emissionExpression[i], emissionExpression[i + 1]),
                        Double.parseDouble(emissionExpression[i + 2]));
            }
        }

        return emissionMatrix;
    }
}
