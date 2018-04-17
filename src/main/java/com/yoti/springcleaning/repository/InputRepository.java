package com.yoti.springcleaning.repository;

import com.yoti.springcleaning.persistence.Input;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputRepository extends JpaRepository<Input, Integer> {
}
