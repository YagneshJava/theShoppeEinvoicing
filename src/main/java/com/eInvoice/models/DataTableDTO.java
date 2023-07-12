package com.eInvoice.models;

import java.util.List;

import org.springframework.data.domain.Page;

public class DataTableDTO {

	private int draw;
	private int start;
	private long recordsTotal;
	private long recordsFiltered;
	private List<?> data;

	public int getDraw() {
		return draw;
	}

	public void setDraw(int draw) {
		this.draw = draw;
	}

	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public long getRecordsTotal() {
		return recordsTotal;
	}

	public void setRecordsTotal(long recordsTotal) {
		this.recordsTotal = recordsTotal;
	}

	public long getRecordsFiltered() {
		return recordsFiltered;
	}

	public void setRecordsFiltered(long recordsFiltered) {
		this.recordsFiltered = recordsFiltered;
	}

	public List<?> getData() {
		return data;
	}

	public void setData(List<?> list) {
		this.data = list;
	}

	public static DataTableDTO toDataTable(Page<?> page, int draw, int start) {
		DataTableDTO dataTableResponse = new DataTableDTO();
		if (null != page) {
			dataTableResponse.setData(page.getContent());
			dataTableResponse.setRecordsTotal(page.getTotalElements());
			dataTableResponse.setRecordsFiltered(page.getTotalElements());
			dataTableResponse.setDraw(draw);
			dataTableResponse.setStart(start);
		}
		return dataTableResponse;
	}
}
