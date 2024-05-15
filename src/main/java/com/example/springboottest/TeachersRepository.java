package com.example.springboottest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeachersRepository extends JpaRepository<Teachers , Integer> 
{

	List<Teachers> findByName(String name);

	List<Teachers> findByCity(String city);

	List<Teachers> findByNameAndCity(String name, String city);

	List<Teachers> findByNameAndAge(String name, int age);

	List<Teachers> findByNameOrCity(String name, String city);

	List<Teachers> findByNameOrAge(String name, int age);


}
