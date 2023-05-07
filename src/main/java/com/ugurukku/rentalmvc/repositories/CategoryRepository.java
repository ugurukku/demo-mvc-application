package com.ugurukku.rentalmvc.repositories;

import com.ugurukku.rentalmvc.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
