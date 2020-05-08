import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MCommand.MDeleteCommand;
import MCommand.MIdCheckCommand;
import MCommand.MInsertCommand;
import MCommand.MLoginCheckCommand;
import MCommand.MUpdatePassCommand;
import jsp_project.Command;
import TCommand.TDeleteAllTask;
import TCommand.TDeleteTask;
import TCommand.TDeleteTodoByStatus;
import TCommand.TInsertTask;
import TCommand.TListTask;
import TCommand.TUpdateTask;

/**
 * Servlet implementation class MemberFrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		actionDo(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		actionDo(request, response);
	}
	
	private void actionDo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("EUC-KR");
		
		String viewPage = null;
		Command cmd = null;
		
		String uri = request.getRequestURI();
		String conPath = request.getContextPath();
		String com = uri.substring(conPath.length());
		
		if(com.equals("/loginCheck.do")) {
			cmd = new MLoginCheckCommand();
			int ret = cmd.execute(request, response);
			if(ret == 1) viewPage = "loginOk.jsp";
			else viewPage = "loginFail.jsp";
		}
		else if(com.equals("/joinOk.do")) {
			cmd = new MInsertCommand();
			int ret = cmd.execute(request, response);
			viewPage="joinOk.jsp";
		}
		else if(com.equals("/idCheck.do")) {
			cmd = new MIdCheckCommand();
			int ret = cmd.execute(request, response);
			if(ret == 1) viewPage="idCheckOk.jsp";
			else viewPage = "idCheckFail.jsp";
		}
		else if(com.equals("/insertTask.do")) {
			cmd = new TInsertTask();
			int ret = cmd.execute(request, response);
			viewPage = "list.do";
		}
		else if(com.equals("/list.do")) {
			cmd = new TListTask();
			int ret = cmd.execute(request, response);
			viewPage = "list.jsp";
		}
		else if(com.equals("/updateTodo.do")) {
			cmd = new TUpdateTask();
			int ret = cmd.execute(request, response);
			viewPage = "list.do";
		}
		else if(com.equals("/deleteTodo.do")) {
			cmd = new TDeleteTask();
			int ret = cmd.execute(request, response);
			viewPage = "list.do";
		}
		else if(com.equals("/deleteTodoByStatus.do")) {
			cmd = new TDeleteTodoByStatus();
			int ret = cmd.execute(request, response);
			viewPage = "list.do";
		}
		else if(com.equals("/deleteAllTask.do")) {
			cmd = new TDeleteAllTask();
			int ret = cmd.execute(request, response);
			viewPage = "MemberDeleteOk.jsp";
		}
		else if(com.equals("/memberDelete.do")) {
			cmd = new MDeleteCommand();
			int ret = cmd.execute(request, response);
			if(ret == 1) viewPage = "deleteAllTask.do";
			else viewPage = "MemberDeleteFail.jsp";
		}
		else if(com.equals("/memberModify.do")) {
			cmd = new MUpdatePassCommand();
			int ret = cmd.execute(request, response);
			viewPage = "passUpdateOk.jsp";
		}
		else {
			viewPage = "notExistCommand.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);
		return;
	}

}
