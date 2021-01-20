package com.lxisoft.repository;

import com.lxisoft.domain.Scene;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Scene entity.
 */
@SuppressWarnings("unused")
@Repository
public interface SceneRepository extends JpaRepository<Scene, Long> {
}
