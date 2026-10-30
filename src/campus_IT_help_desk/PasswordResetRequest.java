package campus_IT_help_desk;

public class PasswordResetRequest extends AbstractSupportRequest {
	private String accountName;
	
	@Override
	public int resolveFor(Technician technician)
	{
		if(isResolved())
		{
			throw new IllegalStateException();
		}
		this.resolved = true;
		
		
		int points = getBasePoints();
		technician.addPoints(points);
		return points;
	}
	
	public PasswordResetRequest(int id, String title, int basePoints, String account)
	{
		super(id, title, basePoints);
		
		if(account != "" && account != null)
		{
			this.accountName = account;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}
}
