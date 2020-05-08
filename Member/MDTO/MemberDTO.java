package MDTO;

public class MemberDTO {
	String member_id;
	String member_pw;
	String member_name;
	
	public MemberDTO() {
		
	}
	public MemberDTO(String id, String pw, String name) {
		this.member_id = id;
		this.member_pw = pw;
		this.member_name = name;
	}
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
}
