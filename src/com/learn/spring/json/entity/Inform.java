package com.learn.spring.json.entity;

import java.io.Serializable;
import java.sql.Timestamp;

public class Inform implements Serializable{
	private Integer info_id;
	private String inform_title;
	private String inform_content;
	private Timestamp inform_time;
	public Integer getInfo_id() {
		return info_id;
	}
	public void setInfo_id(Integer info_id) {
		this.info_id = info_id;
	}
	public String getInform_title() {
		return inform_title;
	}
	public void setInform_title(String inform_title) {
		this.inform_title = inform_title;
	}
	public String getInform_content() {
		return inform_content;
	}
	public void setInform_content(String inform_content) {
		this.inform_content = inform_content;
	}
	public Timestamp getInform_time() {
		return inform_time;
	}
	public void setInform_time(Timestamp inform_time) {
		this.inform_time = inform_time;
	}
	@Override
	public String toString() {
		return "Inform [info_id=" + info_id + ", inform_title=" + inform_title + ", inform_content=" + inform_content
				+ ", inform_time=" + inform_time + "]";
	}
}
