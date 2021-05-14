package com.iu.s1.member;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/member/**")
public class MemberController {

	@Autowired
	private MemberService memberService;
	
	@GetMapping("join")
	public void setJoin()throws Exception{
		
	}
	
	@PostMapping("join")
	public void setJoin(MemberVO memberVO, MultipartFile file)throws Exception{
		memberService.setMember(memberVO, file);
	}
	
	@GetMapping("login")
	public String login(HttpSession session)throws Exception{
		String path = "member/login";
		if(session.getAttribute("member")!=null) {
			path="redirect:/";
		}
		return path;
	}
	
	@PostMapping("login")
	public String setLogin(MemberVO memberVO, HttpSession session)throws Exception{
		String path = "./login"; 
		if(memberService.getLogin(memberVO)!=null) {
			session.setAttribute("member", memberVO.getUserName());
			path="redirect:/";
		}
		return path;
	}
	
	@GetMapping("logout")
	public String setLogout(HttpSession session)throws Exception{
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("page")
	public void getPage(HttpSession session, Model model)throws Exception{
		MemberVO memberVO = new MemberVO();
		memberVO.setUserName((String)session.getAttribute("member"));
		model.addAttribute("userinfo", memberService.getPage(memberVO));
	}
}
