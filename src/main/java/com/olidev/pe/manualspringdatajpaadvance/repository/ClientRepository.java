package com.olidev.pe.manualspringdatajpaadvance.repository;

import com.olidev.pe.manualspringdatajpaadvance.domain.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long> {
}
