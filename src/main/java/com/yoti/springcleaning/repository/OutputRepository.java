package com.yoti.springcleaning.repository;

import com.yoti.springcleaning.persistence.Output;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OutputRepository extends JpaRepository<Output, Integer> {
}