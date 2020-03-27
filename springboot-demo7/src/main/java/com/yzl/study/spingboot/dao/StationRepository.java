package com.yzl.study.spingboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yzl.study.spingboot.model.Station;



public interface StationRepository extends JpaRepository<Station, Integer> {

}
