package com.bit.mysite.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.mysite.repository.UserRepository;
import com.bit.mysite.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;

	public void join(UserVo vo) {
		userRepository.insert(vo);
	}

	public UserVo getUser(UserVo vo) {
		return userRepository.findByMailAndPassword(vo);
	}

	public UserVo getUser(Long no) {
		return userRepository.findByNo(no);
	}

	public void updateUser(UserVo vo) {
		userRepository.update(vo);
		
	}

	public boolean existUser(String email) {
		UserVo userVo = userRepository.findByEmail(email);
		return userVo != null;
	}
	
	
	
}
