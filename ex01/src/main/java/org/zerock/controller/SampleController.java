package org.zerock.controller;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;

import lombok.extern.log4j.Log4j;

@Controller
@RequestMapping("/sample/*")
@Log4j
public class SampleController {
	
	@RequestMapping("")
	public void basic() {
		log.info("basic..............");
		
	}
	@GetMapping("/ex01")
	private String ex01(SampleDTO dto) {
		// TODO Auto-generated method stub
		log.info(""+dto);
		
		return "ex01";
	}
	
	@GetMapping("/ex02")
	public String ex02(@RequestParam("name") String name, @RequestParam("age") int age) {
		
		log.info("name : " + name);
		log.info("age : " + age);
		
		return "ex02";

	}
    @GetMapping("/ex02List")
    public String ex02List(@RequestParam("ids") ArrayList<String> ids){
        log.info("ids: " + ids);
        return "ex02List";
    }

    @GetMapping("/ex02Array")
    public String ex02Array(@RequestParam("ids") String[] ids){
        log.info("array ids: " + Arrays.toString(ids));
        return "ex02Array";// forwarding to: /views/ex02Array.jsp
    }

    @GetMapping("/ex02Bean")
    public String ex02Bean(SampleDTOList list){
        log.info("list dtos: " + list);
        return "ex02Bean";
    }

}
