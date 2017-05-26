package com.aidaL.db;

public class TextFilter {
	
	/**
     * 去除富文本内容的html标签
     * @param content
     * @return
     */
    public String stripHtml(String content) {
        // <p>段落替换为换行
        content = content.replaceAll("<p .*?>", "\r\n");
        // <br><br/>替换为换行
        content = content.replaceAll("<br\\s*/?>", "\r\n");
          // 去掉其它的<>之间的东西
        content = content.replaceAll("\\<.*?>", "");
        return content;
    }
    
}
