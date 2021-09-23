package com.rubypaper.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.rubypaper.vo.BoardVo;

@RestController
public class HelloController {
	
	@PostMapping("/hello")
	public String hello(String name) {
		return  "hello " + name + "!!";
	}

	@PostMapping("/getBoard")
	public BoardVo getBoard(@RequestBody BoardVo boardVo) {
		return  boardVo;
	}

}
