package no.uis.dat630;

public class DTreeNode {

	private DTreeNode[] children;
	private DTreeNode parent;
	private Attribute attribute;

	public DTreeNode(Attribute attribute) {
		this.attribute = attribute;
		parent = null;
		children = null;
	}
	
	public DTreeNode() {
		attribute = null;
		parent = null;
		children = null;
	}

	public DTreeNode(Attribute attribute, DTreeNode parent) {
		this.attribute = attribute;
		this.parent = parent;

	}

	public DTreeNode[] getChildren() {
		return children;
	}

	public void setChildren(DTreeNode[] children) {
		this.children = children;
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

}
