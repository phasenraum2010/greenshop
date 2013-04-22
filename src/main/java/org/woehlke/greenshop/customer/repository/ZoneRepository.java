package org.woehlke.greenshop.customer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.woehlke.greenshop.customer.entities.Country;
import org.woehlke.greenshop.customer.entities.Zone;

public interface ZoneRepository extends JpaRepository<Zone,Long> {

	List<Zone> findByCountry(Country country);
}
