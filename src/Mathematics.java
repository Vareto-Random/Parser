import java.util.ArrayList;

@SuppressWarnings({ "unchecked", "rawtypes" })
public abstract class Mathematics {

	public static double distance2points(Pair p1, Pair p2) {
		double p1A = (double) p1.getA();
		double p1B = (double) p1.getB();

		double p2A = (double) p2.getA();
		double p2B = (double) p2.getB();

		return Math.hypot(p1A - p2A, p1B - p2B);
	}

	public static double arrayAverage(ArrayList<Double> array) {
		if (array.size() <= 0) {
			return 0.0;
		}

		double sum = 0;
		for (double element : array) {
			sum += element;
		}

		return (sum / array.size());
	}

	public static Pair minimumValues(ArrayList<Pair> array) {
		double minA = Double.MAX_VALUE;
		double minB = Double.MAX_VALUE;

		for (Pair tuple : array) {
			if ((double) tuple.getA() < minA) {
				minA = (double) tuple.getA();
			}

			if ((double) tuple.getB() < minB) {
				minB = (double) tuple.getB();
			}
		}

		return new Pair(minA, minB);
	}
}
