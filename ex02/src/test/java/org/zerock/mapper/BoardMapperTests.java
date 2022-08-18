package org.zerock.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.zerock.domain.BoardVO;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

    @Setter(onMethod_ = @Autowired)
    private BoardMapper mapper;

    @Test
    public void testGetList(){
        mapper.getList().forEach(board -> log.info(board));
    }
    
    @Test
    public void testInsert(){
        BoardVO board = new BoardVO();
        board.setTitle("title44444444444");
        board.setContent("content4444444444");
        board.setWriter("writer4444444444");

        mapper.insert(board);

        log.info(board);
    }
    
    @Test
    public void testInsertSelectKey(){
        BoardVO board = new BoardVO();
        board.setTitle("new title1");
        board.setContent("new content1");
        board.setWriter("new writer1");

        mapper.insertSelectKey(board);

        log.info(board);
    }
    
    @Test
    public void testRead(){
        BoardVO board = mapper.read(5L);

        log.info(board);
    }
    
    @Test
    public void testDelete(){
        log.info("DELETE COUNT: " + mapper.delete(3L));
    }
    
    @Test
    public void testUpdate(){
        BoardVO board = new BoardVO();
        board.setBno(5L);
        board.setTitle("updated title");
        board.setContent("updated content");
        board.setWriter("new user");

        int count = mapper.update(board);
        log.info("UPDATE COUNT: " + count);
    }
}
