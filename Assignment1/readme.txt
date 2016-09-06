Assignment 1:

// 39, State-gov, 77516, Bachelors, 13, Never-married, Adm-clerical, Not-in-family, White, Male, 2174, 0, 40, United-States, <=50K

Data:
Tabell med Object

Object:
int age: continuous.
string workclass: Private, Self-emp-not-inc, Self-emp-inc, Federal-gov, Local-gov, State-gov, Without-pay, Never-worked.
int fnlwgt: continuous.
string education: Bachelors, Some-college, 11th, HS-grad, Prof-school, Assoc-acdm, Assoc-voc, 9th, 7th-8th, 12th, Masters, 1st-4th, 10th, Doctorate, 5th-6th, Preschool.
int education-num: continuous.
string marital-status: Married-civ-spouse, Divorced, Never-married, Separated, Widowed, Married-spouse-absent, Married-AF-spouse.
string occupation: Tech-support, Craft-repair, Other-service, Sales, Exec-managerial, Prof-specialty, Handlers-cleaners, Machine-op-inspct, Adm-clerical, Farming-fishing, Transport-moving, Priv-house-serv, Protective-serv, Armed-Forces.
string relationship: Wife, Own-child, Husband, Not-in-family, Other-relative, Unmarried.
string race: White, Asian-Pac-Islander, Amer-Indian-Eskimo, Other, Black.
string sex: Female, Male.
int capital-gain: continuous.
int capital-loss: continuous.
int hours-per-week: continuous.
string native-country: United-States, Cambodia, England, Puerto-Rico, Canada, Germany, Outlying-US(Guam-USVI-etc), India, Japan, Greece, South, China, Cuba, Iran, Honduras, Philippines, Italy, Poland, Jamaica, Vietnam, Mexico, Portugal, Ireland, France, Dominican-Republic, Laos, Ecuador, Taiwan, Haiti, Columbia, Hungary, Guatemala, Nicaragua, Scotland, Thailand, Yugoslavia, El-Salvador, Trinadad&Tobago, Peru, Hong, Holand-Netherlands.
boolean moneyFck: 0,1.


Desicion Tree:



So what are we doing!???

We are building a tree in memory. This tree is a helping aid for deiciding what a person earns. More or less than 50K.
So first we need to build the tree. This tree should consist of attributes as leaf, and the attribute value should lead to the next leaf
IE the edges are values.

All end nodes should contain a value and that value should be attached to the targetAttribute.

So the decision tree should not contain any values from the data at all. It should only contain Attributes and the potential values 
of these attributes.

However, the helping methods Gain and Entropy have to know these values. So the method of creating the tree have to pass it along.

In the algorithms that I have seen, the names of the Attributes is never written. And the values isn't written either.
This means that I have to either create my program to interpet the name 


:::::TODO::::