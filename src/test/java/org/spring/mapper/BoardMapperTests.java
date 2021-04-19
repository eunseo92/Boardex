package org.spring.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {

	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void testGetList() {
		
		log.info("======================");
		boardMapper.getList();
	}
	@Test
	public void testInsert() {
		BoardVO vo = new BoardVO();
		vo.setTitle("Title 테스트");
		vo.setContent("Content 테스트");
		vo.setWriter("Writer 테스트");
		boardMapper.insert(vo);
		log.info("=============================");
		log.info("after insert" + vo.getBno());

	}
	@Test
	public void testInsertSelectKey() {	
		BoardVO vo = new BoardVO();
		vo.setTitle("AAATitle 테스트");
		vo.setContent("AAAContent 테스트");
		vo.setWriter("AAAWriter 테스트");
		boardMapper.insertSelectKey(vo);
		log.info("=============================");
		log.info("after insert selectkey" + vo.getBno());
	
	}
	@Test
	public void testread() {
		BoardVO vo = boardMapper.read(9L);
		log.info(vo);
		
	}
	@Test
	public void testDelete() {
		
		int count = boardMapper.delete(1L);
		log.info("count" + count);
	}
	
	@Test
	public void testUpdate() {
		
		BoardVO vo = new BoardVO();
		vo.setBno(29L);
		vo.setTitle("updated Title");
		vo.setContent("updated Content");
		vo.setWriter("updated Writer");
		
		log.info("count : " + boardMapper.update(vo));
	}
	
	
	
	
	
}

