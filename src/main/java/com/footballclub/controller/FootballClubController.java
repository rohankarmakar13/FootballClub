package com.footballclub.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.footballclub.ResponseEntity;
import com.footballclub.dto.FootballClubDto;
import com.footballclub.dto.LoginDto;
import com.footballclub.service.IFootballClubService;

@RestController
public class FootballClubController {

	@Autowired
	IFootballClubService footballClubService;

	
	//__________________________Register_User_______________________
	@PostMapping("/RegisterUser")
	public ResponseEntity register(@RequestBody FootballClubDto footballClubDto) {
		FootballClubDto footballClub = footballClubService.register(footballClubDto);
		return new ResponseEntity(footballClub, "New user Regitered!");
	}
	
	// ________________________Login_User_______________________________
	@GetMapping("/LoginUser")
	public ResponseEntity loginUser(@RequestBody LoginDto loginDto) {
		ResponseEntity login = footballClubService.loginUser(loginDto);
		return new ResponseEntity(login, "Login Sucessfully!!");
	}
	
}