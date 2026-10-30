package campus_IT_help_desk;

import java.util.List;
import java.util.ArrayList;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Technician tech1 = new Technician("Jeff");
		Technician tech2 = new Technician("Mary");
		Technician tech3 = new Technician("Jeff");
		
		AbstractSupportRequest req1 = new NetworkIssueRequest(1, "Network Down", 10, 5);
		AbstractSupportRequest req2 = new NetworkIssueRequest(2, "Can't Connect", 8, 3);
		AbstractSupportRequest req3 = new PasswordResetRequest(3, "Forgot Password", 10, "Marla");
		AbstractSupportRequest req4 = new PasswordResetRequest(4, "Can't remember Password", 15, "Larry");
		AbstractSupportRequest req5 = new DeviceSetupRequest(5, "New Computers", 12, 4);
		AbstractSupportRequest req6 = new DeviceSetupRequest(6, "Update Software", 20, 8);
		
		HelpDesk helpDesk = new HelpDesk();
		
		helpDesk.addRequest(req1);
		helpDesk.addRequest(req2);
		helpDesk.addRequest(req3);
		helpDesk.addRequest(req5);
		
		helpDesk.assignRequest(tech1, 1);
		helpDesk.assignRequest(tech1, 3);
		helpDesk.assignRequest(tech2, 2);
		helpDesk.assignRequest(tech2, 5);
		
		helpDesk.resolveRequest(tech1, 1);
		helpDesk.resolveRequest(tech1, 3);
		helpDesk.resolveRequest(tech2, 5);
		//Fail-fast Display (try to resolve already resolved request)
		//Comment out the next line to get full main outputs
		helpDesk.resolveRequest(tech2, 5);
		
		System.out.println("PRINTING ALL REQUESTS");
		helpDesk.printAllRequests();
		
		System.out.println("ASSIGNMENTS FOR EACH TECHNICIAN");
		helpDesk.printAssignmentsFor(tech1);
		helpDesk.printAssignmentsFor(tech2);
		helpDesk.printAssignmentsFor(tech3);
		
		System.out.println("PRINTING ALL TECHNICIAN POINTS");
		System.out.println("Technician 1: " + tech1.getServicePoints());
		System.out.println("Technician 2: " + tech2.getServicePoints());
		System.out.println("Technician 3: " + tech3.getServicePoints());
		
		System.out.println("PRINTING TOTAL POINTS");
		List<Technician> allTechs = new ArrayList<>();
		allTechs.add(tech1);
		allTechs.add(tech2);
		allTechs.add(tech3);
		System.out.println(HelpDeskUtil.sumPoints(allTechs));
		

	}

}
