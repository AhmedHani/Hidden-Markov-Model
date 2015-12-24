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
23/12/2015

You can manually change these data as you wish.

The second part is the model data which is the core of the HMM

```
"modelData": {
				"states": "R, S, C",
				"initial_prop": "R->0.3, S->0.4, C->0.3",
				"observations": "F, U, D",
				"transition_matrix": "R->R->0.2, R->S->0.1, R->C->0.7, S->R->0.3, S->S->0.4, S->C->0.3, C->R->0.1, C->S->0.4, C->C->0.5",
				"emission_matrix": "R->F->0.4, R->U->0.5, R->D->0.1, S->F->0.4, S->U->0.0, S->D->0.6, C->F->0.4, C->U->0.2, C->D->0.4"
	}
```

![alt tag](https://ahmedhanibrahim.files.wordpress.com/2015/08/hmm1.png)

After I finish the API, I will show the format that the json must have to enable the API to read the data correctly.

## Tutorials
* [https://ahmedhanibrahim.wordpress.com/2015/10/25/hidden-markov-models-hmms-part-i/](https://ahmedhanibrahim.wordpress.com/2015/10/25/hidden-markov-models-hmms-part-i/)