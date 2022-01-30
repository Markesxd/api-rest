package com.dio.apirest.repositories;

import com.dio.apirest.models.Person;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long>{
}
