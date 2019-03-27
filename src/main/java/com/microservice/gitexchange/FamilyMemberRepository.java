package com.microservice.gitexchange;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface FamilyMemberRepository extends 
    JpaRepository<FamilyMember, String>{
	Optional<FamilyMember> findById(String id);
}