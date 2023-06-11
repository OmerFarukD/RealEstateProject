package com.qubitfaruk.realestateproject.AOP.CrossCuttingConcerns.Logging;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerRepository extends JpaRepository<LogDetails,Long> {
}
