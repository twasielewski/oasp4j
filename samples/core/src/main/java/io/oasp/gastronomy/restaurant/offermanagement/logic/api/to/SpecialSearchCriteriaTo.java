package io.oasp.gastronomy.restaurant.offermanagement.logic.api.to;

import java.time.LocalDateTime;

import io.oasp.module.jpa.common.api.to.SearchCriteriaTo;

/**
 * This is the {@link SearchCriteriaTo search criteria} {@link net.sf.mmm.util.transferobject.api.TransferObject TO}
 * used to find {@link io.oasp.gastronomy.restaurant.salesmanagement.common.api.Order}s.
 *
 */
public class SpecialSearchCriteriaTo extends SearchCriteriaTo {

  /** UID for serialization. */
  private static final long serialVersionUID = 1L;

  private String name;

  private Long offerId;

  private LocalDateTime dateOfChecking;

  /**
   * The constructor.
   */
  public SpecialSearchCriteriaTo() {

    super();
  }

  /**
   * @return name of the special offer
   */
  public String getName() {

    return this.name;
  }

  /**
   * @param name of the special offer
   */
  public void setName(String name) {

    this.name = name;
  }

  /**
   * @return offerId
   */
  public Long getOfferId() {

    return this.offerId;
  }

  /**
   * @param offerId the offerId to set
   */
  public void setOfferId(Long offerId) {

    this.offerId = offerId;
  }

  /**
   * @return dateOfChecking
   */
  public LocalDateTime getDateOfChecking() {

    return this.dateOfChecking;
  }

  /**
   * @param dateOfChecking new value of {@link #getDateOfChecking}.
   */
  public void setDateOfChecking(LocalDateTime dateOfChecking) {

    this.dateOfChecking = dateOfChecking;
  }

}
