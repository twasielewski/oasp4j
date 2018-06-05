package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api;

import java.time.DayOfWeek;

import javax.persistence.Embeddable;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.oasp.gastronomy.restaurant.offermanagement.common.api.WeeklyPeriod;

/**
 * The {@link io.oasp.gastronomy.restaurant.general.dataaccess.api.ApplicationPersistenceEntity persistent entity} for
 * {@link WeeklyPeriodEmbeddable}.
 *
 */
@Embeddable
public class WeeklyPeriodEmbeddable implements WeeklyPeriod {

  private DayOfWeek startingDay;

  @Max(24)
  @Min(0)
  private int startingHour;

  private DayOfWeek endingDay;

  @Max(24)
  @Min(0)
  private int endingHour;

  /**
   * @return startingDay
   */
  public DayOfWeek getStartingDay() {

    return this.startingDay;
  }

  /**
   * @param startingDay new value of {@link #getStartingDay}.
   */
  public void setStartingDay(DayOfWeek startingDay) {

    this.startingDay = startingDay;
  }

  /**
   * @return startingHour
   */
  public int getStartingHour() {

    return this.startingHour;
  }

  /**
   * @param startingHour new value of {@link #getStartingHour}.
   */
  public void setStartingHour(int startingHour) {

    this.startingHour = startingHour;
  }

  /**
   * @return endingDay
   */
  public DayOfWeek getEndingDay() {

    return this.endingDay;
  }

  /**
   * @param endingDay new value of {@link #getEndingDay}.
   */
  public void setEndingDay(DayOfWeek endingDay) {

    this.endingDay = endingDay;
  }

  /**
   * @return endingHour
   */
  public int getEndingHour() {

    return this.endingHour;
  }

  /**
   * @param endingHour new value of {@link #getEndingHour}.
   */
  public void setEndingHour(int endingHour) {

    this.endingHour = endingHour;
  }

}
