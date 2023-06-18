package com.internetdb.wepapp.Dto;

public class CommentRes {
	private int comment_idx;
	private int post_idx;
	private int user_idx;
	private String user_nickname;
	private String comment;
	
	public CommentRes(int comment_idx, int post_idx, int user_idx, String user_nickname, String comment) {
		this.comment_idx = comment_idx;
		this.post_idx = post_idx;
		this.user_idx = user_idx;
		this.user_nickname = user_nickname;
		this.comment = comment;
	}
	
	public String getUser_nickname() {
		return user_nickname;
	}
	public void setUser_nickname(String user_nickname) {
		this.user_nickname = user_nickname;
	}
	public int getComment_idx() {
		return comment_idx;
	}
	public void setComment_idx(int comment_idx) {
		this.comment_idx = comment_idx;
	}
	public int getPost_idx() {
		return post_idx;
	}
	public void setPost_idx(int post_idx) {
		this.post_idx = post_idx;
	}
	public int getUser_idx() {
		return user_idx;
	}
	public void setUser_idx(int user_idx) {
		this.user_idx = user_idx;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
}
