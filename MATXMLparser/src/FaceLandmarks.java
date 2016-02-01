import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

@SuppressWarnings({ "unused", "rawtypes" })
public class FaceLandmarks {
	public FaceLandmarks() {
		this.name = null;
		this.points = new ArrayList<>();
	}
	
	public FaceLandmarks(String _name) {
		this.name = _name;
		this.points = new ArrayList<>();
	}
	
	public FaceLandmarks(String _name, ArrayList<Pair> _points) {
		this.name = _name;
		this.points = new ArrayList<>();
		for(Pair point : _points) {
			this.points.add(point);
		}
	}
	
	public final String getName() {
		return name;
	}

	public final void setName(String _name) {
		this.name = _name;
	}

	public final ArrayList<Pair> getPoints() {
		return points;
	}

	public final void setPoints(ArrayList<Pair> _points) {
		for(Pair point : _points) {
			this.points.add(point);
		}
	}

	public final String toString() {
		return this.getName() + "\n" + this.getPoints();
	}

	private String name;
	private ArrayList<Pair> points;
}
