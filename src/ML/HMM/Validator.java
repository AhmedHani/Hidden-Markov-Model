package ML.HMM;

import javafx.util.Pair;
import org.omg.CosNaming.NamingContextExtPackage.StringNameHelper;

import java.util.Hashtable;
import java.util.Vector;

/**
 * Created by ENG.AHMED HANI on 12/19/2015.
 */
public class Validator {
    private static Validator ourInstance = new Validator();

    public static Validator getInstance() {
        return ourInstance;
    }

    private Validator() {
    }

    public boolean summationIsOne(Hashtable<String, Double> list) {
        double sum = 0.0;

        for (double item : list.values()) {
            sum += item;
        }

        return sum == 1.0;
    }

    public boolean isEqualSize(int first, int second) {
        return first == second;
    }

    public boolean isValidTransitionMatrix(Hashtable<Pair<String, String>, Double> transitionMatrix, Vector<String> states) {
        if (transitionMatrix.size() != states.size() * states.size())
            return false;

        for (int i = 0; i < states.size(); i++) {
            for (Pair<String, String> item : transitionMatrix.keySet()) {
                int count = 0;
                int selfLoops = 0;

                if (item.getKey().equals(item.getValue())) {
                    selfLoops++;

                    if (selfLoops >= 2) {
                        return false;
                    }
                }

                if (item.getKey().equals(states.get(i)) || item.getValue().equals(states.get(i))) {
                    count++;
                } else {
                    return false;
                }

                if (count > 2 * states.size()) {
                    return false;
                }
            }
        }

        Hashtable<Pair<String, String>, Boolean> visited = new Hashtable<Pair<String, String>, Boolean>();

        for (Pair<String, String> first : transitionMatrix.keySet()) {
            double sum = 0.0;
            String state = first.getKey();
            for (Pair<String, String> second: transitionMatrix.keySet()) {
                if (state.equals(second.getKey()) && !visited.containsKey(second)) {
                    sum += transitionMatrix.get(second);
                    visited.put(second, true);
                }
            }

            if (sum != 1.0) {
                return false;
            }
        }

        return true;
    }
}
