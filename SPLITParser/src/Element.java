
public class Element {

	public Element() {
		
	}
	
	public Element(int ID, String name, String x, String y) {
		
	}
	
	
	
	public final int getID() {
		return ID;
	}

	public final void setID(int iD) {
		ID = iD;
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getX() {
		return x;
	}

	public final void setX(String x) {
		this.x = x;
	}

	public final String getY() {
		return y;
	}

	public final void setY(String y) {
		this.y = y;
	}

	private int ID;
	private String name;
	private String x;
	private String y;
}
