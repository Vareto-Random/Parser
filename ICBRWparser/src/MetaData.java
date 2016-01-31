public class MetaData {
	public MetaData() {
		this.name = null;
		this.a = null;
		this.b = null;
		this.c = null;
		this.d = null;
	}

	public MetaData(String _name, String _a, String _b, String _c, String _d) {
		this.setName(_name);
		this.setA(_a);
		this.setB(_b);
		this.setC(_c);
		this.setD(_d);
	}

	public final String getName() {
		return name;
	}

	public final void setName(String name) {
		this.name = name;
	}

	public final String getA() {
		return a;
	}

	public final void setA(String a) {
		this.a = a;
	}

	public final String getB() {
		return b;
	}

	public final void setB(String b) {
		this.b = b;
	}

	public final String getC() {
		return c;
	}

	public final void setC(String c) {
		this.c = c;
	}

	public final String getD() {
		return d;
	}

	public final void setD(String d) {
		this.d = d;
	}

	public String toString() {
		return this.getName() + " " + this.getA() + " " + this.getB() + " " + this.getC() + " " + this.getD();
	}

	private String name;
	private String a;
	private String b;
	private String c;
	private String d;
}