package com.example.phonebook.service;

import com.example.phonebook.model.Record;
import com.example.phonebook.store.RecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class RecordService {

    private final RecordRepository repository;

    @Autowired
    public RecordService(RecordRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public Record findByNumber(String number) {
        return repository.findByNumber(number);
    }

    @Transactional
    public List<Record> findByName(String name) {
        return repository.findAllByNameContainsOrderByName(name);
    }

    @Transactional
    public List<Record> findAll() {
        return repository.findAllByOrderByName();
    }

    @Transactional
    public Record save(Record record) {
        return repository.save(record);
    }

    @Transactional
    public void delete(String number) {
        repository.deleteByNumber(number);
    }
}
