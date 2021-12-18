package org.sid.demospringjavafx.repo;

import org.sid.demospringjavafx.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
