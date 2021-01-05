package com.example.phonebook.store;

import com.example.phonebook.model.Record;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RecordRepository extends JpaRepository<Record, Integer> {

    List<Record> findAllByOrderByName();
    Record findByNumber(String name);
    List<Record> findAllByNameContainsOrderByName(String name);
    void deleteByNumber(String number);
}
