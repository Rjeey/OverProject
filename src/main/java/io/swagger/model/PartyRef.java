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
 * Party reference. A party represents an organization or an individual.
 */
@ApiModel(description = "Party reference. A party represents an organization or an individual.")
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-11T18:16:30.627+03:00")

@Entity
@Table(name = "partyRef")
public class PartyRef   {
  @JsonProperty("description")
  @Column
  private String description = null;

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

  public PartyRef description(String description) {
    this.description = description;
    return this;
  }

  /**
   * Text describing the referred party
   * @return description
  **/
  @ApiModelProperty(value = "Text describing the referred party")


  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public PartyRef href(String href) {
    this.href = href;
    return this;
  }

  /**
   * Reference of the referred party (such as a partner or any other party role).
   * @return href
  **/
  @ApiModelProperty(value = "Reference of the referred party (such as a partner or any other party role).")


  public String getHref() {
    return href;
  }

  public void setHref(String href) {
    this.href = href;
  }

  public PartyRef id(String id) {
    this.id = id;
    return this;
  }

  /**
   * Unique identifier of the referred party
   * @return id
  **/
  @ApiModelProperty(value = "Unique identifier of the referred party")


  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public PartyRef name(String name) {
    this.name = name;
    return this;
  }

  /**
   * Name of the referred party (such as a partner or any other party role)
   * @return name
  **/
  @ApiModelProperty(value = "Name of the referred party (such as a partner or any other party role)")


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
    PartyRef partyRef = (PartyRef) o;
    return Objects.equals(this.description, partyRef.description) &&
        Objects.equals(this.href, partyRef.href) &&
        Objects.equals(this.id, partyRef.id) &&
        Objects.equals(this.name, partyRef.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(description, href, id, name);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class PartyRef {\n");
    
    sb.append("    description: ").append(toIndentedString(description)).append("\n");
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

