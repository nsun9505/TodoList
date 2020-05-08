package TCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TDAO.TodoListDAO;
import jsp_project.Command;

public class TDeleteTask implements Command{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String ownnerId = request.getParameter("id");
		int taskId = Integer.parseInt(request.getParameter("taskId"));
		
		TodoListDAO dao = new TodoListDAO();
		dao.deleteTask(ownnerId, taskId);
		return 0;
	}

}
