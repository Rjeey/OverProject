package io.swagger.model;

import java.math.BigDecimal;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.model.AccountRef;
import io.swagger.model.AgreementRef;
import io.swagger.model.Characteristic;
import io.swagger.model.ContactMedium;
import io.swagger.model.CreditProfile;
import io.swagger.model.PartyRef;
import io.swagger.model.PaymentMethodRef;
import io.swagger.model.RelatedPartyRef;
import io.swagger.model.RoleTypeRef;
import io.swagger.model.TimePeriod;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.annotations.Type;
import org.springframework.validation.annotation.Validated;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.*;

/**
 * Customer
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-11T18:16:30.627+03:00")

@Entity
@Table(name = "customer")
public class Customer {
    @JsonProperty("href")
    @Column
    private String href = null;

    @JsonProperty("id")
    @Id
    @GeneratedValue(generator = "uuid")
    @GenericGenerator(name = "uuid", strategy = "uuid2")
    private String id = null;

    @JsonProperty("name")
    @Column
    private String name = null;

    @JsonProperty("status")
    @Column
    private String status = null;

    @JsonProperty("statusReason")
    @Column
    private String statusReason = null;

    @JsonProperty("validFor")
    @Embedded
    private TimePeriod validFor = null;

    @JsonProperty("engagedParty")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private PartyRef engagedParty = null;

    @JsonProperty("type")
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    private RoleTypeRef type = null;

    @JsonProperty("account")
    @Valid
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AccountRef> account = null;

    @JsonProperty("paymentMethod")
    @Valid
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<PaymentMethodRef> paymentMethod = null;

    @JsonProperty("contactMedium")
    @Valid
  @OneToMany(
          cascade = CascadeType.ALL,
          orphanRemoval = true
  )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<ContactMedium> contactMedium = null;

    @JsonProperty("characteristic")
    @Valid
    @Embedded
    private List<Characteristic> characteristic = null;

    @JsonProperty("creditProfile")
    @Valid
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<CreditProfile> creditProfile = null;

    @JsonProperty("agreement")
    @Valid
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<AgreementRef> agreement = null;

    @JsonProperty("relatedParty")
    @Valid
    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true
    )
    @LazyCollection(LazyCollectionOption.FALSE)
    private List<RelatedPartyRef> relatedParty = null;

    public Customer href(String href) {
        this.href = href;
        return this;
    }

    /**
     * Url used to reference the party role.
     *
     * @return href
     **/
    @ApiModelProperty(value = "Url used to reference the party role.")


    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Customer id(String id) {
        this.id = id;
        return this;
    }

    /**
     * Unique identifier for PartyRoles
     *
     * @return id
     **/
    @ApiModelProperty(value = "Unique identifier for PartyRoles")


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Customer name(String name) {
        this.name = name;
        return this;
    }

    /**
     * A word, term, or phrase by which the PartyRole is known and distinguished from other PartyRoles.
     *
     * @return name
     **/
    @ApiModelProperty(value = "A word, term, or phrase by which the PartyRole is known and distinguished from other PartyRoles.")


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Customer status(String status) {
        this.status = status;
        return this;
    }

    /**
     * Used to track the lifecycle status of the party role.
     *
     * @return status
     **/
    @ApiModelProperty(value = "Used to track the lifecycle status of the party role.")


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Customer statusReason(String statusReason) {
        this.statusReason = statusReason;
        return this;
    }

    /**
     * A string providing an explanation on the value of the status lifecycle. For instance if the status is Rejected, statusReason will provide the reason for rejection.
     *
     * @return statusReason
     **/
    @ApiModelProperty(value = "A string providing an explanation on the value of the status lifecycle. For instance if the status is Rejected, statusReason will provide the reason for rejection.")


    public String getStatusReason() {
        return statusReason;
    }

    public void setStatusReason(String statusReason) {
        this.statusReason = statusReason;
    }

    public Customer validFor(TimePeriod validFor) {
        this.validFor = validFor;
        return this;
    }

    /**
     * The time period that the PartyRole is valid for.
     *
     * @return validFor
     **/
    @ApiModelProperty(value = "The time period that the PartyRole is valid for.")

    @Valid

    public TimePeriod getValidFor() {
        return validFor;
    }

    public void setValidFor(TimePeriod validFor) {
        this.validFor = validFor;
    }

    public Customer engagedParty(PartyRef engagedParty) {
        this.engagedParty = engagedParty;
        return this;
    }

    /**
     * Get engagedParty
     *
     * @return engagedParty
     **/
    @ApiModelProperty(value = "")

    @Valid

    public PartyRef getEngagedParty() {
        return engagedParty;
    }

    public void setEngagedParty(PartyRef engagedParty) {
        this.engagedParty = engagedParty;
    }

    public Customer type(RoleTypeRef type) {
        this.type = type;
        return this;
    }

    /**
     * Get type
     *
     * @return type
     **/
    @ApiModelProperty(value = "")

    @Valid

    public RoleTypeRef getType() {
        return type;
    }

    public void setType(RoleTypeRef type) {
        this.type = type;
    }

    public Customer account(List<AccountRef> account) {
        this.account = account;
        return this;
    }

    public Customer addAccountItem(AccountRef accountItem) {
        if (this.account == null) {
            this.account = new ArrayList<AccountRef>();
        }
        this.account.add(accountItem);
        return this;
    }

    /**
     * Get account
     *
     * @return account
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<AccountRef> getAccount() {
        return account;
    }

    public void setAccount(List<AccountRef> account) {
        this.account = account;
    }

    public Customer paymentMethod(List<PaymentMethodRef> paymentMethod) {
        this.paymentMethod = paymentMethod;
        return this;
    }

    public Customer addPaymentMethodItem(PaymentMethodRef paymentMethodItem) {
        if (this.paymentMethod == null) {
            this.paymentMethod = new ArrayList<PaymentMethodRef>();
        }
        this.paymentMethod.add(paymentMethodItem);
        return this;
    }

    /**
     * Get paymentMethod
     *
     * @return paymentMethod
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<PaymentMethodRef> getPaymentMethod() {
        return paymentMethod;
    }

    public void setPaymentMethod(List<PaymentMethodRef> paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public Customer contactMedium(List<ContactMedium> contactMedium) {
        this.contactMedium = contactMedium;
        return this;
    }

    public Customer addContactMediumItem(ContactMedium contactMediumItem) {
        if (this.contactMedium == null) {
            this.contactMedium = new ArrayList<ContactMedium>();
        }
        this.contactMedium.add(contactMediumItem);
        return this;
    }

    /**
     * Get contactMedium
     *
     * @return contactMedium
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<ContactMedium> getContactMedium() {
        return contactMedium;
    }

    public void setContactMedium(List<ContactMedium> contactMedium) {
        this.contactMedium = contactMedium;
    }

    public Customer characteristic(List<Characteristic> characteristic) {
        this.characteristic = characteristic;
        return this;
    }

    public Customer addCharacteristicItem(Characteristic characteristicItem) {
        if (this.characteristic == null) {
            this.characteristic = new ArrayList<Characteristic>();
        }
        this.characteristic.add(characteristicItem);
        return this;
    }

    /**
     * Get characteristic
     *
     * @return characteristic
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<Characteristic> getCharacteristic() {
        return characteristic;
    }

    public void setCharacteristic(List<Characteristic> characteristic) {
        this.characteristic = characteristic;
    }

    public Customer creditProfile(List<CreditProfile> creditProfile) {
        this.creditProfile = creditProfile;
        return this;
    }

    public Customer addCreditProfileItem(CreditProfile creditProfileItem) {
        if (this.creditProfile == null) {
            this.creditProfile = new ArrayList<CreditProfile>();
        }
        this.creditProfile.add(creditProfileItem);
        return this;
    }

    /**
     * Get creditProfile
     *
     * @return creditProfile
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<CreditProfile> getCreditProfile() {
        return creditProfile;
    }

    public void setCreditProfile(List<CreditProfile> creditProfile) {
        this.creditProfile = creditProfile;
    }

    public Customer agreement(List<AgreementRef> agreement) {
        this.agreement = agreement;
        return this;
    }

    public Customer addAgreementItem(AgreementRef agreementItem) {
        if (this.agreement == null) {
            this.agreement = new ArrayList<AgreementRef>();
        }
        this.agreement.add(agreementItem);
        return this;
    }

    /**
     * Get agreement
     *
     * @return agreement
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<AgreementRef> getAgreement() {
        return agreement;
    }

    public void setAgreement(List<AgreementRef> agreement) {
        this.agreement = agreement;
    }

    public Customer relatedParty(List<RelatedPartyRef> relatedParty) {
        this.relatedParty = relatedParty;
        return this;
    }

    public Customer addRelatedPartyItem(RelatedPartyRef relatedPartyItem) {
        if (this.relatedParty == null) {
            this.relatedParty = new ArrayList<RelatedPartyRef>();
        }
        this.relatedParty.add(relatedPartyItem);
        return this;
    }

    /**
     * Get relatedParty
     *
     * @return relatedParty
     **/
    @ApiModelProperty(value = "")

    @Valid

    public List<RelatedPartyRef> getRelatedParty() {
        return relatedParty;
    }

    public void setRelatedParty(List<RelatedPartyRef> relatedParty) {
        this.relatedParty = relatedParty;
    }


    @Override
    public boolean equals(java.lang.Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Customer customer = (Customer) o;
        return Objects.equals(this.href, customer.href) &&
                Objects.equals(this.id, customer.id) &&
                Objects.equals(this.name, customer.name) &&
                Objects.equals(this.status, customer.status) &&
                Objects.equals(this.statusReason, customer.statusReason) &&
                Objects.equals(this.validFor, customer.validFor) &&
                Objects.equals(this.engagedParty, customer.engagedParty) &&
                Objects.equals(this.type, customer.type) &&
                Objects.equals(this.account, customer.account) &&
                Objects.equals(this.paymentMethod, customer.paymentMethod) &&
                Objects.equals(this.contactMedium, customer.contactMedium) &&
                Objects.equals(this.characteristic, customer.characteristic) &&
                Objects.equals(this.creditProfile, customer.creditProfile) &&
                Objects.equals(this.agreement, customer.agreement) &&
                Objects.equals(this.relatedParty, customer.relatedParty);
    }

    @Override
    public int hashCode() {
        return Objects.hash(href, id, name, status, statusReason, validFor, engagedParty, type, account, paymentMethod, contactMedium, characteristic, creditProfile, agreement, relatedParty);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Customer {\n");

        sb.append("    href: ").append(toIndentedString(href)).append("\n");
        sb.append("    id: ").append(toIndentedString(id)).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("    statusReason: ").append(toIndentedString(statusReason)).append("\n");
        sb.append("    validFor: ").append(toIndentedString(validFor)).append("\n");
        sb.append("    engagedParty: ").append(toIndentedString(engagedParty)).append("\n");
        sb.append("    type: ").append(toIndentedString(type)).append("\n");
        sb.append("    account: ").append(toIndentedString(account)).append("\n");
        sb.append("    paymentMethod: ").append(toIndentedString(paymentMethod)).append("\n");
        sb.append("    contactMedium: ").append(toIndentedString(contactMedium)).append("\n");
        sb.append("    characteristic: ").append(toIndentedString(characteristic)).append("\n");
        sb.append("    creditProfile: ").append(toIndentedString(creditProfile)).append("\n");
        sb.append("    agreement: ").append(toIndentedString(agreement)).append("\n");
        sb.append("    relatedParty: ").append(toIndentedString(relatedParty)).append("\n");
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

