package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.impl.dao;

import static com.querydsl.core.alias.Alias.$;

import java.time.LocalDateTime;

import javax.inject.Named;

import com.querydsl.core.alias.Alias;
import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPAQuery;

import io.oasp.gastronomy.restaurant.general.dataaccess.base.dao.ApplicationMasterDataDaoImpl;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao.SpecialDao;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 * Implementation of {@link SpecialDao}.
 *
 */
@Named
public class SpecialDaoImpl extends ApplicationMasterDataDaoImpl<SpecialEntity> implements SpecialDao {

  /**
   * The constructor.
   */
  public SpecialDaoImpl() {

    super();
  }

  @Override
  public Class<SpecialEntity> getEntityClass() {

    return SpecialEntity.class;
  }

  @Override
  public PaginatedListTo<SpecialEntity> findAllActiveSpecialOffers(SpecialSearchCriteriaTo criteria) {

    SpecialEntity specialOffer = Alias.alias(SpecialEntity.class);
    EntityPathBase<SpecialEntity> alias = $(specialOffer);
    JPAQuery<SpecialEntity> query = new JPAQuery<SpecialEntity>(getEntityManager()).from(alias);

    String name = criteria.getName();
    if (name != null) {
      query.where($(specialOffer.getName()).eq(name));
    }
    Long offerId = criteria.getOfferId();
    if (offerId != null) {
      query.where($(specialOffer.getOfferId()).eq(offerId));
    }
    LocalDateTime dateOfChecking = criteria.getDateOfChecking();
    if (dateOfChecking != null) {
      query.where($(specialOffer.getActivePeriod().getStartingDay()).loe(dateOfChecking.getDayOfWeek()));
      query.where($(specialOffer.getActivePeriod().getEndingDay()).goe(dateOfChecking.getDayOfWeek()));
      query.where($(specialOffer.getActivePeriod().getStartingHour()).loe(dateOfChecking.getHour()));
      query.where($(specialOffer.getActivePeriod().getEndingHour()).goe(dateOfChecking.getHour()));
    }
    return findPaginated(criteria, query);
  }
}
