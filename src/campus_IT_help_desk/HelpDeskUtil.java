package campus_IT_help_desk;

import java.util.List;

public final class HelpDeskUtil {

	// All methods are static, no point to have a public constructor
	private HelpDeskUtil() {
	}

	public static <T> void printAll(List<T> items) {
		for (T item : items) {
			System.out.println(item);
		}
	}

	public static int sumPoints(List<? extends Technician> technicians) {
		int total = 0;
		for (Technician tech : technicians) {
			total += tech.getServicePoints();
		}
		return total;
	}
}