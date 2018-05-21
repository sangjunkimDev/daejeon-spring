package kr.or.ddit.spring.bean;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

public class BoardVo {
	private Integer board_seq;
	private String title;
	private String contents;
	private String reg_id;
	
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date reg_dt;
	
	@NumberFormat(pattern="#,###")
	private int readCnt;
	
	public Integer getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(Integer board_seq) {
		this.board_seq = board_seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getReg_id() {
		return reg_id;
	}

	public void setReg_id(String reg_id) {
		this.reg_id = reg_id;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	public int getReadCnt() {
		return readCnt;
	}

	public void setReadCnt(int readCnt) {
		this.readCnt = readCnt;
	}
	
}
