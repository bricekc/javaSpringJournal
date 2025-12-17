package com.api.journal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.journal.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

}
