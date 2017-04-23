package org.zerock.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.service.BoardService;





@Controller
@RequestMapping("/board/*")
public class BoardController {

	@Autowired
	private BoardService service;
	
	
	@RequestMapping(value="/register",method=RequestMethod.GET)
	public void registerGET(BoardVO board,Model model) throws Exception{
		
		
	}
	
	
	@RequestMapping(value="/register",method=RequestMethod.POST)
	public String registPOST(BoardVO board,RedirectAttributes rttr) throws Exception{
		service.regist(board);
		
		
		//return "/board/success";
		rttr.addFlashAttribute("msg", "SUCCESS");
		return "redirect:/board/listAll";
		
	}
	
	@RequestMapping(value="/listAll",method=RequestMethod.GET)
	public void listAll(Model model)throws Exception{
		
		model.addAttribute("list",service.listAll());
		
	}
	@RequestMapping(value="/read",method=RequestMethod.GET)
	public void read(@RequestParam("bno") int bno,Model model)throws Exception{
		
		model.addAttribute(service.read(bno));
		
	}
	
	@RequestMapping(value="/remove",method=RequestMethod.POST)
	public String remove(@RequestParam int bno,RedirectAttributes rttr) throws Exception{
		
		service.remove(bno);
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/board/listAll";
	}
	@RequestMapping(value="/modify",method=RequestMethod.GET)
	public void modifyGET(int bno,Model model) throws Exception{
		
		model.addAttribute(service.read(bno));
		
	}
	@RequestMapping(value="/modify",method=RequestMethod.POST)
	public String modifyPOST(BoardVO board,RedirectAttributes rttr) throws Exception{
		
		
		return "redirect:/board/listAll";
	}
	
	@RequestMapping(value="/listCri",method=RequestMethod.GET)
	public void listAll(Criteria cri,Model model) throws Exception{
		
		
		model.addAttribute("list",service.listCriteria(cri));
		
	}
	
	
	
}
