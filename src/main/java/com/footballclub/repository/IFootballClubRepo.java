package com.footballclub.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.footballclub.entity.FootballClubEntity;

@Repository
public interface IFootballClubRepo extends JpaRepository<FootballClubEntity, Integer> {

	Optional<FootballClubEntity> findByEmailIdAndPassword(String emailId, String password);

}
