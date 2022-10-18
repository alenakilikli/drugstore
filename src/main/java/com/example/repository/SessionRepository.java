package com.example.repository;

import com.example.entity.AccountSession;
import org.springframework.stereotype.Repository;

@Repository
public interface SessionRepository {
    AccountSession findBySessionId(String header);
}
