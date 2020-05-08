package TCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TDAO.TodoListDAO;
import jsp_project.Command;

public class TDeleteTodoByStatus implements Command{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		int status = Integer.parseInt(request.getParameter("status"));
		System.out.println(status+" "+id);
		TodoListDAO dao = new TodoListDAO();
		int ret = dao.deleteTaskByStatus(id, status);
		return 0;
	}

}
