package org.spring.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.spring.mapper.BoardMapperTests;
import org.spring.vo.BoardVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardServiceTests {

	@Autowired
	private BoardService service;
	
	@Test
	public void testPrint() {
		
		log.info(service);
	}
	
	@Test
	public void testGetList() {
		
		service.getList().forEach(board -> log.info(board));
	}
	
	@Test
	public void testRegister() {
		BoardVO vo = new BoardVO();
		vo.setTitle("AAATitle 테스트");
		vo.setContent("AAAContent 테스트");
		vo.setWriter("AAAWriter 테스트");
		
		long bno = service.register(vo);
		log.info("Bno: " + bno);
	}
}
