package no.uis.dat630;

import java.util.Vector;

public class Attribute {
	
	private int ID;
	private String label;
	private boolean numCat;
	private Vector<String> values;
	
	public Attribute (int ID) {
		this.ID = ID;
		label = null;
		numCat = false;
		values = new Vector<String>();
	}

	public Vector<String> getValues() {
		return values;
	}

	public void setValues(Vector<String> values) {
		this.values = values;
	}

	public int getID() {
		return ID;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public boolean isNumCat() {
		return numCat;
	}

	public void setNumCat(boolean numCat) {
		this.numCat = numCat;
	}
	
}