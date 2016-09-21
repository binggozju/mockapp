package org.binggo.mockapp.common;

import java.util.List;

import com.github.pagehelper.PageInfo;

/**
 * the container page used to contain the result with detailed paging infomation
 * @author Administrator
 *
 */
public class PageInfoExt<T> extends PageInfo<T> {
	
	private static final long serialVersionUID = 1L;

	public PageInfoExt(List<T> list) {
		super(list);
		
	}
	
	// add other fields needed, which will displayed in the response

}
