package com.example.springServerDemo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Repository;

import java.util.List;

// Using JPA

@Repository
@Transactional
public class CompetitorRepository {

    @PersistenceContext
    EntityManager entityManager;

    public Competitor insertCompetitor(Competitor competitor) {
        return entityManager.merge(competitor);
    }

    public Competitor updateCompetitor(Competitor competitor) {
        return entityManager.merge(competitor);
    }

    public Competitor getCompetitorById(int id) {
        return entityManager.find(Competitor.class, id);
    }

    public void deleteCompetitorById(int id) {
        Competitor competitor = entityManager.find(Competitor.class, id);
        entityManager.remove(competitor);
    }

    public List<Competitor> getAllCompetitors() {
        TypedQuery<Competitor> getAll = entityManager.createNamedQuery("get_all_competitors", Competitor.class);
        return getAll.getResultList();
    }
}
