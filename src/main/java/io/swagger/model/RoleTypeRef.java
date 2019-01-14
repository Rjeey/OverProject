package io.swagger.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * RoleType reference.
 */
@ApiModel(description = "RoleType reference.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-11T18:16:30.627+03:00")

@Entity
@Table(name = "roleTypeRef")
public class RoleTypeRef   {
  @JsonProperty("name")
  @Column
  private String name = null;

  @JsonProperty("partnershipHref")
  @Column
  private String partnershipHref = null;

  @JsonProperty("partnershipId")
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String partnershipId = null;

  @JsonProperty("partnershipName")
  @Column
  private String partnershipName = null;

  public RoleTypeRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * The name of the role type. It uniquely identifies the role type within the partnership type.
   * @return name
  **/
  @ApiModelProperty(value = "The name of the role type. It uniquely identifies the role type within the partnership type.")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public RoleTypeRef partnershipHref(String partnershipHref) {
    this.partnershipHref = partnershipHref;
    return this;
  }

  /**
   * Reference url of the partnership type containing the role type
   * @return partnershipHref
  **/
  @ApiModelProperty(value = "Reference url of the partnership type containing the role type")


  public String getPartnershipHref() {
    return partnershipHref;
  }

  public void setPartnershipHref(String partnershipHref) {
    this.partnershipHref = partnershipHref;
  }

  public RoleTypeRef partnershipId(String partnershipId) {
    this.partnershipId = partnershipId;
    return this;
  }

  /**
   * The identifier of the partnership type containing the role type
   * @return partnershipId
  **/
  @ApiModelProperty(value = "The identifier of the partnership type containing the role type")


  public String getPartnershipId() {
    return partnershipId;
  }

  public void setPartnershipId(String partnershipId) {
    this.partnershipId = partnershipId;
  }

  public RoleTypeRef partnershipName(String partnershipName) {
    this.partnershipName = partnershipName;
    return this;
  }

  /**
   * The name of the partnership type defining this role type
   * @return partnershipName
  **/
  @ApiModelProperty(value = "The name of the partnership type defining this role type")


  public String getPartnershipName() {
    return partnershipName;
  }

  public void setPartnershipName(String partnershipName) {
    this.partnershipName = partnershipName;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    RoleTypeRef roleTypeRef = (RoleTypeRef) o;
    return Objects.equals(this.name, roleTypeRef.name) &&
        Objects.equals(this.partnershipHref, roleTypeRef.partnershipHref) &&
        Objects.equals(this.partnershipId, roleTypeRef.partnershipId) &&
        Objects.equals(this.partnershipName, roleTypeRef.partnershipName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name, partnershipHref, partnershipId, partnershipName);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class RoleTypeRef {\n");
    
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
    sb.append("    partnershipHref: ").append(toIndentedString(partnershipHref)).append("\n");
    sb.append("    partnershipId: ").append(toIndentedString(partnershipId)).append("\n");
    sb.append("    partnershipName: ").append(toIndentedString(partnershipName)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }
}

