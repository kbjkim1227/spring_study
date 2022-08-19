package org.zerock.mapper;

import org.zerock.domain.BoardVO;

import java.util.List;

public interface BoardMapper {

    //@Select("select * from tbl_board where bno > 0")
    public List<BoardVO> getList();
    
    public void insert(BoardVO board);

    public void insertSelectKey(BoardVO board); 
    
    public BoardVO read(Long bno);

	public int delete(long bno);

	public int update(BoardVO board);

}