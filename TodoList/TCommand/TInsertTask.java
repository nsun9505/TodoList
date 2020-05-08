package TCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TDAO.TodoListDAO;
import TDTO.TodoListDTO;
import jsp_project.Command;

public class TInsertTask implements Command{
	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String ownnerId = request.getParameter("id");
		String task = request.getParameter("task");
		String date = request.getParameter("deadline");
		
		TodoListDAO dao = new TodoListDAO();
		dao.insertTask(ownnerId, task, TodoListDTO.TASK_DO, date);
		return 0;
	}
}
