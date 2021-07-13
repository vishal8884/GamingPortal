package com.vishal.gamePortal.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vishal.gamePortal.entities.Game;

public interface GameRepository extends JpaRepository<Game, String> {

}
