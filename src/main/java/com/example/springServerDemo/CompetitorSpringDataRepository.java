package com.example.springServerDemo;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitorSpringDataRepository extends JpaRepository<Competitor, Integer> {

    public List<Competitor> findByNationality(String nationality);
}
