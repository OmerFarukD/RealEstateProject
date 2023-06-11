package com.qubitfaruk.realestateproject.Persistence.Concretes;

import com.qubitfaruk.realestateproject.Entity.RealEstate;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import org.springframework.data.jpa.domain.Specification;

public class RealEstateSpecification implements Specification<RealEstate> {
    @Override
    public Predicate toPredicate(Root<RealEstate> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return null;
    }
}
