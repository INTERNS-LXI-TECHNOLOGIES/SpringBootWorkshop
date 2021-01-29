package com.lxisoft.repository;

import com.lxisoft.domain.Catagorie;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Catagorie entity.
 */
@SuppressWarnings("unused")
@Repository
public interface CatagorieRepository extends JpaRepository<Catagorie, Long> {
}
