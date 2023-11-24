package com.springdata.springdatajpa;

import org.hibernate.type.descriptor.converter.internal.JpaAttributeConverterImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerSpringDataRepository extends JpaRepository<Player,Integer> {
public List<Player> findByNationality(String nationality);

}
