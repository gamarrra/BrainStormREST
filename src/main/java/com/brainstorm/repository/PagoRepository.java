package com.brainstorm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.brainstorm.model.Pago;




@Repository
public interface PagoRepository extends JpaRepository<Pago, Long> {

}
