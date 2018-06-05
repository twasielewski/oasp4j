package io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.dao;

import java.util.List;

import io.oasp.gastronomy.restaurant.general.dataaccess.api.dao.ApplicationDao;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.OfferEntity;
import io.oasp.gastronomy.restaurant.offermanagement.dataaccess.api.SpecialEntity;
import io.oasp.gastronomy.restaurant.offermanagement.logic.api.to.SpecialSearchCriteriaTo;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;
import io.oasp.module.jpa.dataaccess.api.MasterDataDao;

/**
 * {@link ApplicationDao Data Access Object} for {@link OfferEntity} entity.
 *
 */
public interface SpecialDao extends ApplicationDao<SpecialEntity>, MasterDataDao<SpecialEntity> {

  /**
   * Finds all active {@link SpecialEntity} objects matching the given {@link SpecialSearchCriteriaTo}.
   *
   * @param criteria is the {@link SpecialSearchCriteriaTo}.
   * @return the {@link List} with the matching {@link SpecialEntity} objects.
   */
  PaginatedListTo<SpecialEntity> findAllActiveSpecialOffers(SpecialSearchCriteriaTo criteria);

}
