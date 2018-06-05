package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;
import io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.Special;
import io.oasp.gastronomy.restaurant.offermanagement.common.api.WeeklyPeriod;

/**
 * The {@link io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity persistent entity} for
 * {@link Special}.
 *
 */
@Entity
@Table(name = "Special")
public class SpecialEntity extends ApplicationPersistenceEntity implements Special {

  private static final long serialVersionUID = -6337189700397282587L;

  private String name;

  private OfferEntity offer;

  private WeeklyPeriodEmbeddable activePeriod;

  private Money specialPrice;

  /**
   * The constructor.
   */
  public SpecialEntity() {

    super();
  }

  /**
   * @return name
   */
  @Column(unique = true)
  public String getName() {

    return this.name;
  }

  /**
   * @param name new value of {@link #getName}.
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return offer
   */
  @ManyToOne
  @JoinColumn(name = "offerId")
  public OfferEntity getOffer() {

    return this.offer;
  }

  /**
   * @param offer new value of {@link #getOffer}.
   */
  public void setOffer(OfferEntity offer) {

    this.offer = offer;
  }

  @Override
  @Transient
  public Long getOfferId() {

    if (this.offer == null) {
      return null;
    }
    return this.offer.getId();
  }

  @Override
  public void setOfferId(Long offerId) {

    if (offerId == null) {
      this.offer = null;
    } else {
      OfferEntity offerEntity = new OfferEntity();
      offerEntity.setId(offerId);
      this.offer = offerEntity;
    }
  }

  /**
   * @return activePeriod
   */
  @Embedded
  public WeeklyPeriodEmbeddable getActivePeriod() {

    return this.activePeriod;
  }

  /**
   * @param activePeriod new value of {@link #getActivePeriod}.
   */
  public void setActivePeriod(WeeklyPeriod activePeriod) {

    this.activePeriod = new WeeklyPeriodEmbeddable();
    this.activePeriod.setEndingDay(activePeriod.getEndingDay());
    this.activePeriod.setEndingHour(activePeriod.getEndingHour());
    this.activePeriod.setStartingDay(activePeriod.getStartingDay());
    this.activePeriod.setStartingHour(activePeriod.getStartingHour());
  }

  /**
   * @return specialPrice
   */
  public Money getSpecialPrice() {

    return this.specialPrice;
  }

  /**
   * @param specialPrice new value of {@link #getSpecialPrice}.
   */
  public void setSpecialPrice(Money specialPrice) {

    this.specialPrice = specialPrice;
  }

}
