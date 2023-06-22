package com.internetdb.wepapp.Dto;

public class LikeRes {
	private int post_idx;
	private int like_count;
	
	public int getPost_idx() {
		return post_idx;
	}
	public void setPost_idx(int post_idx) {
		this.post_idx = post_idx;
	}
	public int getLike_count() {
		return like_count;
	}
	public void setLike_count(int like_count) {
		this.like_count = like_count;
	}
	public LikeRes(int post_idx, int like_count) {
		this.post_idx = post_idx;
		this.like_count = like_count;
	}
}
