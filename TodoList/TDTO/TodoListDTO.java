package TDTO;

public class TodoListDTO {
	String owwnerID;
	String task;
	int taskStatus;
	String deadline;
	int tId;
	public static final int TASK_COMPLETE = 3;
	public static final int TASK_DOING = 2;
	public static final int TASK_DO = 1;
	public TodoListDTO() {
		
	}
	
	public TodoListDTO(String ownnerID, String task, int taskStatus, String deadline, int tId) {
		this.owwnerID = ownnerID;
		this.task = task;
		this.taskStatus = taskStatus;
		this.deadline = deadline;
		this.tId = tId;
	}
	public String getOwwnerID() {
		return owwnerID;
	}

	public void setOwwnerID(String owwnerID) {
		this.owwnerID = owwnerID;
	}

	public String getTask() {
		return task;
	}

	public void setTask(String task) {
		this.task = task;
	}

	public int getTaskStatus() {
		return taskStatus;
	}

	public void setTaskStatus(int taskStatus) {
		this.taskStatus = taskStatus;
	}

	public String getDeadline() {
		return deadline;
	}

	public void setDeadline(String deadline) {
		this.deadline = deadline;
	}

	public int gettId() {
		return tId;
	}

	public void settId(int tId) {
		this.tId = tId;
	}
	
}
