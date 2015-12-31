package ML.HMM;


import Util.Validation.Validator;
import javafx.util.Pair;

import java.util.*;

public class HMM_For_Testing {
    private String name;
    private int numberOfStates;
    private int numberOfObservations;
    private Vector<String> states;
    private Vector<String> observations;
    private Hashtable<String, Double> initialProbabilities;
    private Hashtable<Pair<String, String>, Double> transitionMatrix;
    private Hashtable<Pair<String, String>, Double> emissionMatrix;

    /**
     * A constructor that initialize the class attributes
     * @param states A Vector that is the states of the model
     * @param observations  A Vector that is the observations of the model
     * @param initialProbabilities A Hashtable that is the initial probability vector of the states
     * @param transitionMatrix A Hashtable the transition matrix between the states
     * @param emissionMatrix A Hashtable that is the emission matrix between the states and the observations
     */

    public HMM_For_Testing(String name, Vector<String> states, Vector<String> observations, Hashtable<String, Double> initialProbabilities, Hashtable<Pair<String, String>, Double> transitionMatrix, Hashtable<Pair<String, String>, Double> emissionMatrix) throws Exception {
        this.name = name;
        this.states = states;
        this.numberOfStates = states.size();
        this.observations = observations;
        this.numberOfObservations = observations.size();

        this.initialProbabilities = initialProbabilities;
        if (!this.validateInitialProbability(initialProbabilities))
            throw new Exception("Initial Probabilities sum must be equal 1.0");
        if (!this.validateInitialProbabilitiesAndStates(states, initialProbabilities))
            throw new Exception("States size and Initial Probabilities size must be equal");

        this.transitionMatrix = transitionMatrix;
        if (!this.validateTransitionMatrix(transitionMatrix, states))
            throw new Exception("Check the transition matrix elements");

        this.emissionMatrix = emissionMatrix;
        if (!this.validateEmissionMatrix(emissionMatrix, states, observations))
            throw new Exception("Check the emission matrix elements");
    }

    public HMM_For_Testing(String filepath) {

    }

    /**
     *
     * @param initialProbabilities A hashtable that is the initial probability vector of the states
     * @return [True/False] which specifies if the vector elements are logically right or not
     */

    private boolean validateInitialProbability(Hashtable<String, Double> initialProbabilities) {
        return Validator.getInstance().summationIsOne(initialProbabilities);
    }

    /**
     *
     * @param states A Vector<String> that is the states of the model
     * @param initialProbabilities A hashtable that is the initial probability vector of the states
     * @return [True/False] which specifies if the sizes are matched or not
     */

    private boolean validateInitialProbabilitiesAndStates(Vector<String> states, Hashtable<String, Double> initialProbabilities) {
        return Validator.getInstance().isValidInitialProbabilities(states, initialProbabilities);
    }

    /**
     *
     * @param transitionMatrix A Hashtable that is the transition matrix between the states
     * @param states A Vector that is the states of the model
     * @return [True/False] which specifies if the matrix elements are logically right or not
     */

    private boolean validateTransitionMatrix(Hashtable<Pair<String, String>, Double> transitionMatrix, Vector<String> states) {
        return Validator.getInstance().isValidTransitionMatrix(transitionMatrix, states);
    }

    /**
     *
     * @param emissionMatrix A Hashtable that is the emission matrix between the states and the observations
     * @param states A Vector that is the states of the model
     * @param observations A Vector that is the model observations
     * @return [True/False] True/False which specifies if the matrix elements are logically right or not
     */

    private boolean validateEmissionMatrix(Hashtable<Pair<String, String>, Double> emissionMatrix, Vector<String> states, Vector<String> observations) {
        return Validator.getInstance().isValidEmissionMatrix(emissionMatrix, states, observations);
    }

    /**
     * Get the number of states in the model
     * @return An integer that specifies the number of states in the model
     */

    public int getNumberOfStates() {
        return this.numberOfStates;
    }

    /**
     * Get the model states
     * @return A Vector which is the states of the model
     */

    public Vector<String> getStates() {
        return states;
    }

    /**
     * Set the number of states in the model
     * @param numberOfStates integer
     */

    public void setNumberOfStates(int numberOfStates) {
        this.numberOfStates = numberOfStates;
    }

    /**
     * Get the number of observations in the model
     * @return An integer that specifies the number of observations in the model
     */

    public int getNumberOfObservations() {
        return numberOfObservations;
    }

    /**
     * Get the model observations
     * @return A Vector which is the observations of the model
     */
    public Vector<String> getObservations() { return observations; }

    /**
     * Set the number of observations in the model
     * @param numberOfObservations An integer that specifies the number of observations in the model
     */

    public void setNumberOfObservations(int numberOfObservations) {
        this.numberOfObservations = numberOfObservations;
    }

    /**
     * Get the initial probability vector of the states
     * @return Hashtable that is the initial probability vector of the states
     */

    public Hashtable<String, Double> getInitialProbabilities() {
        return initialProbabilities;
    }

    /**
     * Set the initial probability vector of the states
     * @param initialProbabilities Hashtable that is the initial probability vector of the states
     */

    public void setInitialProbabilities(Hashtable<String, Double> initialProbabilities) {
        this.initialProbabilities = initialProbabilities;
    }

    /**
     * Get the transition matrix between the states
     * @return Hashtable that is the transition matrix between the states
     */

    public Hashtable<Pair<String, String>, Double> getTransitionMatrix() {
        return transitionMatrix;
    }

    /**
     * Set the transition matrix between the states
     * @param transitionMatrix Hashtable that is the transition matrix between the states
     */

    public void setTransitionMatrix(Hashtable<Pair<String, String>, Double> transitionMatrix) {
        this.transitionMatrix = transitionMatrix;
    }

    /**
     * Get the emission matrix between the states and the observations
     * @return Hashtable that is the emission matrix between the states and the observations
     */

    public Hashtable<Pair<String, String>, Double> getEmissionMatrix() {
        return emissionMatrix;
    }

    /**
     * Set the emission matrix between the states and the observations
     * @param emissionMatrix Hashtable that is the emission matrix between the states and the observations
     */

    public void setEmissionMatrix(Hashtable<Pair<String, String>, Double> emissionMatrix) {
        this.emissionMatrix = emissionMatrix;
    }

    /**
     *
     * @param firstState A string that is a state in the model
     * @param secondState A string that is a state in the model
     * @return A Double that is the transition value between the 2 states
     */

    public Double getTransitionValue(String firstState, String secondState) {
        return this.transitionMatrix.get(new Pair<String, String>(firstState, secondState));
    }

    /**
     *
     * @param state A string that is a state in the model
     * @param observation A string that is an observation in the model
     * @return A Double that is the value of the emission between the state and the observation
     */

    public Double getEmissionValue(String state, String observation) {
        return this.emissionMatrix.get(new Pair<String, String>(state, observation));
    }

    /**
     *
     * @param state A string that is a state in the model
     * @return A Double that is the initial probability value of the state
     */

    public Double getInitialProbability(String state) {
        return this.initialProbabilities.get(state);
    }

    /**
     * Calculate the probability to obtain this sequence of states and observations which is the Evaluation of the model
     * @param states A Vector which is the sequence of model states
     * @param observations A Vector which is the sequence of the model observations
     * @return A Double The probability to get this sequence of states and observations
     * @throws Exception The sizes of states and observations sequences must be the same.
     */

    public double evaluateUsingBruteForce(Vector<String> states, Vector<String> observations) throws Exception {
        if (states.size() != observations.size())
            throw new Exception("States and Observations must be at a same size!");

        String previousState = "";
        double probability = 0.0;
        double result = 0.0;

        for (int i = 0; i < states.size(); i++) {
            probability = this.getInitialProbability(states.get(i));
            previousState = "";
            for (int j = 0; j < observations.size(); j++) {
                double emissionValue = this.getEmissionValue(states.get(j), observations.get(j));
                double transitionValue = 0.0;
                if (j != 0) {
                    transitionValue += this.getTransitionValue(previousState, states.get(j));
                    probability *= transitionValue * emissionValue;
                }
                previousState = states.get(j);
            }
            result += probability;
        }

        return result;
    }

    /**
     * Calculate the probability to obtain this sequence of states and observations which is the Evaluation of the model
     * @param states A Vector which is the sequence of model states
     * @param observations A Vector which is the sequence of the model observations
     * @return A Double The probability to get this sequence of states and observations
     * @throws Exception The sizes of states and observations sequences must be the same.
     */

    public double evaluateUsingForward_Backward(Vector<String> states, Vector<String> observations) throws Exception {
        if (observations.size() != states.size()) {
            throw new Exception("States and Observations must be at a same size");
        }

        double result = 0.0;

        Vector<Hashtable<String, Double>> alpha = this.calculateForwardProbabilities(states, observations);
        // alpha = StatisticalOperations.getInstance().normalize(alpha, states);
        Vector<Hashtable<String, Double>> beta = this.calculateBackwardProbabilities(states, observations);
        //beta = StatisticalOperations.getInstance().normalize(beta, states);

        for (int t = 0; t < states.size(); t++) {
            for (int i = 0; i < alpha.size(); i++) {
                result += (alpha.get(t).get(states.get(i)) * beta.get(t).get(states.get(i)));
            }
        }

        return result;
    }

    /**
     * Calculate the forward probabilities Alpha as a part of Forward-Backward algorithm https://en.wikipedia.org/wiki/Forward%E2%80%93backward_algorithm
     * @param states A Vector that is the model states
     * @param observations A Vector that is the model observations
     * @return A Vector which contains the alpha values
     */

    public Vector<Hashtable<String, Double>> calculateForwardProbabilities(Vector<String> states, Vector<String> observations) {
        Vector<Hashtable<String, Double>> alpha = new Vector<Hashtable<String, Double>>();
        alpha.add(new Hashtable<String, Double>());
        double sum1 = 0.0;
        for(int i = 0; i < states.size(); i++) {
            alpha.elementAt(0).put(states.get(i), this.getInitialProbability(states.get(i)) * this.getEmissionValue(states.get(i), observations.get(0)));
            sum1 += this.getInitialProbability(states.get(i)) * this.getEmissionValue(states.get(i), observations.get(0));
        }

        for(int i = 0; i < states.size(); i++) {
            alpha.elementAt(0).put(states.get(i), alpha.elementAt(0).get(states.get(i)) * (1 / sum1));
        }

        sum1 = 0.0;
        for (int t = 1; t < states.size(); t++) {
            alpha.add(new Hashtable<String, Double>());
            for (int i = 0; i < states.size(); i++) {
                double probability = 0.0;
                for (int j = 0; j < states.size(); j++) {
                    probability += alpha.elementAt(t - 1).get(states.get(j)) * this.getTransitionValue(states.get(j), states.get(i));
                }
                alpha.elementAt(t).put(states.get(i), probability * this.getEmissionValue(states.get(i), observations.get(t)));
                sum1 += probability * this.getEmissionValue(states.get(i), observations.get(t));
            }
        }

        for (int t = 1; t < states.size(); t++) {
            for (int i = 0; i < states.size(); i++) {
                alpha.elementAt(t).put(states.get(i), alpha.elementAt(t).get(states.get(i)) * (1 / sum1));
            }
        }

        return alpha;
    }

    /**
     * Calculate the backward probabilities Beta as a part of Forward-Backward algorithm https://en.wikipedia.org/wiki/Forward%E2%80%93backward_algorithm
     * @param states A Vector that is the model states
     * @param observations A Vector that is the model observations
     * @return A Vector which contains the Beta values
     */

    public Vector<Hashtable<String, Double>> calculateBackwardProbabilities(Vector<String> states, Vector<String> observations) {
        Vector<Hashtable<String, Double>> beta = new Vector<Hashtable<String, Double>>();
        beta.add(new Hashtable<String, Double>());
        double sum1 = 0.0;

        for (int i = 0; i < states.size(); i++) {
            beta.elementAt(0).put(states.get(i), 1.0);
            sum1 += 1.0;
        }

        for (int i = 0; i < states.size(); i++) {
            beta.elementAt(0).put(states.get(i), beta.elementAt(0).get(states.get(i)) * (1 / sum1));
        }

        sum1 = 0.0;

        for (int t = states.size() - 2; t >= 0; t--) {
            beta.insertElementAt(new Hashtable<String, Double>(), 0);
            for (int i = 0; i < states.size(); i++) {
                double probability = 0.0;
                for (int j = 0; j < states.size(); j++) {
                    probability += beta.elementAt(1).get(states.get(j)) * this.getEmissionValue(states.get(j),
                            observations.get(t)) * this.getTransitionValue(states.get(i), states.get(j));
                }
                beta.elementAt(0).put(states.get(i), probability);
                sum1 += probability;
            }
        }

        for (int t = states.size() - 2; t >= 0; t--) {
            for (int i = 0; i < states.size(); i++) {
                beta.elementAt(0).put(states.get(i), beta.elementAt(0).get(states.get(i)) * (1 / sum1));
            }
        }

        return beta;
    }
}