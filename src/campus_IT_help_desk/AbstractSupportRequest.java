package campus_IT_help_desk;

public abstract class AbstractSupportRequest implements SupportRequest {
	private final int id;
	private final String title;
	private final int basePoints;
	protected boolean resolved;
	
	public AbstractSupportRequest(int id, String title, int basePoints) {
		if (id <= 0) { throw new IllegalArgumentException("ID must be positive."); }
		if (title == null || title.isBlank()) { throw new IllegalArgumentException("Title cannot be null or blank."); }
		if (basePoints <= 0) { throw new IllegalArgumentException("Base points must be positive."); }
		
		this.id = id;
		this.title = title;
		this.basePoints = basePoints;
		this.resolved = false;
	}
	
	// GETTERS
	@Override
	public int getId() { return id; }
	
	@Override
	public String getTitle() { return title; }
	
	@Override
	public int getBasePoints() { return basePoints; }
	
	@Override
	public boolean isResolved() { return resolved; }
	
    protected int completeResolution(Technician technician, int points) {
        if (technician == null) { throw new IllegalArgumentException("Technician cannot be null."); }

        // rule enforced which request can only be resolved once.
        if (resolved) { throw new IllegalStateException("Request is already resolved."); }

        if (points <= 0) { throw new IllegalArgumentException("Awarded points must be positive."); }

        technician.addPoints(points);
        resolved = true;

        return points;
    }
    
    @Override
    public abstract int resolveFor(Technician technician);

    @Override
    public String toString() {
        return "Request [id=" + id + ", title=" + title
                + ", basePoints=" + basePoints + ", resolved=" + resolved + "]"; }
}
