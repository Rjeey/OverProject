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
 * Agreement reference. An agreement represents a contract or arrangement, either written or verbal and sometimes enforceable by law, such as a service level agreement or a customer price agreement. An agreement involves a number of other business entities, such as products, services, and resources and/or their specifications.
 */
@ApiModel(description = "Agreement reference. An agreement represents a contract or arrangement, either written or verbal and sometimes enforceable by law, such as a service level agreement or a customer price agreement. An agreement involves a number of other business entities, such as products, services, and resources and/or their specifications.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-11T18:16:30.627+03:00")

@Entity
@Table(name = "agreementRef")
public class AgreementRef   {
  @JsonProperty("href")
  @Column
  private String href = null;

  @JsonProperty("id")
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String id = null;

  @JsonProperty("name")
  @Column
  private String name = null;

  public AgreementRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the agreement
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the agreement")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public AgreementRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Identifier of the agreement
   * @return id
  **/
  @ApiModelProperty(value = "Identifier of the agreement")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public AgreementRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the agreement
   * @return name
  **/
  @ApiModelProperty(value = "Name of the agreement")


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    AgreementRef agreementRef = (AgreementRef) o;
    return Objects.equals(this.href, agreementRef.href) &&
        Objects.equals(this.id, agreementRef.id) &&
        Objects.equals(this.name, agreementRef.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class AgreementRef {\n");
    
    sb.append("    href: ").append(toIndentedString(href)).append("\n");
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    name: ").append(toIndentedString(name)).append("\n");
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

