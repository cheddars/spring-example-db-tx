package ex.spring.tx.model;

import java.util.Date;

public class UserActionHistory {
	private int seq;
	private int user_seq;
	private String action_type;
	private String action_desc;
	private Date action_dt;
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public int getUser_seq() {
		return user_seq;
	}
	public void setUser_seq(int user_seq) {
		this.user_seq = user_seq;
	}
	public String getAction_type() {
		return action_type;
	}
	public void setAction_type(String action_type) {
		this.action_type = action_type;
	}
	public String getAction_desc() {
		return action_desc;
	}
	public void setAction_desc(String action_desc) {
		this.action_desc = action_desc;
	}
	public Date getAction_dt() {
		return action_dt;
	}
	public void setAction_dt(Date action_dt) {
		this.action_dt = action_dt;
	}
}
