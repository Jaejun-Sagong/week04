package com.sparta.week04.models;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> { //JpaRepository를 상속받아 사용할 거고 Product를 대상으로 JPA할거고 Long형태다.
}