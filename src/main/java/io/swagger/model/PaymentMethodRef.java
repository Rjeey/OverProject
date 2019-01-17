package io.swagger.model;

import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
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
 * PaymentMethod reference. A payment method defines a specific mean of payment (e.g direct debit).
 */
@ApiModel(description = "PaymentMethod reference. A payment method defines a specific mean of payment (e.g direct debit).")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-11T18:16:30.627+03:00")

@Entity
@Table(name = "paymentMethodRef")
public class PaymentMethodRef   {
  @JsonProperty("href")
  @Column
  private String href = null;

  @JsonIgnore
  @Id
  @GeneratedValue(generator = "UUID")
  @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
  private String id = null;

  @JsonProperty("name")
  @Column
  private String name = null;

  public PaymentMethodRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the payment mean
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the payment mean")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public PaymentMethodRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the payment mean
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the payment mean")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PaymentMethodRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the payment mean
   * @return name
  **/
  @ApiModelProperty(value = "Name of the payment mean")


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
    PaymentMethodRef paymentMethodRef = (PaymentMethodRef) o;
    return Objects.equals(this.href, paymentMethodRef.href) &&
        Objects.equals(this.id, paymentMethodRef.id) &&
        Objects.equals(this.name, paymentMethodRef.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(href, id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PaymentMethodRef {\n");
    
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

