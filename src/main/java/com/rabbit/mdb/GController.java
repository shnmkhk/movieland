package com.rabbit.mdb;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.rabbit.mdb.model.Greet;
import com.rabbit.mdb.utils.GSONUtils;

@Controller
@RequestMapping("gc")
public class GController {

	@GetMapping(path = "/hello", produces = {"application/json"})
	@ResponseBody
	public String onGet() {
		return GSONUtils.gson().toJson(Greet.of(1, "Hello, World!"));
	}
}
