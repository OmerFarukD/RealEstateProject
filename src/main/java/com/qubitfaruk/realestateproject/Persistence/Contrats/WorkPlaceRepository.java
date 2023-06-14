package com.qubitfaruk.realestateproject.Persistence.Contrats;

import com.qubitfaruk.realestateproject.Entity.WorkPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkPlaceRepository extends JpaRepository<WorkPlace,Integer> {

}
