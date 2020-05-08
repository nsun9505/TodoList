package MCommand;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import MDAO.MemberDAO;
import jsp_project.Command;

public class MLoginCheckCommand implements Command{
	@Override
	public int execute(HttpServletRequest request, HttpServletResponse response) {
		// TODO Auto-generated method stub
		String user_id = request.getParameter("id");
		String user_pw = request.getParameter("pw");
		
		MemberDAO dao = new MemberDAO();
		int ret = dao.memberCheck(user_id, user_pw);
		return ret;
	}

}
