package campus_IT_help_desk;

public class Technician {
	private final String name;
	private int servicePoints;
	
	public Technician(String name) {
        if (name == null || name.isBlank()) { throw new IllegalArgumentException(
        		"Technician name cannot be null or blank."); }

        this.name = name;
        this.servicePoints = 0;
	}
	
	// GETTERS
	public String getName() { return name; }
	public int getServicePoints() { return servicePoints; }
	
    public void addPoints(int amount) {
        if (amount < 0) { throw new IllegalArgumentException(
        		"Points added cannot be negative."); }

        // Prevent integer overflow from making the total negative.
        if (amount > Integer.MAX_VALUE - servicePoints) { throw new IllegalArgumentException(
        		"Service point total is too large."); }

        servicePoints += amount;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) { return true; }
        if (!(obj instanceof Technician)) { return false; }

        Technician other = (Technician) obj;
        return name.equals(other.name);
    }
    
    @Override
    public int hashCode() { return name.hashCode(); }
    
    @Override
    public String toString() { return "Technician [name=" + name
    		+ ", servicePoints=" + servicePoints + "]"; }
}
