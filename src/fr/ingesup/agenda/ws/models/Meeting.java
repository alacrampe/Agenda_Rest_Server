
package fr.ingesup.agenda.ws.models;

import java.util.List;

public class Meeting extends Event {

	public Meeting() {
		this.type = Type.M;
	}
	
	private PointInTime pointBegin;
	private PointInTime pointEnd;
	private List<String> participants;
	
	public PointInTime getPointBegin() {
		return pointBegin;
	}
	public void setPointBegin(PointInTime pointBegin) {
		this.pointBegin = pointBegin;
	}
	public PointInTime getPointEnd() {
		return pointEnd;
	}
	public void setPointEnd(PointInTime pointEnd) {
		this.pointEnd = pointEnd;
	}
	public List<String> getParticipants() {
		return participants;
	}
	public void setParticipants(List<String> participants) {
		this.participants = participants;
	}
	
}

