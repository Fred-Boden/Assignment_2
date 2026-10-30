package campus_IT_help_desk;

public class NetworkIssueRequest extends AbstractSupportRequest {
	private int affectedUsers;
	
	@Override
	public int resolveFor(Technician technician)
	{
		if(isResolved())
		{
			throw new IllegalStateException();
		}
		this.resolved = true;
		
		//Choosing the Linear Rule (Base points plus affected users)
		int points = getBasePoints() + affectedUsers;
		technician.addPoints(points);
		return points;
	}
	
	public NetworkIssueRequest(int id, String title, int basePoints, int users)
	{
		super(id, title, basePoints);
		
		
		if(users > 0)
		{
			this.affectedUsers = users;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

}
