package org.zerock.common.util;

import lombok.Getter;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Getter
@ToString
@Log4j
public class PageMaker {

	private boolean prev;
	private boolean next;
	private int start;
	private int end;
	private PageInfo pageInfo;
	private int total;
	
	public PageMaker(PageInfo pageInfo, int total) {
		
		this.total = total;
		this.pageInfo = pageInfo;
		
		//현재페이지
		int currentPage = pageInfo.getPage();
		
		//임시 마지막번호 13 -> 1.3 -> 2.0
		int tempEnd = (int)(Math.ceil((currentPage / 10.0)) * 10.0);

		//시작페이지
		this.start = tempEnd - 9;
		
		//진짜 마지막 페이지 131 -> 13.1 -> 14.0 -> 14
		int realEnd = (int)(Math.ceil(total / (pageInfo.getPerSheet()*1.0)));
		log.info(realEnd);
		end = realEnd < tempEnd ? realEnd : tempEnd;
		
		prev = start > 1;
		
//		if( end * 10 < total) {
//			next = true;
//		}else {
//			next = false;
//		}
		
		next = end * pageInfo.getPerSheet() < total ? true : false;
		
	}
	
	public String getLink(int num) {
		
		StringBuilder builder = new StringBuilder("page=" + num +"&perSheet=" + this.pageInfo.getPerSheet());
				
		return builder.toString();
	}
	
}







