package rkv.team.seminar;

import java.io.Serializable;

final class Message<T extends Serializable> implements Serializable {
	private T payload;
	private String tag;

	public Message() {
		super();
	}

	public Message(T data, String tag) {
		super();
		this.tag = tag;
		setPayload(data);
	}

	public String getTag() {
		return tag;
	}

	public T getPayload() {
		return payload;
	}

	public void setPayload(T aPayload) {
		payload = aPayload;
	}
}