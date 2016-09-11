package no.uis.dat630;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Launch {

	public static void main(String[] args) {
		
		
		String innTrain = "adultTrain.txt";
		String innTest = "adultTest.txt";
		String out = "results.csv";
		
		Vector<String> dataTrain;
		Vector<String> dataTest;
		Vector<Person> people;
		Vector<Attribute> attributes;
		DTreeNode tree;
		Vector<Person> testResults;
		
		dataTrain = Controller.createData(innTrain);
		people = Controller.createPeople(dataTrain);
		dataTest = Controller.createData(innTest);
		Vector<Person> testPeople = Controller.createTestPeople(dataTest);
		System.out.println("Done train data");
		dataTest = Controller.createData(innTest);
		System.out.println("Done test data");
		attributes = new Vector<Attribute>();
		Controller.assignAttributes(dataTrain.elementAt(0), attributes);
		for (Attribute attribute : attributes)
			attribute.setValues(Controller.assignValuesAtt(people, attribute));
		System.out.println("Done attributes and values for them");
		tree = ID3.createTree(people, attributes);
		
		attributes = new Vector<Attribute>();
		Controller.assignAttributes(dataTrain.elementAt(0), attributes);
		for (Attribute attribute : attributes)
			attribute.setValues(Controller.assignValuesAtt(testPeople, attribute));
		System.out.println("Done creating tree");
		System.out.println("*******************************************");
		ID3.printTree(tree);
		System.out.println("*******************************************");
		testResults = Controller.test(testPeople, tree, attributes);
		System.out.println("Done with test");
		Controller.comparableData(testResults, out);
		System.out.println("Done");

	}

}
