package no.uis.dat630;

import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class ID3 {

	public static DTreeNode createTree(Vector<Person> people, List<Attribute> attributes) {

		DTreeNode root = new DTreeNode();

		if (attributes.isEmpty()) {
			System.out.print("Attributes empty - ");
			int countA = 0;
			int countB = 0;
			for (Person person : people) {
				if (person.isOver50K()) {
					countA++;
				} else {
					countB++;
				}
			}
			
			if (countA >= countB) {
				root.setLabel("+");
			} else {
				root.setLabel("-");
			}
			return root;

		} else if (allPeopleOver50K(people)) {
			System.out.print("Positive - ");
			root.setLabel("+");
			return root;

		} else if (allPeopleUnder50K(people)) {
			System.out.print("Negative - ");
			root.setLabel("-");
			return root;

		} else {

			Attribute startingAttribute = attHighestGain(people, attributes);

			root.setAttribute(startingAttribute);
			root.setLabel(startingAttribute.getLabel());

			for (String value : startingAttribute.getValues()) {

				root.addEdgeValues(value);

				Vector<Person> subPeople = new Vector<Person>(
						splitIntoSubset(people, value, startingAttribute.getID()));

				if (subPeople.size() <= 20) {

					DTreeNode leafNode = new DTreeNode();
					leafNode.setParent(root);
					root.addChild(leafNode);
					System.out.print("Most common - ");
					
					int count = 0;
					int countB = 0;
					
					for (Person person : subPeople) {
						if (person.isOver50K()) {
							count++;
						} else {
							countB++;
						}
					}
					if (count >= countB) {
						leafNode.setLabel("+");
					} else {
						leafNode.setLabel("-");
					}

				} else {

					attributes.remove(startingAttribute);
					DTreeNode subTree = createTree(subPeople, attributes);
					subTree.setParent(root);
					root.addChild(subTree);
				}
			}
		}

		return root;
	}

	private static Attribute attHighestGain(Vector<Person> people, List<Attribute> attributes) {
		double gain = -1;
		Attribute temp = null;
		for (Attribute a : attributes) {
			if (calculateGain(people, a) > gain) {
				gain = calculateGain(people, a);
				temp = a;
				System.out.print(a.getLabel() + " Gain: " + gain + "  |   ");
			}
		}

		return temp;
	}

	/*
	 * Entropy = - p(a)*log(p(a)) - p(b)*log(p(b))
	 */
	public static double entropy(Vector<Person> people) {
		double under50K = 0;
		double over50K = 0;

		for (Person person : people) {
			if (person.isOver50K()) {
				over50K++;
			} else {
				under50K++;
			}
		}

		if (under50K == 0 || over50K == 0) {
			return 0;
		}

		double probabilityA = over50K / (double) people.size();
		double probabilityB = under50K / (double) people.size();

		double entropy = -probabilityA * (Math.log(probabilityA) / Math.log(2))
				- probabilityB * (Math.log(probabilityB) / Math.log(2));

		return entropy;
	}

	public static double calculateGain(Vector<Person> people, Attribute a) {
		double gain = entropy(people);

		for (String value : a.getValues()) {

			Vector<Person> subPeople = new Vector<Person>(splitIntoSubset(people, value, a.getID()));

			double temp = (double) subPeople.size() / (double) people.size();
			gain -= (temp * entropy(subPeople));
		}
		
		return gain;
	}

	private static Vector<Person> splitIntoSubset(Vector<Person> people, String value, int atID) {

		Vector<Person> subPeople = new Vector<Person>();
		String[] tempValues = null;

		if (value.matches(".*\\d+.*")) {
			tempValues = value.split("\\-");
		}

		switch (atID) {
		case 0:
			for (Person person : people)
				if (person.getAge() >= Integer.parseInt(tempValues[0])
						&& person.getAge() < Integer.parseInt(tempValues[1]))
					subPeople.add(person);
			break;
		case 1:
			for (Person person : people)
				if (person.getWorkclass().equals(value))
					subPeople.add(person);
			break;
		case 2:
			for (Person person : people)
				if (person.getFnlwgt() >= Integer.parseInt(tempValues[0])
						&& person.getFnlwgt() < Integer.parseInt(tempValues[1]))
					subPeople.add(person);
			break;
		case 3:
			for (Person person : people)
				if (person.getEducation().equals(value))
					subPeople.add(person);
			break;
		case 4:
			for (Person person : people)
				if (person.getEducationNum() >= Integer.parseInt(tempValues[0])
						&& person.getEducationNum() < Integer.parseInt(tempValues[1]))
					subPeople.add(person);
			break;
		case 5:
			for (Person person : people)
				if (person.getMaritalStatus().equals(value))
					subPeople.add(person);
			break;
		case 6:
			for (Person person : people)
				if (person.getOccupation().equals(value))
					subPeople.add(person);
			break;
		case 7:
			for (Person person : people)
				if (person.getRelationship().equals(value))
					subPeople.add(person);
			break;
		case 8:
			for (Person person : people)
				if (person.getRace().equals(value))
					subPeople.add(person);
			break;
		case 9:
			for (Person person : people)
				if (person.getSex().equals(value))
					subPeople.add(person);
			break;
		case 10:
			for (Person person : people)
				if (person.getCapitalGain() >= Integer.parseInt(tempValues[0])
						&& person.getCapitalGain() < Integer.parseInt(tempValues[1]))
					subPeople.add(person);
			break;
		case 11:
			for (Person person : people)
				if (person.getCapitalLoss() >= Integer.parseInt(tempValues[0])
						&& person.getCapitalLoss() < Integer.parseInt(tempValues[1]))
					subPeople.add(person);
			break;
		case 12:
			for (Person person : people)
				if (person.getHoursPerWeek() >= Integer.parseInt(tempValues[0])
						&& person.getHoursPerWeek() < Integer.parseInt(tempValues[1]))
					subPeople.add(person);
			break;
		case 13:
			for (Person person : people)
				if (person.getNativeCountry().equals(value))
					subPeople.add(person);
			break;
		}

		return subPeople;
	}

	private static boolean allPeopleOver50K(Vector<Person> people) {
		for (Person person : people)
			if (!person.isOver50K())
				return false;

		return true;
	}

	private static boolean allPeopleUnder50K(Vector<Person> people) {
		for (Person person : people)
			if (person.isOver50K())
				return false;

		return true;
	}

	public static void printTree(DTreeNode tree) {
		String parentLbl = "No one";

		if (tree.getParent() != null) {
			parentLbl = tree.getParent().getLabel();
		}

		System.out.println("Node: " + tree.getLabel() + " Parent: " + parentLbl);
		System.out.print("edges");
		for (String sdf : tree.getEdgeValues())
			System.out.print(" " + sdf + ",");
		System.out.println("");
		for (DTreeNode child : tree.getChildren())
			printTree(child);
	}
}
