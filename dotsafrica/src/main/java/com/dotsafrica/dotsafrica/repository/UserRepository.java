package com.dotsafrica.dotsafrica.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import com.dotsafrica.dotsafrica.entity.AppUser;

@Repository
public interface UserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findUserByUsername(String username);
}
