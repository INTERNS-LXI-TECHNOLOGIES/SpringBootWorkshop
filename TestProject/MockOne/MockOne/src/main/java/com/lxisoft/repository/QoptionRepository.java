package com.lxisoft.repository;
import com.lxisoft.entity.QnOption;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

public interface QoptionRepository extends JpaRepository<QnOption,Long> {
}
