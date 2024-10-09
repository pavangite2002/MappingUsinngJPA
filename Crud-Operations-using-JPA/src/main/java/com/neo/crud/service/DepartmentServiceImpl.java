package com.neo.crud.service;

import com.neo.crud.exception.DepartmentNotFoundException;
import com.neo.crud.model.Department;
import com.neo.crud.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentServiceImpl implements DepartmentService{

        private final DepartmentRepository departmentRepository;

        public Department createDepartment(Department department) {
            return departmentRepository.save(department);
        }

        public List<Department> getAllDepartments() {
            return departmentRepository.findAll();
        }

        public Department getDepartmentById(Long id) {
            return departmentRepository.findById(id)
                    .orElseThrow(() -> new DepartmentNotFoundException("Department with id " + id + " not found"));
        }

        public Department updateDepartment(Long id, Department department) {
            Department existingDepartment = getDepartmentById(id);
            existingDepartment.setName(department.getName());
            return departmentRepository.save(existingDepartment);
        }
        public void deleteDepartment(Long id) {
            Department existingDepartment = getDepartmentById(id);
            departmentRepository.delete(existingDepartment);
        }
    }


