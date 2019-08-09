package com.lti.component;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Component;

@Component("carParts4")
public class CarPartsInventoryImpl4 implements CarPartsInventory {

	// @Autowired doesn't work for injecting EntityManager object of JPA. We need
	// @PersistenceContext instead
	@PersistenceContext
	private EntityManager entityManager;

	@Transactional
	public void addNewPart(CarPart carPart) {
		entityManager.persist(carPart);
	}

	public List<CarPart> getAvailableParts() {
		String query = "Select c from CarPart c";
		Query q = entityManager.createQuery(query);

		return q.getResultList();

	}
}