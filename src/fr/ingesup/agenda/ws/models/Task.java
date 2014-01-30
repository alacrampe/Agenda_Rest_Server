package fr.ingesup.agenda.ws.models;

public class Task extends Event {
	
	public Task() {
		this.type = Type.T;
	}
	
	private PointInTime pointBegin;
	private PointInTime pointEnd;
	
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
}
