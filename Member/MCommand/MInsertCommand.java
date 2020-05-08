package MCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MDAO.MemberDAO;
import jsp_project.Command;

public class MInsertCommand implements Command{
	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String user_name = request.getParameter("name");
		String user_id = request.getParameter("id");
		String user_pw = request.getParameter("pw");
		System.out.println(user_name + " " + user_id + " " + user_pw);
		MemberDAO dao = new MemberDAO();
		return dao.inserMember(user_id, user_pw, user_name);
	}
}
