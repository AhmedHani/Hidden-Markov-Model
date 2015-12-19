package ML.HMM;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Hashtable;

public class Main {

    public static void main(String[] args) {
        HashMap<Pair<String, String>, Double> transitionMatrix = new HashMap<Pair<String, String>, Double>();

        transitionMatrix.put(new Pair<String, String>("R", "S"), 3.0);
        transitionMatrix.put(new Pair<String, String>("R", "S"), 2.0);
        transitionMatrix.put(new Pair<String, String>("Z", "Z"), 2.0);

        for (Pair<String, String> item : transitionMatrix.keySet()) {
            System.out.println(item.getKey() + " " + item.getValue() + " " + transitionMatrix.get(item));
        }

    }
}
