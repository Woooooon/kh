package com.kh.member.vo;

public class MemberVo {

	private String memberId;
	private String memberPwd;
	public MemberVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public MemberVo(String memberId, String memberPwd) {
		super();
		this.memberId = memberId;
		this.memberPwd = memberPwd;
	}
	@Override
	public String toString() {
		return "MemberVo [memberId=" + memberId + ", memberPwd=" + memberPwd + "]";
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	
	
	
	
}
