package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.impl.dao;

import java.time.DayOfWeek;
import java.time.LocalDateTime;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import io.oasp.gastronomy.restaurant.SpringBootApp;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.WeeklyPeriod;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.WeeklyPeriodEmbeddable;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.test.common.base.ComponentTest;

/**
 * Test of {@link SpecialDao}.
 *
 */
@Transactional
@SpringBootTest(classes = { SpringBootApp.class }, webEnvironment = WebEnvironment.RANDOM_PORT)
public class SpecialDaoTest extends ComponentTest {

  @Inject
  private SpecialDao specialDao;

  @PersistenceContext
  private EntityManager entityManager;

  /**
   * Tests if a Special offer is persisted correctly.
   */
  @Test
  public void testPersist() {

    SpecialEntity specialOffer = new SpecialEntity();
    specialOffer.setName("Spring Sale");
    specialOffer.setOfferId(2L);
    specialOffer.setSpecialPrice(new Money(4.99));

    WeeklyPeriod activePeriod = new WeeklyPeriodEmbeddable();
    activePeriod.setStartingDay(DayOfWeek.MONDAY);
    activePeriod.setEndingDay(DayOfWeek.FRIDAY);
    activePeriod.setStartingHour(12);
    activePeriod.setEndingHour(14);

    specialOffer.setActivePeriod(activePeriod);

    assertThat(specialOffer.getId()).isNull();
    this.specialDao.save(specialOffer);
    assertThat(specialOffer.getId()).isNotNull();

  }

  /**
   * Tests if a Special offer is persisted correctly.
   */
  @Test
  public void testFindAllActiveSpecialOffers() {

    SpecialSearchCriteriaTo criteria = new SpecialSearchCriteriaTo();
    LocalDateTime dateOfChecking = LocalDateTime.of(2018, 6, 5, 16, 0);

    criteria.setDateOfChecking(dateOfChecking);

    PaginatedListTo<SpecialEntity> resultList = this.specialDao.findAllActiveSpecialOffers(criteria);
    assertThat(resultList).isNotNull();
  }

}
