package io.oasp.gastronomy.restaurant.staffmanagement.logic.api.to;

import io.oasp.gastronomy.restaurant.general.common.api.to.AbstractCto;

/**
 * Composite transport object of StaffMember
 */
public class StaffMemberCto extends AbstractCto {

  private static final long serialVersionUID = 1L;

  private StaffMemberEto staffMember;

  public StaffMemberEto getStaffMember() {

    return staffMember;
  }

  public void setStaffMember(StaffMemberEto staffMember) {

    this.staffMember = staffMember;
  }

}
