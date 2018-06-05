package io.oasp.gastronomy.restaurant.offermanagement.common.api;

import io.oasp.gastronomy.restaurant.general.common.api.ApplicationEntity;
import io.oasp.gastronomy.restaurant.general.common.api.datatype.Money;

/**
 * This is the interface for an {@link Special}
 *
 */
public interface Special extends ApplicationEntity {

  /**
   * @return the display name of this item.
   */
  String getName();

  /**
   * @param name is the new {@link #getName() name}.
   */
  void setName(String name);

  /**
   * @return the offerId related to this item.
   */
  Long getOfferId();

  /**
   * @param offerId is the new {@link #getOfferId() offerId}.
   */
  void setOfferId(Long offerId);

  /**
   * @return the active period of this item.
   */
  WeeklyPeriod getActivePeriod();

  /**
   * @param activePeriod is the new {@link #getActivePeriod() activePeriod}.
   */
  void setActivePeriod(WeeklyPeriod activePeriod);

  /**
   * @return the special price of this item.
   */
  Money getSpecialPrice();

  /**
   * @param specialPrice new value of {@link #getSpecialPrice}.
   */
  void setSpecialPrice(Money specialPrice);

}
