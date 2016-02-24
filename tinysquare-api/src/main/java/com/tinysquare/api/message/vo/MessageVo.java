package com.tinysquare.api.message.vo;

import java.io.Serializable;

public class MessageVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long objId;

	private String title;

	private String content;

	private String entrydate;

	public MessageVo() {

	}

	public MessageVo(Long objId, String title, String content, String entrydate) {
		super();
		this.objId = objId;
		this.title = title;
		this.content = content;
		this.entrydate = entrydate;
	}

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
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

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

}
