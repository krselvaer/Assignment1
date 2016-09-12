package no.uis.dat630;

import java.io.File;
import java.io.FileWriter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class Controller {

	/*
	 * TODO Create this method, this should take in the test data and produce
	 * what will be the results Go through the tree starting with root, for each
	 * person. Then follow the path that his data takes him ending with either a
	 * pluss or a minus. See information on what that means
	 */
	public static Vector<Person> test(Vector<Person> people, DTreeNode root, List<Attribute> attributes) {

		for (Person person : people) {
			DTreeNode temp = root;

			while (temp != null) {
				if (temp.getLabel() != null && temp.getLabel().equals("+")) {
					person.setOver50K(true);
					break;
				} else if (temp.getLabel() != null && temp.getLabel().equals("-")) {
					person.setOver50K(false);
					break;
				} else {

					String[] tempValues = null;

					switch (temp.getAttribute().getID()) {

					case 0:

						for (int k = 0; k < temp.getEdgeValues().size(); k++) {

							if (temp.getEdgeValues().get(k).matches(("^[0-9\\-]+$"))) {
								tempValues = temp.getEdgeValues().get(k).split("-");
							}

							if (person.getAge() >= Integer.parseInt(tempValues[0])
									&& person.getAge() < Integer.parseInt(tempValues[1])) {
								temp = temp.getChildren().get(k);
								break;
							}
						}

						break;
					case 1:
						for (int k = 0; k < temp.getEdgeValues().size(); k++) {
							if (person.getWorkclass().equals(temp.getEdgeValues().get(k))) {
								temp = temp.getChildren().get(k);
								break;
							}
						}

						if (person.getWorkclass().equals("?") || person.getWorkclass().contains("Never")) {
							temp = temp.getChildren().get(0);
						}

						break;
					case 2:
						for (int k = 0; k < temp.getEdgeValues().size(); k++) {

							if (temp.getEdgeValues().get(k).matches(".*\\d+.*")) {
								tempValues = temp.getEdgeValues().get(k).split("-");
							}

							if (person.getFnlwgt() >= Integer.parseInt(tempValues[0])
									&& person.getFnlwgt() < Integer.parseInt(tempValues[1])) {
								temp = temp.getChildren().get(k);
								break;
							}
						}
						break;
					case 3:
						for (int k = 0; k < temp.getEdgeValues().size(); k++) {
							if (person.getEducation().equals(temp.getEdgeValues().get(k))) {
								temp = temp.getChildren().get(k);
								break;
							}
						}

						if (person.getEducation().equals("?")) {
							temp = temp.getChildren().get(1);
						}

						break;
					case 4:
						for (int k = 0; k < temp.getEdgeValues().size(); k++) {

							if (temp.getEdgeValues().get(k).matches(".*\\d+.*")) {
								tempValues = temp.getEdgeValues().get(k).split("-");
							}

							if (person.getEducationNum() >= Integer.parseInt(tempValues[0])
									&& person.getEducationNum() < Integer.parseInt(tempValues[1])) {
								temp = temp.getChildren().get(k);
								break;
							}
						}
						break;
					case 5:
						for (int k = 0; k < temp.getEdgeValues().size(); k++) {

							if (person.getMaritalStatus().equals(temp.getEdgeValues().get(k))) {
								temp = temp.getChildren().get(k);
								break;
							}
						}

						if (person.getMaritalStatus().equals("?")) {
							temp = temp.getChildren().get(1);
						}

						break;
					case 6:
						for (int k = 0; k < temp.getEdgeValues().size(); k++) {

							if (person.getOccupation().equals(temp.getEdgeValues().get(k))) {
								temp = temp.getChildren().get(k);
								break;
							}
						}

						if (person.getOccupation().equals("?")) {
							temp = temp.getChildren().lastElement();
						}

						break;
					case 7:
						for (int k = 0; k < temp.getEdgeValues().size(); k++) {
							if (person.getRelationship().equals(temp.getEdgeValues().get(k))) {
								temp = temp.getChildren().get(k);
								break;
							}
						}

						if (person.getRelationship().equals("?")) {
							temp = temp.getChildren().get(0);
						}

						break;
					case 8:
						for (int k = 0; k < temp.getEdgeValues().size(); k++) {
							if (person.getRace().equals(temp.getEdgeValues().get(k))) {
								temp = temp.getChildren().get(k);
								break;
							}
						}

						if (person.getRace().equals("?")) {
							temp = temp.getChildren().get(1);
						}

						break;
					case 9:
						for (int k = 0; k < temp.getEdgeValues().size(); k++) {
							if (person.getSex().equals(temp.getEdgeValues().get(k))) {
								temp = temp.getChildren().get(k);
								break;
							}
						}

						if (person.getSex().equals("?")) {
							temp = temp.getChildren().get(1);
						}

						break;
					case 10:
						for (int k = 0; k < temp.getEdgeValues().size(); k++) {

							if (temp.getEdgeValues().get(k).matches(".*\\d+.*")) {
								tempValues = temp.getEdgeValues().get(k).split("-");
							}

							if (person.getCapitalGain() >= Integer.parseInt(tempValues[0])
									&& person.getCapitalGain() < Integer.parseInt(tempValues[1])) {
								temp = temp.getChildren().get(k);
								break;
							}
						}

						break;
					case 11:
						for (int k = 0; k < temp.getEdgeValues().size(); k++) {

							if (temp.getEdgeValues().get(k).matches(".*\\d+.*")) {
								tempValues = temp.getEdgeValues().get(k).split("-");
							}

							if (person.getCapitalLoss() >= Integer.parseInt(tempValues[0])
									&& person.getCapitalLoss() < Integer.parseInt(tempValues[1])) {
								temp = temp.getChildren().get(k);
								break;
							}
						}
						break;
					case 12:
						for (int k = 0; k < temp.getEdgeValues().size(); k++) {

							if (temp.getEdgeValues().get(k).matches(".*\\d+.*")) {
								tempValues = temp.getEdgeValues().get(k).split("-");
							}

							if (person.getHoursPerWeek() >= Integer.parseInt(tempValues[0])
									&& person.getHoursPerWeek() < Integer.parseInt(tempValues[1])) {
								temp = temp.getChildren().get(k);
								break;
							}
						}
						break;
					case 13:
						for (int k = 0; k < temp.getEdgeValues().size(); k++) {
							if (person.getNativeCountry().equals(temp.getEdgeValues().get(k))) {
								temp = temp.getChildren().get(k);
								break;
							}
						}

						if (person.getNativeCountry().equals("?")) {
							temp = temp.getChildren().get(2);
						}
						break;
					default:
						System.out.print("Couldn't complete tree");
						temp = null;
						break;
					}
				}
			}
		}
		return people;
	}

	/*
	 * TODO This method should create the data from the learning set, and the
	 * test set to be used in this program further
	 */
	public static Vector<String> createData(String filename) {

		Vector<String> data = new Vector<String>();

		try {
			Scanner sc = new Scanner(new File(filename));

			while (sc.hasNextLine()) {
				data.add(sc.nextLine());
			}
			sc.close();

		} catch (Exception e) {
			System.out.println("ErrorFilename or something");
		}

		return data;
	}

	public static Vector<Person> createPeople(Vector<String> data) {

		Vector<Person> people = new Vector<Person>();

		int age = 0;
		String workclass = null;
		int fnlwgt = 0;
		String education;
		int educationNum = 0;
		String maritalStatus = null;
		String occupation = null;
		String relationship = null;
		String race = null;
		String sex = null;
		int capitalGain = 0;
		int capitalLoss = 0;
		int hoursPerWeek = 0;
		String nativeCountry = null;
		boolean over50K = true;

		for (String dataRow : data) {

			if (!dataRow.contains("?")) {

				if (dataRow.contains(">50K")) {
					over50K = true;
				} else {
					over50K = false;
				}

				String[] temp = dataRow.split("\\s*,\\s*");

				if (tryParseInt(temp[0])) {
					age = Integer.parseInt(temp[0]);
				}
				workclass = temp[1];
				if (tryParseInt(temp[2])) {
					fnlwgt = Integer.parseInt(temp[2]);
				}
				education = temp[3];
				if (tryParseInt(temp[4])) {
					educationNum = Integer.parseInt(temp[4]);
				}

				maritalStatus = temp[5];
				occupation = temp[6];
				relationship = temp[7];
				race = temp[8];
				sex = temp[9];

				if (tryParseInt(temp[10])) {
					capitalGain = Integer.parseInt(temp[10]);
				}
				if (tryParseInt(temp[11])) {
					capitalLoss = Integer.parseInt(temp[11]);
				}

				if (tryParseInt(temp[12])) {
					hoursPerWeek = Integer.parseInt(temp[12]);
				}

				nativeCountry = temp[13];

				Person person = new Person(age, workclass, fnlwgt, education, educationNum, maritalStatus, occupation,
						relationship, race, sex, capitalGain, capitalLoss, hoursPerWeek, nativeCountry, over50K);

				people.add(person);
			}
		}
		return people;
	}

	public static Vector<Person> createTestPeople(Vector<String> data) {

		Vector<Person> people = new Vector<Person>();

		int age = 0;
		String workclass = null;
		int fnlwgt = 0;
		String education;
		int educationNum = 0;
		String maritalStatus = null;
		String occupation = null;
		String relationship = null;
		String race = null;
		String sex = null;
		int capitalGain = 0;
		int capitalLoss = 0;
		int hoursPerWeek = 0;
		String nativeCountry = null;
		boolean over50K = true;

		for (String dataRow : data) {

			if (dataRow.contains(">50K")) {
				over50K = true;
			} else 
				over50K = false;

			String[] temp = dataRow.split("\\s*,\\s*");

			if (tryParseInt(temp[0])) {
				age = Integer.parseInt(temp[0]);
			}
			workclass = temp[1];
			if (tryParseInt(temp[2])) {
				fnlwgt = Integer.parseInt(temp[2]);
			}
			education = temp[3];
			if (tryParseInt(temp[4])) {
				educationNum = Integer.parseInt(temp[4]);
			}

			maritalStatus = temp[5];
			occupation = temp[6];
			relationship = temp[7];
			race = temp[8];
			sex = temp[9];

			if (tryParseInt(temp[10])) {
				capitalGain = Integer.parseInt(temp[10]);
			}
			if (tryParseInt(temp[11])) {
				capitalLoss = Integer.parseInt(temp[11]);
			}

			if (tryParseInt(temp[12])) {
				hoursPerWeek = Integer.parseInt(temp[12]);
			}

			nativeCountry = temp[13];

			Person person = new Person(age, workclass, fnlwgt, education, educationNum, maritalStatus, occupation,
					relationship, race, sex, capitalGain, capitalLoss, hoursPerWeek, nativeCountry, over50K);

			people.add(person);
		}
		return people;
	}

	/*
	 * Assigns attributes and in a way counts them, this should work
	 */
	public static void assignAttributes(String dataString, Vector<Attribute> attributes) {
		int IDcount = 0;
		for (Character character : dataString.toCharArray()) {
			if (character.equals(',')) {
				attributes.add(new Attribute(IDcount));
				IDcount++;
			}
		}
		attributes.get(0).setLabel("Age");
		attributes.get(0).setNumCat(true);
		attributes.get(1).setLabel("Workclass");
		attributes.get(2).setLabel("Fnlwgt");
		attributes.get(2).setNumCat(true);
		attributes.get(3).setLabel("Education");
		attributes.get(4).setLabel("EducationNum");
		attributes.get(4).setNumCat(true);
		attributes.get(5).setLabel("MaritalStatus");
		attributes.get(6).setLabel("Occupation");
		attributes.get(7).setLabel("Relationship");
		attributes.get(8).setLabel("Race");
		attributes.get(9).setLabel("Sex");
		attributes.get(10).setLabel("CapitalGain");
		attributes.get(10).setNumCat(true);
		attributes.get(11).setLabel("CapitalLoss");
		attributes.get(11).setNumCat(true);
		attributes.get(12).setLabel("HoursPerWeek");
		attributes.get(12).setNumCat(true);
		attributes.get(13).setLabel("NativeCountry");

	}

	public static Vector<String> assignValuesAtt(Vector<Person> people, Attribute a) {

		@SuppressWarnings("unused")
		int attributeID = a.getID();
		Vector<String> values = new Vector<String>();
		Vector<Integer> tempValues = new Vector<Integer>();

		switch (a.getID()) {

		case 0:
			for (Person person : people)
				tempValues.add(person.getAge());
			
			Collections.sort(tempValues);
			
			values.add((tempValues.firstElement() - 1) + "-" + tempValues.get((tempValues.size() / 2)));
			values.add(tempValues.get((tempValues.size() / 2)) + "-" + (tempValues.lastElement() + 1));
			break;

		case 1:

			for (Person person : people)
				if (!values.contains(person.getWorkclass()) && !person.getWorkclass().equals("?"))
					values.add(person.getWorkclass());
			break;

		case 2:
			for (Person person : people)
				tempValues.add(person.getFnlwgt());

			Collections.sort(tempValues);
			values.add((tempValues.firstElement() - 1) + "-" + tempValues.get((tempValues.size() / 2)));
			values.add(tempValues.get((tempValues.size() / 2)) + "-" + (tempValues.lastElement() + 1));
			break;

		case 3:
			for (Person person : people)
				if (!values.contains(person.getEducation()) && !person.getEducation().equals("?"))
					values.add(person.getEducation());
			break;
		case 4:
			for (Person person : people)
				tempValues.add(person.getEducationNum());

			Collections.sort(tempValues);
			values.add((tempValues.firstElement() - 1) + "-" + tempValues.get((tempValues.size() / 2)));
			values.add(tempValues.get((tempValues.size() / 2)) + "-" + (tempValues.lastElement()+1));
			break;
		case 5:
			for (Person person : people)
				if (!values.contains(person.getMaritalStatus()) && !person.getMaritalStatus().equals("?"))
					values.add(person.getMaritalStatus());
			break;
		case 6:
			for (Person person : people)
				if (!values.contains(person.getOccupation()) && !person.getOccupation().equals("?"))
					values.add(person.getOccupation());
			break;
		case 7:
			for (Person person : people)
				if (!values.contains(person.getRelationship()) && !person.getRelationship().equals("?"))
					values.add(person.getRelationship());
			break;
		case 8:
			for (Person person : people)
				if (!values.contains(person.getRace()) && !person.getRace().equals("?"))
					values.add(person.getRace());
			break;
		case 9:
			for (Person person : people)
				if (!values.contains(person.getSex()) && !person.getSex().equals("?"))
					values.add(person.getSex());
			break;
		case 10:
			for (Person person : people)
				tempValues.add(person.getCapitalGain());

			Collections.sort(tempValues);
			values.add("0-1");
			values.add("1-3000");
			values.add("3000-" + (tempValues.lastElement() + 1));

			break;
		case 11:
			for (Person person : people)
				tempValues.add(person.getCapitalLoss());

			Collections.sort(tempValues);
			values.add((tempValues.firstElement()) + "-" + (tempValues.get((tempValues.size() / 2))+1));
			values.add((tempValues.get((tempValues.size() / 2))+1) + "-" + (tempValues.lastElement() + 1));
			break;
		case 12:
			for (Person person : people)
				tempValues.add(person.getHoursPerWeek());

			Collections.sort(tempValues);
			values.add(0 + "-" + tempValues.get((tempValues.size() / 2)));
			values.add(tempValues.get((tempValues.size() / 2)) + "-" + (tempValues.lastElement() + 1));
			break;
		case 13:
			for (Person person : people)
				if (!values.contains(person.getNativeCountry()) && !person.getNativeCountry().equals("?"))
					values.add(person.getNativeCountry());
			break;
		}

		return values;
	}

	public static void comparableData(Vector<Person> people, String outPath) {

		Vector<String> results = new Vector<String>();
		int i = 0;

		for (Person person : people) {
			i++;
			results.add(i + "," + person.toString());
		}

		try {
			FileWriter writer = new FileWriter(outPath);
			writer.write("Id,Target");
			writer.write(System.lineSeparator());
			for (String result : results) {
				writer.write(result);
				writer.write(System.lineSeparator());
			}
			writer.close();
		} catch (Exception e) {
			System.out.println("File error");
		}
	}
	
	private static boolean tryParseInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch (NumberFormatException e) {
			return false;
		}
	}
}
