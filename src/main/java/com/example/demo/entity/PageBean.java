/**
 * 
 */
package com.example.demo.entity;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

/**
 * @author LOL
 *
 * 2017-2-22上午09:03:03
 */

@Component
@Lazy
public class PageBean {
	private int currentPage = 1; // 当前页, 默认显示第一页
	private int pageCount = 4;   // 每页显示的行数(查询返回的行数), 默认每页显示4行
	private int totalCount;      // 总记录数
	private int totalPage;       // 总页数 = 总记录数 / 每页显示的行数  (+ 1)
	
	public PageBean() {
		super();
	}
	/**
	 * @param currentPage
	 * @param pageCount
	 * @param totalCount
	 * @param totalPage
	 */
	public PageBean(int currentPage, int pageCount, int totalCount,
			int totalPage) {
		super();
		this.currentPage = currentPage;
		this.pageCount = pageCount;
		this.totalCount = totalCount;
		this.totalPage = totalPage;
	}
	/**
	 * @return the currentPage
	 */
	public int getCurrentPage() {
		return currentPage;
	}
	/**
	 * @param currentPage the currentPage to set
	 */
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	/**
	 * @return the pageCount
	 */
	public int getPageCount() {
		return pageCount;
	}
	/**
	 * @param pageCount the pageCount to set
	 */
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	/**
	 * @return the totalCount
	 */
	public int getTotalCount() {
		return totalCount;
	}
	/**
	 * @param totalCount the totalCount to set
	 */
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	/**
	 * @return the totalPage
	 */
	public int getTotalPage() {
		return totalPage;
	}
	/**
	 * @param totalPage the totalPage to set
	 */
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + currentPage;
		result = prime * result + pageCount;
		result = prime * result + totalCount;
		result = prime * result + totalPage;
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PageBean other = (PageBean) obj;
		if (currentPage != other.currentPage)
			return false;
		if (pageCount != other.pageCount)
			return false;
		if (totalCount != other.totalCount)
			return false;
		if (totalPage != other.totalPage)
			return false;
		return true;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PageBean [currentPage=" + currentPage + ", pageCount="
				+ pageCount + ", totalCount=" + totalCount + ", totalPage="
				+ totalPage + "]";
	}
}
