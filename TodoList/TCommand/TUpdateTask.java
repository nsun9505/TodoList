package TCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TDAO.TodoListDAO;
import jsp_project.Command;

public class TUpdateTask implements Command{
	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String ownnerId = request.getParameter("id");
		String task = request.getParameter("todoTask");
		String date = request.getParameter("todoDate");
		int taskStatus = Integer.parseInt(request.getParameter("taskStatus"));
		int taskId = Integer.parseInt(request.getParameter("taskId"));

		TodoListDAO dao = new TodoListDAO();
		dao.updateTodo(ownnerId, task, taskStatus, date, taskId);
		return 0;
	}
	
}
