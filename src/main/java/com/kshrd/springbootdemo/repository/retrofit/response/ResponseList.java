package com.kshrd.springbootdemo.repository.retrofit.response;

import com.kshrd.springbootdemo.utility.Paging;

public class ResponseList<T> extends Response{
	
	private T data;
	
	private Paging paging;
	
	public ResponseList(String message, T data, Paging paging) {
		super(message);
		this.data = data;
		this.paging = paging;
	}

	public T getData() {
		return data;
	}
	public void setData(T data) {
		this.data = data;
	}
	public Paging getPaging() {
		return paging;
	}
	public void setPaging(Paging paging) {
		this.paging = paging;
	}
	
	@Override
	public String toString() {
		return "Response [data=" + data + ", paging=" + paging + "]";
	}
	
}
