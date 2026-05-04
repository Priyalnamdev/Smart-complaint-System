package com.example.ComplaintPortal.Repository;

import com.example.ComplaintPortal.Entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User ,Integer> {
}
