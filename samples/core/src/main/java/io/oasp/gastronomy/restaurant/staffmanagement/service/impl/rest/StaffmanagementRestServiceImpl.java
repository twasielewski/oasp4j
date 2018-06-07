package io.oasp.gastronomy.restaurant.staffmanagement.service.impl.rest;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import io.oasp.gastronomy.restaurant.staffmanagement.logic.api.Staffmanagement;
import io.oasp.gastronomy.restaurant.staffmanagement.logic.api.to.StaffMemberCto;
import io.oasp.gastronomy.restaurant.staffmanagement.logic.api.to.StaffMemberEto;
import io.oasp.gastronomy.restaurant.staffmanagement.logic.api.to.StaffMemberSearchCriteriaTo;
import io.oasp.gastronomy.restaurant.staffmanagement.service.api.rest.StaffmanagementRestService;
import io.oasp.module.jpa.common.api.to.PaginatedListTo;

/**
 */
@Named("StaffmanagementRestService")
public class StaffmanagementRestServiceImpl implements StaffmanagementRestService {

  private Staffmanagement staffmanagement;

  /**
   * @param staffManagement the staffManagement to be set
   */
  @Inject
  public void setStaffmanagement(Staffmanagement staffManagement) {

    this.staffmanagement = staffManagement;
  }

  @Override
  public List<StaffMemberEto> getAllStaffMember() {

    return this.staffmanagement.findAllStaffMembers();
  }

  @Override
  public StaffMemberEto getStaffMember(String login) {

    return this.staffmanagement.findStaffMemberByLogin(login);
  }

  @Override
  @Deprecated
  public void updateStaffMember(StaffMemberEto staffMemberBo) {

    this.staffmanagement.saveStaffMember(staffMemberBo);
  }

  @Override
  public StaffMemberEto saveStaffMember(StaffMemberEto staffMemberEto) {

    return this.staffmanagement.saveStaffMember(staffMemberEto);
  }

  @Override
  public void deleteStaffMember(String login) {

    this.staffmanagement.deleteStaffMemberByLogin(login);
  }

  @Override
  public PaginatedListTo<StaffMemberEto> findStaffMembersByPost(StaffMemberSearchCriteriaTo searchCriteriaTo) {

    return this.staffmanagement.findStaffMemberEtos(searchCriteriaTo);
  }

  @Override
  public StaffMemberEto getStaffMember(long id) {

    return this.staffmanagement.findStaffMember(id);
  }

  @Override
  public void deleteStaffMember(long id) {

    this.staffmanagement.deleteStaffMember(id);
  }

  @Override
  public StaffMemberCto getStaffMemberCto(long id) {

    return this.staffmanagement.findStaffMemberCto(id);
  }

  @Override
  public PaginatedListTo<StaffMemberCto> findStaffMemberCtosByPost(StaffMemberSearchCriteriaTo searchCriteriaTo) {

    return this.staffmanagement.findStaffMemberCtos(searchCriteriaTo);
  }

}
