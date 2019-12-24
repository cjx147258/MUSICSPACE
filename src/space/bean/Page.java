package space.bean;
/**
 * 定义分页工具类
 * @author lizq
 *
 */
public class Page {
	
	private int currentPage;		//当前页
	private int pageSize;			//每页显示的条数
	private int totalCount;			//总条数
	private int pageCount;			//总页数
	private int offset;				//偏移量
	
	
	
	public Page(int currentPage, int pageSize, int totalCount,int pageCount) {
		super();
		this.currentPage = currentPage;
		this.pageSize = pageSize;
		this.totalCount = totalCount;
		this.pageCount=pageCount;
	}
	public Page() {
		super();
	}
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	
	public int getPageCount() {			//获取总页数
		if(totalCount%pageSize==0) {			//能除尽
			return totalCount/pageSize;
		}else {
			return totalCount/pageSize+1;
		}
	}
	public int getOffset() {			//偏移量
		return (currentPage-1)*pageSize;
	}
	
	
}
