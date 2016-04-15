package com.tinysquare.api.message.vo;

import java.io.Serializable;

public class MessageVo implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long objId;

	private Long userId;

	private String title;

	private String subject;

	private String from;

	private String content;
	
	private Byte isRead;

	private String entrydate;

	public MessageVo() {

	}

	public MessageVo(Long objId, Long userId, String title, String subject, String from, String content, Byte isRead, String entrydate) {
		super();
		this.objId = objId;
		this.userId = userId;
		this.title = title;
		this.subject = subject;
		this.from = from;
		this.content = content;
		this.isRead = isRead;
		this.entrydate = entrydate;
	}

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getFrom() {
		return from;
	}

	public void setFrom(String from) {
		this.from = from;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Byte getIsRead() {
		return isRead;
	}

	public void setIsRead(Byte isRead) {
		this.isRead = isRead;
	}

	public String getEntrydate() {
		return entrydate;
	}

	public void setEntrydate(String entrydate) {
		this.entrydate = entrydate;
	}

}
