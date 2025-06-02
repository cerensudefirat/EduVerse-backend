package com.EduVerse.repository;

import com.EduVerse.model.Modules;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ModuleRepository extends JpaRepository<Modules, Integer> {
}
