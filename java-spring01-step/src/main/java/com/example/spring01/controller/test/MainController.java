package com.example.spring01.controller.test;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.spring01.model.PointDTO;
import com.example.spring01.model.ProductDTO;

@Controller		// 콘트롤러 bean으로 메모리에 올린다.
public class MainController {

	
	@RequestMapping("/")	// url과 method 매핑
	public String main(Model model) {	// Model 데이터를 저장하는 저장소 역활
		model.addAttribute("message", "welcome!");	// key, value
		return "/test/main";		// main.jsp로 포워드
	}
	
	@RequestMapping("multi_table.do")
	public String gugu() {
		
		return "/test/multi_table";
	}
	
	@RequestMapping("table_result.do")
	                          // @RequestParam 파라미터
	public String gugu_result(@RequestParam( defaultValue ="3") int num, Model model) {
		String result = "";
		for(int i = 1; i <= 9; i++) {
			result += num + " x " + i + " = " + num*i + "<br>";
		}
		model.addAttribute("result", result);
		return "/test/table_result";
	}
	
	@RequestMapping("point.do")
	public String point() {
		return "test/point";
	}
	
	/*
	 	@RequestParam : 개별 변수
	  	@ModelAttribute : 객체
	 */
	@RequestMapping("point_result.do")
	public String point_result(@ModelAttribute PointDTO dto, Model model) {
		dto.setTotal(dto.getKor() + dto.getEng() + dto.getMat());
		String avg = String.format("%.2f", dto.getTotal() / 3.0);
		dto.setAverage(Double.parseDouble(avg));
		model.addAttribute("dto", dto);
		return "test/point_result";
	}
	
	/*
		forward : 자료저장 => 출력페이지
		redirect : 처리 완료 => 다른  url 이동
	*/
	
	@RequestMapping("move.do")
	public String move() throws Exception {
		String name = URLEncoder.encode("김철수","utf-8");
		return "redirect:/result.do?name="+name+"&age=20";
		// url에 한글, 특수문자 제한
//		String name = "김철수";
//		return "redirect:/result.do?name=김철수&age=20";
	}
	
	@RequestMapping("result.do")
	public String result(Model model, 
						@RequestParam(defaultValue = "noname") String name,
						@RequestParam(defaultValue = "10") int age) throws Exception {
		name = URLDecoder.decode(name, "utf-8");
		model.addAttribute("name", name);
		model.addAttribute("age", age);
		return "test/result";
	}
	
	// ModelAndView
	// Model : 데이터 저장소
	// View : 출력 페이지
	@RequestMapping("mav.do")
	public ModelAndView mav() {
		Map<String,Object>  map = new HashMap<String, Object>();
		map.put("dto", new ProductDTO("pen",1000));
		
		// new ModelAndView(view, key, value)
		return new ModelAndView("test/mav_result", "map", map);
	}
	
	@RequestMapping("ajax.do")
	public String ajax() {
		return "test/ajax";
	}
	
	
	@RequestMapping("background.do")
	// @ResponseBody 사용하기 위해서는 추가적인 라이브러리가 필요하다
	// jackson-annotations, jackson-databind, jackson-mapper-asl
	
	public @ResponseBody ProductDTO   background() {
		ProductDTO dto = new ProductDTO("TV", 500000);
		
		return dto; 
	}
}
