package com.kruchinski.lab.pharmacy;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SubstanceRepository extends JpaRepository<Substance, Long> {
}