package com.bit.mysite.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.mysite.vo.GuestbookVo;

@Repository
public class GuestbookRepository {
	
	@Autowired
	private SqlSession sqlSession;
	

	public List<GuestbookVo> findAll() {
		return sqlSession.selectList("guestbook.find");
	}
	
	public boolean insert(GuestbookVo vo) {
		return sqlSession.insert("guestbook.insert", vo) == 1;
	}


	public boolean delete(GuestbookVo vo) {
		return sqlSession.delete("guestbook.delete", vo) == 1;
	}

}
