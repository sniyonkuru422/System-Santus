package com.example.daviscollegeapp.repository;

import com.example.daviscollegeapp.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course , Integer> {

}
