# Hidden-Markov-Model
A Java implementation of Hidden Markov Model.
The implementation contains Brute Force, Forward-backward, Viterbi and Baum-Welch algorithms

Hidden Markov Model is a classifier that is used in different way than the other Machine Learning classifiers. HMM depends on sequences that
are shown during sequential time instants. It has many applications such as weather predictions and shines in Speech recognition applications.

After I finish the implementation, I will put the full tutorial of HMM and the javadoc of the API.

## Features (continuously updating)
* Json reader

## Json Reader
You can create your model using Json files. In the repository, you will see an example of a model written in a specific expression.
I added this feature to help the user to avoid the hard-coding part when entering the model data such as transition and emission matrices.

The Json file is divided to 2 parts, the model info and model data.
In model data, you put some information about the model, this enables you when you deal with large amount of models in your projects.

```
"modelInfo": {
        "name": "HMM1",
		"created_at": "19/12/2015",
		"for": "testing"
	}
```

You can manually change these data as you wish.

The second part is the model data which is the core of the HMM

```
"modelData": {
				"states": "Ahmed, Hani",
				"initial_prop": "Ahmed->0.8, Hani->0.2",
				"observations": "X, Y",
				"transition_matrix": "Ahmed->Ahmed->0.4, Ahmed->Hani->0.6, Hani->Ahmed->0.1, Hani->Hani->0.9",
				"emission_matrix": "Ahmed->X->0.5, Ahmed->Y->0.5, Hani->X->0.4, Hani->Y->0.6"
	}
```

After I finish the API, I will show the format that the json must have to enable the API to read the data correctly.