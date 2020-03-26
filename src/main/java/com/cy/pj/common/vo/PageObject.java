package com.cy.pj.common.vo;

import java.io.Serializable;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class PageObject<T> implements Serializable{

	private static final long serialVersionUID = 1536631092048817285L;
	
	private Integer pageCurrent=1;//当前页的页码值
	private Integer pageSize=3;//页面大小
	private Integer rowCount=0;//总行数（通过查询获得）
	private Integer pageCount=0;//总页数（通过计算获得）
	private List<T> records;//当前页记录
	public PageObject(Integer pageCurrent, Integer pageSize, Integer rowCount, List<T> records) {
		super();
		this.pageCurrent = pageCurrent;
		this.pageSize = pageSize;
		this.rowCount = rowCount;
		this.records = records;
//		this.pageCount=rowCount/pageSize;
//		if(rowCount%pageSize!=0) {
//			pageCount++;
//		}
		this.pageCount=(rowCount-1)/pageSize+1;
	}
}
