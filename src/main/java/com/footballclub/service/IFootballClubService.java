package com.footballclub.service;

import com.footballclub.ResponseEntity;
import com.footballclub.dto.FootballClubDto;
import com.footballclub.dto.LoginDto;

public interface IFootballClubService {

	FootballClubDto register(FootballClubDto footballClubDto);

	ResponseEntity loginUser(LoginDto loginDto);


}
