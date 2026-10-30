package campus_IT_help_desk;

public class DeviceSetupRequest extends AbstractSupportRequest{
	private int deviceCount;
	
	@Override
	public int resolveFor(Technician technician)
	{
		if(isResolved())
		{
			throw new IllegalStateException();
		}
		this.resolved = true;
		
		int points = getBasePoints() * deviceCount;
		technician.addPoints(points);
		return points;
	}
	
	public DeviceSetupRequest(int id, String title, int basePoints, int count)
	{
		super(id, title, basePoints);
		
		if(count > 0)
		{
			this.deviceCount = count;
		}
		else
		{
			throw new IllegalArgumentException();
		}
	}

}
