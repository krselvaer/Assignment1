package no.uis.dat630;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



public class Controller {
		
	public static DTreeNode newDecisionTree (Vector<String> data, Attribute targetAttribute, List<Attribute> attributes) {
		// Create root
		DTreeNode root = new DTreeNode ();
		// Test
		return root;
	} 
	
	public static double gain (Attribute attribute, Vector<String> data, Vector<Attribute> a){
		
		double temp = entropy(data, a);
		CharSequence under50k = ">50K";
		
		Vector<Attribute> tempAttributes = a;
		tempAttributes.remove(attribute.getID());
	
		// So here we need to divide the problem, and do some recursive shit
		// We need to divide it so that we take one step into an attribute and look at how many people with each of the values are over
		// and how many are under.
		
		// So check attribute and look at how many values it has "Vector<String> assignValues(Attribute a)"
		// then check every string in data, and divide it in subsets where you only include the people that has that value. Then check those people using entropy method
//		for (String dataRow : data) {
//			if (dataRow.contains(under50k)) {
//				under50K += 1;
//				break;
//			} 
//		}
//		
//		for (Attribute att : a)
//			temp -= entropy();

		return temp;
	}

	public static double entropy (Vector<String> data, Vector<Attribute> a){
		int under50K = 0;
		int over50K = 0;
		CharSequence temp = "<=50K";
		for (String dataRow : data) {
			if (dataRow.contains(temp)) {
				over50K += 1;
				break;
			} 
			
			under50K += 1;
		}
		
		double entropy = (over50K/a.size()) * (Math.log(over50K/a.size()) / Math.log(2)) 
						- (under50K/a.size()) * (Math.log(over50K/a.size()) / Math.log(2));
		
		return entropy;
	}
	
	public static Vector<String> createData (String filename) {
		
		Vector<String> data = new Vector<String>();
		//while dataleft in data
			data.add("hei");
			//iterate new line;
		
		return data;
	}
	
	public static void assignAttributes(String dataString, Vector<Attribute> attributes) {
		// Count the number of attributes there is. 
		// So go through the data and find all attributes. In this case I go through the first line and count ',' because this way
		// I get the number of attributes. -1, have to see if i need to get this one as well.
		int IDcount = 0;
		for(Character character : dataString.toCharArray()) {
			if(character.equals(',')) {
				attributes.add(new Attribute(IDcount));
				IDcount++;
			}		
		}
	}
	
	public static Vector<String> assignValues(Attribute a) {
		// This method needs to be called everytime i have to test entropy scores. Somehow. And this needs to look through all
		// the data and find each unique value for the Attribute
		
		Vector<String> values = new Vector<String>();
		return values;
	}
	
	public static void comparableData (String out, DTreeNode tree) {
		// This method will prepare data for the eval script.
	}
	
	
}
