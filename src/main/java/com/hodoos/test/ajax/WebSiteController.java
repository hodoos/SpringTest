package com.hodoos.test.ajax;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hodoos.test.ajax.bo.WebSiteBO;
import com.hodoos.test.ajax.model.WebSite;

@Controller
@RequestMapping("/ajax/website")
public class WebSiteController {
	
	@Autowired
	private WebSiteBO webSiteBO;
	
	@GetMapping("/list")
	public String webSiteList(Model model) {
		
		List<WebSite> webSiteList = webSiteBO.getWebsiteList();
		
		model.addAttribute("webSiteList", webSiteList);
		
		return "ajax/website/list";
	}
	//즐겨찾기 추가 api
	@PostMapping("/add")
	@ResponseBody
	public Map<String, String> addWebSite(
			@RequestParam("name") String name
			,  @RequestParam("url") String url) {
		int count = webSiteBO.addWebSite(name, url);
		
		// response
		// 성공시 : {"result" : "success"}
		// 실패시 : {"result" : "fail"}
		
		Map<String, String> map = new HashMap<>();
		
		if(count == 1) {
			map.put("result", "success");
		} else {
			map.put("result", "fail");
		}
		
		return map;
		
		
	}
	@GetMapping("/input")
	public String webSiteInput() {
		return "ajax/website/input";
	}
	@PostMapping("/is_duplicate")
	@ResponseBody
	public Map<String, Boolean> isDuplicateUrl(@RequestParam("url") String url) {
		
		Map<String, Boolean> result = new HashMap<>();
		
		if(webSiteBO.isDuplicateUrl(url)) { //중복 boolean 값 전달 받음
			result.put("is_duplicate", true);
		} else {
			result.put("is_duplicate", false);
		}
		
		return result;
	}
	// 삭제 API
	// id를 전달 받고, 해당 행을 삭제하는 API
	@GetMapping("/delete")
	@ResponseBody
	public Map<String, String> deleteWebSite(@RequestParam("id") int id) {
		
		int count = webSiteBO.deleteWebSite(id);
		
		// 삭제 성공시 {"result":"success"}
		// 삭제 실패시 {"result":"fail"}
		Map<String, String> result = new HashMap<>();
		if(count == 0) {
			result.put("result", "fail");
		} else {
			result.put("result", "success");
		}
		
		return result;
		
	}
	
}
