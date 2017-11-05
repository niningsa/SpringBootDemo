package com.ln.girl.service;


import com.ln.girl.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GrilRepository extends JpaRepository<Girl, Integer> {}

