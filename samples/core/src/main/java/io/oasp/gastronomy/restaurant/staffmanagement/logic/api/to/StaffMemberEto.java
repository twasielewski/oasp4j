package io.oasp.gastronomy.restaurant.staffmanagement.logic.api.to;

import java.util.Locale;

import io.oasp.gastronomy.restaurant.general.common.api.datatype.Role;
import io.oasp.gastronomy.restaurant.staffmanagement.common.api.StaffMember;
import io.oasp.module.basic.common.api.to.AbstractEto;

/**
 * The {@link AbstractEto ETO} for a {@link StaffMember}.
 */
public class StaffMemberEto extends AbstractEto implements StaffMember {

  private static final long serialVersionUID = 1L;

  private String name;

  private String firstName;

  private String lastName;

  private Role role;

  private Locale language;

  private String password;

  /**
   * The constructor.
   */
  public StaffMemberEto() {

    super();
  }

  @Override
  public String getName() {

    return this.name;
  }

  @Override
  public void setName(String name) {

    this.name = name;
  }

  @Override
  public String getFirstName() {

    return this.firstName;
  }

  @Override
  public void setFirstName(String firstName) {

    this.firstName = firstName;
  }

  @Override
  public String getLastName() {

    return this.lastName;
  }

  @Override
  public void setLastName(String lastName) {

    this.lastName = lastName;
  }

  @Override
  public Role getRole() {

    return this.role;
  }

  @Override
  public void setRole(Role role) {

    this.role = role;
  }

  /**
   * @return language
   */
  public Locale getLanguage() {

    return this.language;
  }

  /**
   * @param language the language to set
   */
  public void setLanguage(Locale language) {

    this.language = language;
  }

  @Override
  public int hashCode() {

    final int prime = 31;
    int result = super.hashCode();
    result = prime * result + ((this.name == null) ? 0 : this.name.hashCode());
    result = prime * result + ((this.firstName == null) ? 0 : this.firstName.hashCode());
    result = prime * result + ((this.lastName == null) ? 0 : this.lastName.hashCode());
    result = prime * result + ((this.role == null) ? 0 : this.role.hashCode());
    result = prime * result + ((this.password == null) ? 0 : this.password.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {

    if (this == obj) {
      return true;
    }
    if (obj == null) {
      return false;
    }
    // class check will be done by super type EntityTo!
    if (!super.equals(obj)) {
      return false;
    }
    StaffMemberEto other = (StaffMemberEto) obj;
    if (this.name == null) {
      if (other.name != null) {
        return false;
      }
    } else if (!this.name.equals(other.name)) {
      return false;
    }
    if (this.firstName == null) {
      if (other.firstName != null) {
        return false;
      }
    } else if (!this.firstName.equals(other.firstName)) {
      return false;
    }
    if (this.lastName == null) {
      if (other.lastName != null) {
        return false;
      }
    } else if (!this.lastName.equals(other.lastName)) {
      return false;
    }
    if (this.role == null) {
      if (other.role != null) {
        return false;
      }
    } else if (!this.role.equals(other.role)) {
      return false;
    }
    if (this.password == null) {
      if (other.password != null) {
        return false;
      }
    } else if (!this.password.equals(other.password)) {
      return false;
    }
    return true;
  }

}
