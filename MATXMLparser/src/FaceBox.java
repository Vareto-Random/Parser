
public class FaceBox {
	public FaceBox() {
		this.name = null;
		this.a = null;
		this.b = null;
		this.c = null;
		this.d = null;
	}

	public FaceBox(String _name, String _a, String _b, String _c, String _d) {
		this.setName(_name);
		this.setA(_a);
		this.setB(_b);
		this.setC(_c);
		this.setD(_d);
	}

	public final String getName() {
		return name;
	}

	public final void setName(String _name) {
		this.name = _name;
	}

	public final String getA() {
		return a;
	}

	public final void setA(String _a) {
		this.a = _a;
	}

	public final String getB() {
		return b;
	}

	public final void setB(String _b) {
		this.b = _b;
	}

	public final String getC() {
		return c;
	}

	public final void setC(String _c) {
		this.c = _c;
	}

	public final String getD() {
		return d;
	}

	public final void setD(String _d) {
		this.d = _d;
	}

	public final String toString() {
		return this.getName() + " " + this.getA() + " " + this.getB() + " " + this.getC() + " " + this.getD();
	}

	private String name;
	private String a;
	private String b;
	private String c;
	private String d;
}
