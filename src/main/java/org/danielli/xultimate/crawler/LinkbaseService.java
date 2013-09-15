package org.danielli.xultimate.crawler;

import java.util.List;
import java.util.Map;

public interface LinkbaseService {
	
	/**
	 * 获取url链接ID。
	 * 
	 * @return url链接ID。
	 */
	String getLinkId();
	
	/**
	 * 获取url链接。
	 * 
	 * @param linkId url链接ID。
	 * @return url链接。
	 */
	String getLinkUrlByLinkId(String linkId);
	
	/**
	 * 完成对url链接的处理。
	 * 
	 * @param linkId url链接ID。
	 */
	void completionLinkId(String linkId);
	
	/**
	 * 完成对不可用url链接的处理。
	 * 
	 * @param linkId url链接ID。
	 */
	void unableLinkId(String linkId);
	
	/**
	 * 处理不可用链接url。
	 */
	void unableLinkIdHandle();
	
	/**
	 * 添加链接列表。
	 * 
	 * @param linkUrlList 链接列表。
	 */
	void addLinkUrls(List<Map<String, Object>> linkUrlList);
}