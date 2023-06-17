package com.internetdb.wepapp.Dto;

public class CommentReq {
	private int user_idx;
	private int post_idx;
	private String comment;
	
	public CommentReq(int user_idx, int post_idx, String comment) {
		super();
		this.user_idx = user_idx;
		this.post_idx = post_idx;
		this.comment = comment;
	}
	
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public int getPost_idx() {
		return post_idx;
	}
	public void setPost_idx(int post_idx) {
		this.post_idx = post_idx;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
