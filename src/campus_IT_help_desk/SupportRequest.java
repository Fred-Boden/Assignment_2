package campus_IT_help_desk;

public interface SupportRequest {
	int getId();
	String getTitle();
	int getBasePoints();
	boolean isResolved();
	int resolveFor(Technician technician);
}