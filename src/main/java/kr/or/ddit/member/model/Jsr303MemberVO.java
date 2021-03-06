package kr.or.ddit.member.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotEmpty;

/**
 * Jsr303MemberVO.java
 *
 * @author "K.S.J"
 * @since 2018. 5. 28.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *
 * 수정일 수정자 수정내용
 * ---------- ------ ------------------------
 * 2018. 5. 28. "K.S.J" 최초 생성
 *
 * </pre>
 */
public class Jsr303MemberVO {
	
	@NotEmpty
	private String mem_id;
	@NotEmpty
	private String mem_pass;
	
	private String mem_name;
	private String mem_add1;
	private String mem_add2;
	private String mem_zip;
	private Date mem_bir;
	private String mem_alias;
	private String mem_profile;
	
	@Override
	public String toString() {
		return "MemberVO [mem_id=" + mem_id + ", mem_pass=" + mem_pass
				+ ", mem_name=" + mem_name + ", mem_add1=" + mem_add1
				+ ", mem_add2=" + mem_add2 + ", mem_zip=" + mem_zip
				+ ", mem_bir=" + mem_bir + ", mem_alias=" + mem_alias
				+ ", mem_profile=" + mem_profile + "]";
	}
	
	public String getMem_id() {
		return mem_id;
	}
	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	public String getMem_pass() {
		return mem_pass;
	}
	public void setMem_pass(String mem_pass) {
		this.mem_pass = mem_pass;
	}
	public String getMem_name() {
		return mem_name;
	}
	public void setMem_name(String mem_name) {
		this.mem_name = mem_name;
	}
	public String getMem_add1() {
		return mem_add1;
	}
	public void setMem_add1(String mem_add1) {
		this.mem_add1 = mem_add1;
	}
	public String getMem_add2() {
		return mem_add2;
	}
	public void setMem_add2(String mem_add2) {
		this.mem_add2 = mem_add2;
	}
	public String getMem_zip() {
		return mem_zip;
	}
	public void setMem_zip(String mem_zip) {
		this.mem_zip = mem_zip;
	}
	public Date getMem_bir() {
		return mem_bir;
	}
	public void setMem_bir(Date mem_bir) {
		this.mem_bir = mem_bir;
	}
	public String getMem_alias() {
		return mem_alias;
	}
	public void setMem_alias(String mem_alias) {
		this.mem_alias = mem_alias;
	}
	public String getMem_profile() {
		return mem_profile;
	}
	public void setMem_profile(String mem_profile) {
		this.mem_profile = mem_profile;
	}

	/**
	 * Method : passwordVerify
	 * 최초작성일 : 2018. 5. 24.
	 * 작성자 : "K.S.J"
	 * 변경이력 :
	 * @param memberVO
	 * @return
	 * Method 설명 : 사용자 비밀번호 검증
	 */
	public boolean passwordVerify(Jsr303MemberVO memberVO) {
		if (memberVO == null) {
			return false;
		}
		
		if (this.mem_pass.equals(memberVO.getMem_pass()) && this.mem_id.equals(memberVO.getMem_id())) {
			return true;
		}
		return false;
	}
}
