package com.example.security;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserAuthEntityRepository extends JpaRepository<UserAuthEntity,Long> {

    Optional<UserAuthEntity> findByName(String name);


}
