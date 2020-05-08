package MCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MDAO.MemberDAO;
import jsp_project.Command;

public class MIdCheckCommand implements Command{
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		
		MemberDAO dao = new MemberDAO();
		int ret = dao.checkUserId(id);
		if(ret == 1)
			request.setAttribute("checkOkId", id);
		return ret;
	}
}
