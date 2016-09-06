package no.uis.dat630;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;



public class Controller {
	
	
	/*
	 * TODO Most likely delete this	
	 */
	public static DTreeNode newDecisionTree (Vector<String> data, Attribute targetAttribute, List<Attribute> attributes) {
		// Create root
		DTreeNode root = new DTreeNode ();
		// Test
		return root;
	}
	
	/*
	 * TODO Finish this method. Should be almost ready, fix the obvious errors
	 * Understand the else if clause that is unclear
	 */
	public static DTreeNode ID3 (Vector<String> data, Attribute targetAttribute, List<Attribute> attributes) {
			
		DTreeNode root = new DTreeNode ();
		
		if (allPeopleOver50K(data)) {
			root.setLabel("+");
			return root;
		} else if (!allPeopleOver50K(data)) {
			root.setLabel("-");
			return root;
		} else if (attributes.isEmpty()) {
			root.setLabel("most common value of the target attribute in the examples");
			return root;
		} else {

			double iGain = 0;
			Attribute startingAttribute = null;
			
			for (Attribute a : attributes) {
				if (gain(a,data) > iGain) {
					iGain = gain(a,data);
					startingAttribute = a;
				}
			}
			
			root.setAttribute(startingAttribute);
			Vector<String> values = assignValues(data, startingAttribute);
			Vector<String> subSet = new Vector<String>();
			
			for (String value : values) {
				DTreeNode attValueNode = new DTreeNode();
				attValueNode.setParent(root);
				for (String dataRow : data) {
					if(dataRow.contains(value)) {
						subSet.add(dataRow);
					}
				}
				
				if(subSet.isEmpty()) {
					DTreeNode leafNode = new DTreeNode();
					leafNode.setParent(attValueNode);
				} else {
					attributes.remove(startingAttribute);
					DTreeNode subTree = ID3(subSet, targetAttribute, attributes);
					subTree.setParent(root);
				}
			}
		}
		
		
		return root;
	}
	
	/*
	 * TODO Create this method, this should take in the test data and produce what will be the results
	 * Go through the tree starting with root, for each person. Then follow the path that his data takes him ending
	 * with either a pluss or a minus. See information on what that means
	 */
	public static Vector<String> test (Vector<String> data, Attribute targetAttribute, DTreeNode root, List<Attribute> attributes) {
		Vector<String> results = new Vector<String>();
	
		return results;
	}
	
	/*
	 * This method should be ready. Calculates gain for a given attribute according to the data
	 * returns a double value between 0-1
	 */
	public static double gain (Attribute attribute, Vector<String> data){
		
		double temp = entropy(data);
		double tempB = 0;
		
		Vector <String> values = assignValues(data, attribute);
		Vector <String> subData = new Vector<String>();
	
		// So here we need to divide the problem, and do some recursive shit
		// We need to divide it so that we take one step into an attribute and look at how many people with each of the values are over
		// and how many are under.
		
		for (String value : values) {
			for (String dataRow : data) {
				if (dataRow.contains(value)) {
					subData.add(dataRow);
				}
			}
			
			tempB += (subData.size()/data.size())*entropy(subData);
		}
		
		double gain = temp - tempB;
				
		// So check attribute and look at how many values it has "Vector<String> assignValues(Attribute a)"
		// then check every string in data, and divide it in subsets where you only include the people that has that value. Then check those people using entropy method

		return gain;
	}

	/*
	 * Calculates entropy for a given data, this is hard-coded for this example, meaning it calculates for
	 * over/under 50K. Can't be used for anything else.
	 */
	public static double entropy (Vector<String> data){
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
		
		double entropy = (over50K/data.size()) * (Math.log(over50K/data.size()) / Math.log(2)) 
					   - (under50K/data.size()) * (Math.log(over50K/data.size()) / Math.log(2));
		
		return entropy;
	}
	
	/*
	 * TODO This method should create the data from the learning set, and the test set
	 * to be used in this program further
	 */
	public static Vector<String> createData (String filename) {
		
		Vector<String> data = new Vector<String>();
		//while dataleft in data
			data.add("hei");
			//iterate new line;
		
		return data;
	}
	
	/*
	 * Assigns attributes and in a way counts them, this should work
	 */
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
	
	/*
	 * This assignValues does a bit of "Costly optimalization" It's more expensive to run then a typical assignValues in this context would be
	 * because it calculates a binary version of continuous values. I think that in the long terms the program should run more effienciently because of it
	 * But that remains to be seen.
	 */
	public static Vector<String> assignValues(Vector<String> data, Attribute a) {

		Vector<String> values = new Vector<String>();
		int AttributeID = a.getID();
		String tempValue = null;
		double continuousValue = 0;
		int numberOfContinuousValues = 0;
		int beginIndex = 0;
		int endIndex = 0;
		
		for (String dataRow : data) {
			// set beginIndex and endIndex by: tempValue == dataRow after AttributeID number of ',' + ' ' and before next ','
			if (tryParseInt(tempValue)) {
				continuousValue = Integer.parseInt(tempValue);
				numberOfContinuousValues ++;
			}
			if (!values.contains(tempValue)) {
				values.add(tempValue);
			}
		}
		
		if (numberOfContinuousValues != 0) {
			continuousValue = continuousValue/numberOfContinuousValues;
			
			double tempContValue = 0;
			double absValue = 0;
			
			for(String dataRow : data) {
				// set beginIndex and endIndex by: tempValue == dataRow after AttributeID number of ',' + ' ' and before next ','
				if(Integer.parseInt(dataRow.substring(beginIndex, endIndex)) == continuousValue) {
					values.add("<= " + continuousValue);
					values.add("> " + continuousValue);
					return values;
				} else {
					if (absValue > Math.abs(tempContValue = Integer.parseInt(dataRow.substring(beginIndex, endIndex))-continuousValue)) {
						tempContValue = Integer.parseInt(dataRow.substring(beginIndex, endIndex));
						absValue = Math.abs(tempContValue-continuousValue);
					}
				}
			}
					
			values.add("<= " + tempContValue);
			values.add("> " + tempContValue);
			return values;
		}
		
		return values;
	}
	
	/*
	 * TODO This method should convert the results from the test method and save them in a proper textfile where outPath decides
	 */
	public static void comparableData (Vector<String> results, String outPath) {
		// This method will prepare data for the eval script.
	}
	
	/*
	 * Helping(?) method for giving a boolean value when trying to parse an integer. 
	 * This is to make it easier to program without the worry for any exceptions. 
	 */
	private static boolean tryParseInt(String value) {  
	     try {  
	         Integer.parseInt(value);  
	         return true;  
	      } catch (NumberFormatException e) {  
	         return false;  
	      }  
	}
	
	private static boolean allPeopleOver50K (Vector<String> data) {
		for(String dataRow : data)
			if(dataRow.contains(">50K"))
				return true;
		
		return false;
	}
	
	
}
