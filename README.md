# What ?

They are a collection of random variables indexed in some way (usually by time), that change from state to state in a way that is dependent solely on the current state, and not past events. More information [here](https://medium.com/@ddbren/markov-chain-sentences-a32d6d520b96).

# How?

In a Markov Chain Sentence, the variables indexed are words. They have a probability of appearing depending on the n-grams they are a part of. We will use bigrams (groups of two words) as they appear in the source text. N-grams are used to predict which word is going to be added next.