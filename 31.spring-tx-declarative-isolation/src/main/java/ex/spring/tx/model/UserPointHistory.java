package ex.spring.tx.model;

import java.util.Date;

public class UserPointHistory {
	private int seq;
	private int user_seq;
	private int initial_point;
	private int delta_point;
	private int result_point;
	private boolean canceled_yn;
	private Date reg_dt;
	
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
	public int getInitial_point() {
		return initial_point;
	}
	public void setInitial_point(int initial_point) {
		this.initial_point = initial_point;
	}
	public int getDelta_point() {
		return delta_point;
	}
	public void setDelta_point(int delta_point) {
		this.delta_point = delta_point;
	}
	public int getResult_point() {
		return result_point;
	}
	public void setResult_point(int result_point) {
		this.result_point = result_point;
	}
	public boolean isCanceled_yn() {
		return canceled_yn;
	}
	public void setCanceled_yn(boolean canceled_yn) {
		this.canceled_yn = canceled_yn;
	}
	public Date getReg_dt() {
		return reg_dt;
	}
	public void setReg_dt(Date reg_dt) {
		this.reg_dt = reg_dt;
	}
	
}
