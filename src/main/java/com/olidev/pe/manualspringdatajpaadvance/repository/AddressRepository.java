package com.olidev.pe.manualspringdatajpaadvance.repository;

import com.olidev.pe.manualspringdatajpaadvance.domain.Address;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AddressRepository extends CrudRepository<Address, Long> {
}
