package com.leaveplanner.repository;

import com.leaveplanner.domain.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;
import java.util.List;
import java.util.Optional;

public class InMemoryUserRepository implements UserRepository {

    //임시 저장 map 객체 
    private final Map<Long, User> store = new HashMap<>();
    private final AtomicLong sequence = new AtomicLong(1);

    @Override
    public User save(User user) {
        
        if (user.getId() == null) {
            user.assignId(sequence.getAndIncrement());
        }
        store.put(user.getId(), user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(store.values());
    }
}