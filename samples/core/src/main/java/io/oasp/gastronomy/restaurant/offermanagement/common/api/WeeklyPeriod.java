package io.oasp.gastronomy.restaurant.offermanagement.common.api;

import java.time.DayOfWeek;

/**
 * This is the interface for an {@link WeeklyPeriod}
 *
 */
public interface WeeklyPeriod {

  /**
   * @return the DayOfWeek of this item.
   */
  DayOfWeek getStartingDay();

  /**
   * @param startingDay new value of {@link #getStartingDay}.
   */
  void setStartingDay(DayOfWeek startingDay);

  /**
   * @return the StartingHour of this item.
   */
  int getStartingHour();

  /**
   * @param startingHour new value of {@link #getStartingHour}.
   */
  void setStartingHour(int startingHour);

  /**
   * @return the DayOfWeek of this item.
   */
  DayOfWeek getEndingDay();

  /**
   * @param endingDay new value of {@link #getEndingDay}.
   */
  void setEndingDay(DayOfWeek endingDay);

  /**
   * @return the EndingHour of this item.
   */
  int getEndingHour();

  /**
   * @param endingHour new value of {@link #getEndingHour}.
   */
  void setEndingHour(int endingHour);

}
