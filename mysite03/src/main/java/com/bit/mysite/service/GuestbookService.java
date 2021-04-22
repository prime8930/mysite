package com.bit.mysite.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.mysite.repository.GuestbookRepository;
import com.bit.mysite.vo.GuestbookVo;

@Service
public class GuestbookService {

	@Autowired
	private GuestbookRepository guestbookRepository;
	
	public List<GuestbookVo> findAll() {
		return guestbookRepository.findAll();
	}

	public boolean insert(GuestbookVo vo) {
		return guestbookRepository.insert(vo);
	}


	public boolean delete(GuestbookVo vo) {
		return guestbookRepository.delete(vo);
		
	}

}
