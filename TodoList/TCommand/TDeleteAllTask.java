package TCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TDAO.TodoListDAO;
import jsp_project.Command;

public class TDeleteAllTask implements Command{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		TodoListDAO dao = new TodoListDAO();
		dao.deleteAllTask(id);
		return 0;
	}

}
