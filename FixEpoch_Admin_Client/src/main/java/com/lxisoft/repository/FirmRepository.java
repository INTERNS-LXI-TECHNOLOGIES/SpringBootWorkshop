package com.lxisoft.repository;

import com.lxisoft.domain.Firm;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Firm entity.
 */
@SuppressWarnings("unused")
@Repository
public interface FirmRepository extends JpaRepository<Firm, Long> {
}
