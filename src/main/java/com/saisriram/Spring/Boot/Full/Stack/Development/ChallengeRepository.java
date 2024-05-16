package com.saisriram.Spring.Boot.Full.Stack.Development;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ChallengeRepository extends JpaRepository<Challenge, Long> {
    Optional<Challenge> findByMonthIgnoreCase(String month);
}
