package com.hodoos.test.lifecycle;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class Test01Controller {
	
	@ResponseBody
	@RequestMapping("/stringTest")
	public String stringTest() {
		return "<h1>테스트 프로젝트 완성</h1> <br> <h3>해당 프로젝트를 통해서 문제 풀이를 진행 합니다.</h3>";
	}
	
	@ResponseBody
	@RequestMapping("/mapTest")
	public Map<String, Integer> mapTest() {
		Map<String, Integer> scoreMap = new HashMap<>();
		scoreMap.put("국어", 80);
		scoreMap.put("수학", 90);
		scoreMap.put("영어", 85);
		
		return scoreMap;
	}
	
	
}
