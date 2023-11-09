package com.olidev.pe.manualspringdatajpaadvance.repository;

import com.olidev.pe.manualspringdatajpaadvance.domain.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
}
