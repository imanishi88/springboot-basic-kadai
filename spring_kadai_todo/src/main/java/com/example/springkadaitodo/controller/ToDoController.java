package com.example.springkadaitodo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.example.springkadaitodo.service.ToDoService;


@Controller
public class ToDoController {

	
	public ToDoController(ToDoService todoService) {
		
	}
	@GetMapping("/todo")
	public String toDo() {

				
	/*public String toDo(Model model) {
		List<ToDo> todos = todoService.getAllTodo();
				model.addAttribute("todos", todos);*/
		return "todoView";
	}
}