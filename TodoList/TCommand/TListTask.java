package TCommand;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import TDAO.TodoListDAO;
import TDTO.TodoListDTO;
import jsp_project.Command;

public class TListTask implements Command{
	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		System.out.println(id);
		TodoListDAO dao = new TodoListDAO();
		ArrayList<TodoListDTO> dtos = dao.getListById(id);
		request.setAttribute("list", dtos);
		return 0;
	}
}
