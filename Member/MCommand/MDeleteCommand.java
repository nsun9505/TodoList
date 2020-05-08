package MCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MDAO.MemberDAO;
import jsp_project.Command;

public class MDeleteCommand implements Command{

	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		int ret = dao.deleteMember(id, pw);
		return ret;
	}

}
