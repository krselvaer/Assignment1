package no.uis.dat630;

import java.util.Vector;

public class DTreeNode {

	private DTreeNode parent;
	private Vector<DTreeNode> children;
	private Attribute attribute;
	private String label;
	private Vector<String> edgeValues;
	
	public DTreeNode(Attribute attribute) {
		this.attribute = attribute;
		parent = null;
		label = null;
		children = new Vector<DTreeNode>();
		edgeValues = new Vector<String>();
	}

	public DTreeNode() {
		attribute = null;
		parent = null;
		label = null;
		children = new Vector<DTreeNode>();
		edgeValues = new Vector<String>();
	}

	public DTreeNode(Attribute attribute, DTreeNode parent) {
		this.attribute = attribute;
		this.parent = parent;

	}

	public DTreeNode getParent() {
		return parent;
	}

	public void setParent(DTreeNode parent) {
		this.parent = parent;
	}

	public Attribute getAttribute() {
		return attribute;
	}

	public void setAttribute(Attribute attribute) {
		this.attribute = attribute;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public Vector<DTreeNode> getChildren() {
		return children;
	}

	public void setChildren(Vector<DTreeNode> children) {
		this.children = children;
	}
	
	public void addChild(DTreeNode child) {
		children.addElement(child);
	}

	public Vector<String> getEdgeValues() {
		return edgeValues;
	}

	public void setEdgeValues(Vector<String> edgeValues) {
		this.edgeValues = edgeValues;
	}
	
	public void addEdgeValues(String value) {
		edgeValues.addElement(value);
	}
}
