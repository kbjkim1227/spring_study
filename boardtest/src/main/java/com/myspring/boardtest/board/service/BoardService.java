package com.myspring.boardtest.board.service;

import java.util.List;

import com.myspring.boardtest.board.vo.ArticleVO;

public interface BoardService {
	public List<ArticleVO> listArticles() throws Exception;
	
	public ArticleVO viewArticle(int articleNO)throws Exception;


}
