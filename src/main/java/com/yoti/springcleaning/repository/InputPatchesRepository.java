package com.yoti.springcleaning.repository;

import com.yoti.springcleaning.persistence.InputPatches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InputPatchesRepository extends JpaRepository<InputPatches, Integer> {
}
