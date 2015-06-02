package model;

import java.util.LinkedList;

public class Ocean implements OceanInterface {
	private int width;
	private int depth;
	private LinkedList<OceanObject> oceanObjects;

	public Ocean(int width, int depth, LinkedList<OceanObject> oceanObjects) {
		this.width = width;
		this.depth = depth;
		this.oceanObjects = oceanObjects;
	}

	public void move() {
		for (OceanObject o : oceanObjects) {
			o.move(width, depth);
		}
	}
	
	public String oceanObjectsToString() {
		String ret = "";
		for (OceanObject o : oceanObjects) {
			ret = ret + o.toString();
		}
		return ret;
	}

	public String toString() {
		return "Ocean: Width: " + this.width + ", Depth: " + this.depth + "\nObjects: \n" + oceanObjectsToString();
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getDepth() {
		return depth;
	}

	public void setDepth(int depth) {
		this.depth = depth;
	}

	@Override
	public LinkedList<OceanObject> getOceanObjects() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setOceanObjects(LinkedList<OceanObject> oceanObjects) {
		// TODO Auto-generated method stub
		
	}

}
