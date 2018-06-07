package io.oasp.gastronomy.restaurant.offermanagement.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.common.base.AbstractRestServiceTest;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialEto;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.WeeklyPeriod;
import io.oasp.gastronomy.restaurant.offermanagement.service.api.rest.OffermanagementRestService;
import io.oasp.module.service.common.api.client.ServiceClientFactory;
import io.oasp.module.service.common.api.client.config.ServiceClientConfigBuilder;

@RunWith(SpringRunner.class)
public class OffermanagementRestServiceTest extends AbstractRestServiceTest {

  private static final String LOGIN_CHIEF = "chief";

  private static final Long OFFER_ID = 1L;

  private static final int LUNCH_TIME_FROM = 12;

  private static final int LUNCH_TIME_TO = 14;

  private OffermanagementRestService offerManagementRestService;

  @Inject
  private ServiceClientFactory serviceClientFactory;

  /**
   * Provides initialization previous to the creation of the text fixture.
   */
  @Override
  public void doSetUp() {

    super.doSetUp();
    getDbTestHelper().resetDatabase();
    this.offerManagementRestService = this.serviceClientFactory.create(OffermanagementRestService.class,
        new ServiceClientConfigBuilder().userLogin(LOGIN_CHIEF).buildMap());
  }

  /**
   * Provides clean up after tests.
   */
  @Override
  public void doTearDown() {

    this.offerManagementRestService = null;
    super.doTearDown();
  }

  @Test
  public void testFindSpecial() {

    // given
    Long testSpecialId = 1L;
    // when
    SpecialEto result = this.offerManagementRestService.getSpecial(testSpecialId);
    // then
    assertThat(result).isNotNull();
  }

  @Test
  public void testSaveSpecial() {

    // given
    SpecialEto newSpecial = prepareSpecial();

    // when
    SpecialEto savedSpecial = this.offerManagementRestService.saveSpecial(newSpecial);

    // then
    assertThat(savedSpecial).isNotNull();
    assertThat(savedSpecial.getName()).isEqualTo(newSpecial.getName());
  }

  @Test
  public void testDeleteSpecial() {

    // given
    Long testSpecialId = 1L;
    assertThat(this.offerManagementRestService.getSpecial(testSpecialId)).isNotNull();

    // when
    this.offerManagementRestService.deleteSpecial(testSpecialId);

    // then
    assertThat(this.offerManagementRestService.getSpecial(testSpecialId)).isNull();
  }

  @Test
  public void testGetAllActiveSpecialsAtLunchTime() {

    // when
    List<SpecialEto> resultList = this.offerManagementRestService.getAllActiveSpecialsAtLunchTime();
    // then
    assertThat(resultList).isNotNull();
    for (SpecialEto special : resultList) {
      assertThat(special.getActivePeriod()).isNotNull();
      assertThat(special.getActivePeriod().getStartingHour()).isGreaterThanOrEqualTo(LUNCH_TIME_FROM);
      assertThat(special.getActivePeriod().getEndingHour()).isLessThanOrEqualTo(LUNCH_TIME_TO);
    }

  }

  private SpecialEto prepareSpecial() {

    SpecialEto newSpecial = new SpecialEto();
    newSpecial.setName("10% discount");
    newSpecial.setSpecialPrice(new Money(10));
    newSpecial.setActivePeriod(prepareActivePeriod());
    newSpecial.setOffer(this.offerManagementRestService.getOffer(OFFER_ID));
    return newSpecial;
  }

  private WeeklyPeriod prepareActivePeriod() {

    WeeklyPeriod activePeriod = new WeeklyPeriod();
    activePeriod.setEndingHour(14);
    activePeriod.setStartingHour(6);
    LocalDateTime currentDateTime = LocalDateTime.now();
    activePeriod.setStartingDay(currentDateTime.getDayOfWeek().minus(1));
    activePeriod.setEndingDay(currentDateTime.getDayOfWeek().plus(2));
    return activePeriod;
  }

}
