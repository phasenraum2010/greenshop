package org.woehlke.greenshop.catalog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.catalog.entities.Review;

/**
 * Created by tw on 25.12.14.
 */
public interface ReviewRepository extends
        JpaRepository<Review,Long> {
}
