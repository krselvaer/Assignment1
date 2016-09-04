package no.uis.dat630;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Launch {

	public static void main(String[] args) {
		
		
		String filename = "hei";
		Vector<String> data = Controller.createData(filename);
		Vector<Attribute> attributes = new Vector<Attribute>();
		Controller.assignAttributes(data.elementAt(0), attributes);
		
		Attribute targetAttribute = attributes.lastElement();
			
		//Controller.newDecisionTree(persons, targetAttribute, attributes);
		
		String out = "c:somethingFckyou";
		Controller.comparableData(out, Controller.newDecisionTree(data, targetAttribute, attributes));

	}

}
