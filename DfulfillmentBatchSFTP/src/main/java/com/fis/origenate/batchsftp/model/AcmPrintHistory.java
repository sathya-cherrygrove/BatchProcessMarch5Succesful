package com.fis.origenate.batchsftp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ACM_PRINT_HISTORY")
public class AcmPrintHistory {

	@Id
	@Column(name="PRINT_HISTORY_ID")
    private Integer print_history_id;

	@Column(name = "REQUEST_ID ")
	private Integer request_id;

	public Integer getPrint_history_id() {
		return print_history_id;
	}

	public void setPrint_history_id(Integer print_history_id) {
		this.print_history_id = print_history_id;
	}

	public Integer getRequest_id() {
		return request_id;
	}

	public void setRequest_id(Integer request_id) {
		this.request_id = request_id;
	}

}
