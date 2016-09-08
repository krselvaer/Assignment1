package no.uis.dat630;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Launch {

	public static void main(String[] args) {
		
		
		String innTrain = "adultTrain.txt";
		String innTest = "adultTest.txt";
		String out = "results.text";
		
		Vector<String> dataTrain;
		Vector<String> dataTest;
		Vector<Attribute> attributes;
		DTreeNode tree;
		Vector<String> testResults;
		Attribute targetAttribute;
		
		dataTrain = Controller.createData(innTrain);
		dataTest = Controller.createData(innTest);
		attributes = new Vector<Attribute>();
		Controller.assignAttributes(dataTrain.elementAt(0), attributes);
		targetAttribute = attributes.lastElement();
		tree = Controller.ID3(dataTrain, targetAttribute, attributes);
		testResults = Controller.test(dataTest, targetAttribute, tree, attributes);
		Controller.comparableData(testResults, out);
			

	}

}
