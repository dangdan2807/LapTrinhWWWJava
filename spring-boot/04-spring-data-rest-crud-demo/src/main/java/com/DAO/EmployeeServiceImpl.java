package com.DAO;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

import com.entity.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery.FetchableFluentQuery;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeRepositorySpringData {
    private EmployeeRepositorySpringData employeeRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepositorySpringData employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();

    }

    @Override
    public List<Employee> findAll(Sort sort) {
        return null;
    }

    @Override
    public List<Employee> findAllById(Iterable<Integer> ids) {
        return null;
    }

    @Override
    public <S extends Employee> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Employee> S saveAndFlush(S entity) {
        return employeeRepository.saveAndFlush(entity);
    }

    @Override
    public <S extends Employee> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Employee> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> ids) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Employee getOne(Integer id) {
        return null;
    }

    @Override
    public Employee getById(Integer id) {
        return employeeRepository.getById(id);
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Employee> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Employee> S save(S entity) {
        return null;
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return null;
    }

    @Override
    public boolean existsById(Integer id) {
        return false;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public void delete(Employee entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> ids) {

    }

    @Override
    public void deleteAll(Iterable<? extends Employee> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Employee> Optional<S> findOne(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Employee> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Employee> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Employee> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Employee, R> R findBy(Example<S> example, Function<FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}
