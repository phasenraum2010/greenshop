package org.woehlke.greenshop.admin.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.admin.entities.TaxZone;

/**
 * Created by tw on 05.01.15.
 */
public interface TaxZoneRepository extends JpaRepository<TaxZone, Long> {
}
