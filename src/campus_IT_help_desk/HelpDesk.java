package campus_IT_help_desk;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HelpDesk {
	private final Map<Integer, SupportRequest> requestsById;
	private final Map<Technician, List<SupportRequest>> assignments;

	public HelpDesk() {
		requestsById = new HashMap<>();
		assignments = new HashMap<>();
	}

	public void addRequest(SupportRequest request) {
		if (request == null) {
			throw new IllegalArgumentException("Request cannot be null!");
		}
		int id = request.getId();
		if (requestsById.containsKey(id)) {
			throw new IllegalArgumentException("Duplicate request ID: + id");
		}

		requestsById.put(id, request);
	}

	public SupportRequest findRequest(int id) {
		return requestsById.get(id);
	}

	public void assignRequest(Technician technician, int requestId) {
		if (technician == null) {
			throw new IllegalArgumentException("Technician cannot be null!");
		}

		SupportRequest request = findRequest(requestId);
		if (request == null) {
			throw new IllegalArgumentException("No request with ID " + request);
		}

		List<SupportRequest> techRequests = assignments.get(technician);
		if (techRequests == null) {
			techRequests = new ArrayList<>();
			assignments.put(technician, techRequests);
		}

		if (techRequests.contains(request)) {
			throw new IllegalArgumentException("Request " + requestId + " is already assigned to this technician");
		}

		techRequests.add(request);
	}

	public int resolveRequest(Technician technician, int requestId) {
		List<SupportRequest> techRequests = assignments.get(technician);
		if (techRequests == null) {
			throw new IllegalArgumentException("Technician has no assignments");
		}

		SupportRequest target = null;
		// r is each request in the List
		for (SupportRequest r : techRequests) {
			if (r.getId() == requestId) {
				target = r;
				break;
			}
		}

		if (target == null) {
			throw new IllegalArgumentException("Request " + requestId + " is not assigned to this technician");
		}

		int points = target.resolveFor(technician);
		techRequests.remove(target);
		return points;
	}

	public void printAllRequests() {
		if (requestsById.isEmpty()) {
			System.out.println("No requests.");
			return;
		}
		for (SupportRequest r : requestsById.values()) {
			System.out.println(r);
		}
	}

	public void printAssignmentsFor(Technician technician) {
        List<SupportRequest> techRequests = assignments.get(technician);
        System.out.println("Assignments for " + technician + ":");
        if (techRequests == null || techRequests.isEmpty()) {
            System.out.println("  (none)");
            return;
        }
        for (SupportRequest r : techRequests) {
            System.out.println("  " + r);
        }
	}
}
