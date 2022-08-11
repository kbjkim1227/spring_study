package com.myspring.boardtest.board.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.boardtest.board.vo.ArticleVO;


public interface BoardDAO {
	public List selectAllArticlesList() throws DataAccessException;

	public ArticleVO selectArticle(int articleNO) throws DataAccessException;

}
