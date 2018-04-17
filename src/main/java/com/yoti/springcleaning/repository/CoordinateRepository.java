package com.yoti.springcleaning.repository;

import com.yoti.springcleaning.persistence.Coordinate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordinateRepository extends JpaRepository<Coordinate, Integer> {
}
