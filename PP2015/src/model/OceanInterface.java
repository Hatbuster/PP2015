package model;

import java.util.LinkedList;

public interface OceanInterface {
	
	public int getWidth();
	public void setWidth(int width);
	public int getDepth();
	public void setDepth(int depth);
	public LinkedList<OceanObject> getOceanObjects();
	public void setOceanObjects(LinkedList<OceanObject> oceanObjects);
	public void move();
	@Override
	public String toString();

}
