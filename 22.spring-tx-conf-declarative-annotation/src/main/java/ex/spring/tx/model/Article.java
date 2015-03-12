package ex.spring.tx.model;

import java.util.Calendar;
import java.util.Date;

public class Article {
	private String seq;
	private int board_seq;
	private int user_seq;
	private String title;
	private String content;
	private Date reg_dt;
	
	public Article(){};
	
	public Article(int boardSeq, String title, String content, int userSeq) {
		this.board_seq = boardSeq;
		this.title = title;
		this.content = content;
		this.user_seq = userSeq;
		this.reg_dt = Calendar.getInstance().getTime();
	}
	
	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public int getBoard_seq() {
		return board_seq;
	}

	public void setBoard_seq(int board_seq) {
		this.board_seq = board_seq;
	}

	public int getUser_seq() {
		return user_seq;
	}

	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getReg_dt() {
		return reg_dt;
	}

	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}

	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("seq : ").append(seq).append(", ")
			.append("title : ").append(title).append(", ")
			.append("content : ").append(content).append("\n");
		return sb.toString();
	}
}
