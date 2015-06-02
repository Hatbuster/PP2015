package model;

public abstract class OceanObject {
	
	private int x;
	private int y;
	private String name;
	
	public OceanObject(int x, int y, String name) {
		this.x = x;
		this.y = y;
		this.name = name;
	}
	
	public abstract void move(int width, int depth);
	
	public String toString() {
		return "Name = " + name + "; position: x = " + x + "; y = " + y + "\n";
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
