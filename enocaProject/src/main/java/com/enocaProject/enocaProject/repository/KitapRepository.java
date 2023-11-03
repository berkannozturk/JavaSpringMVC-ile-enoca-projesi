package com.enocaProject.enocaProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.enocaProject.enocaProject.Entity.Kitap;

public interface KitapRepository extends JpaRepository<Kitap, Integer> {

	

}
