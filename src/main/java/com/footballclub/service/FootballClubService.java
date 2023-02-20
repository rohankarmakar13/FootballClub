package com.footballclub.service;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.footballclub.ResponseEntity;
import com.footballclub.dto.FootballClubDto;
import com.footballclub.dto.LoginDto;
import com.footballclub.entity.FootballClubEntity;
import com.footballclub.exception.ClubException;
import com.footballclub.repository.IFootballClubRepo;

@Service
public class FootballClubService implements IFootballClubService {

	@Autowired
	IFootballClubRepo repo;
	@Autowired
	ModelMapper modelMapper;

	@Override
	public FootballClubDto register(FootballClubDto footballClubDto) {
		Optional<FootballClubEntity> clubEntity = repo.findByEmailIdAndPassword(footballClubDto.getEmailId(),
				footballClubDto.getPassword());
		if (clubEntity.isPresent()) {
			throw new ClubException("User Already Exists", "Try with another Email");
		}
		FootballClubEntity registerUser = modelMapper.map(footballClubDto, FootballClubEntity.class);
		repo.save(registerUser);
		return footballClubDto;
	}

	@Override
	public ResponseEntity loginUser(LoginDto loginDto) {
//		Optional<FootballClubEntity> loginEntity = repo.findByEmailIdAndPassword(loginDto.getEmailId(),
//				loginDto.getPassword());
//
//		if (loginEntity.isEmpty()) {
//			Optional<FootballClubEntity> userEmail = repo.findbyEmailId(loginDto.getEmailId());
//			Optional<FootballClubEntity> userPassword = repo.findbyPassword(loginDto.getPassword());
//			if (userEmail.isEmpty()) {
//				throw new ClubException("Email is incorrect", "Give correct Email");
//			} else if (userPassword.isEmpty()) {
//				throw new ClubException("Password is incorrect", "Give correct password");
//			}
//		}
//
//		FootballClubDto clubDto = modelMapper.map(loginEntity.get(), FootballClubDto.class);
//		return clubDto;
//	}
		if (repo.findByEmailIdAndPassword(loginDto.getEmailId(), loginDto.getPassword()).isPresent()) {
			FootballClubEntity loginUser = repo.findByEmailIdAndPassword(loginDto.getEmailId(), loginDto.getPassword())
					.get();

			FootballClubDto loginUserDto = modelMapper.map(loginUser, FootballClubDto.class);
			return new ResponseEntity(loginUserDto, "User login successfully");
		} else {
			throw new ClubException(" User not found", "Enter valid credentials");
		}
	}
}
