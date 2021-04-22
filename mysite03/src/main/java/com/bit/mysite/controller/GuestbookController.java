package com.bit.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bit.mysite.repository.GuestbookRepository;
import com.bit.mysite.service.GuestbookService;
import com.bit.mysite.vo.GuestbookVo;

@Controller
@RequestMapping("/guestbook")
public class GuestbookController {

	@Autowired
	private GuestbookService guestbookService;
	
	@RequestMapping("")
	public String list(Model model) {
		List<GuestbookVo> list = guestbookService.findAll();
		System.out.println(list);
		model.addAttribute("list", list);
		return "guestbook/index";
	}
	
	@RequestMapping("/add")
	public String add(GuestbookVo vo) {
		guestbookService.insert(vo);
		return "redirect:/guestbook";
	}
	
	@RequestMapping("/deleteform/{no}")
	public String deleteform(@PathVariable("no") Long no, Model model) {
		model.addAttribute("no", no);
		return "guestbook/delete";
	}
	
	@RequestMapping("/delete/{no}")
	public String delete(GuestbookVo vo) {
		guestbookService.delete(vo);
		return "redirect:/guestbook";
	}
}

/*
 *  1) @RequestParam() : 변수를 필수로 받을 때 사용, required = true/false
 *  2) parameter : jsp 파일 form 태그 안에 있는 매개변수와 메소드 안 매개변수가 동일한 것을 가져온다고 생각
 *  3) @PathVariable() : path 안의 변수를 가져옴
 */
