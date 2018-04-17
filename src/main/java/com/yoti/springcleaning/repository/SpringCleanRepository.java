package com.yoti.springcleaning.repository;

import com.yoti.springcleaning.persistence.SpringClean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringCleanRepository extends JpaRepository<SpringClean, Integer> {
}
