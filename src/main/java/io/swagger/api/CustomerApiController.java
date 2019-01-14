package io.swagger.api;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.annotations.ApiParam;
import io.swagger.model.Customer;
import io.swagger.model.CustomerCreate;
import io.swagger.model.CustomerUpdate;
import io.swagger.service.CustomerServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.threeten.bp.OffsetDateTime;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.languages.SpringCodegen", date = "2018-12-11T18:16:30.627+03:00")

@Controller
public class CustomerApiController implements CustomerApi {


    private static final Logger log = LoggerFactory.getLogger(CustomerApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @Autowired
    private CustomerServiceImpl customerService;

    @org.springframework.beans.factory.annotation.Autowired
    public CustomerApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }


    public ResponseEntity<Customer> createCustomer(@ApiParam(value = "The Customer to be created", required = true) @Valid @RequestBody CustomerCreate customer) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                Customer newCustomer = new Customer();
                BeanUtils.copyProperties(customer, newCustomer);
//                return new ResponseEntity<Customer>(objectMapper.readValue("{  \"contactMedium\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"type\" : \"type\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"city\" : \"city\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"type\" : \"type\"    }  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"type\" : \"type\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"city\" : \"city\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"type\" : \"type\"    }  } ],  \"creditProfile\" : [ {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"creditRiskRating\" : 0  }, {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"creditRiskRating\" : 0  } ],  \"agreement\" : [ {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"type\" : {    \"partnershipId\" : \"partnershipId\",    \"name\" : \"name\",    \"partnershipName\" : \"partnershipName\",    \"partnershipHref\" : \"partnershipHref\"  },  \"relatedParty\" : [ {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"characteristic\" : [ {    \"name\" : \"name\",    \"value\" : \"value\"  }, {    \"name\" : \"name\",    \"value\" : \"value\"  } ],  \"statusReason\" : \"statusReason\",  \"name\" : \"name\",  \"paymentMethod\" : [ {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"href\" : \"href\",  \"id\" : \"id\",  \"engagedParty\" : {    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"account\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"status\" : \"status\"}", Customer.class), HttpStatus.NOT_IMPLEMENTED);
                customerService.save(newCustomer);
                return new ResponseEntity<Customer>(HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);

            }
        }

        return new ResponseEntity<Customer>(HttpStatus.NOT_IMPLEMENTED);
    }


    public ResponseEntity<Void> deleteCustomer(@ApiParam(value = "Identifier of the Customer", required = true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");

        customerService.delete(id);
//        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
        return new ResponseEntity<Void>(HttpStatus.OK);
    }

    public ResponseEntity<List<Customer>> listCustomer(@ApiParam(value = "Comma separated properties to display in response") @Valid @RequestParam(value = "fields", required = false) String fields, @ApiParam(value = "For filtering: A word, term, or phrase by which the PartyRole is known and distinguished from other PartyRoles.") @Valid @RequestParam(value = "name", required = false) String name, @ApiParam(value = "For filtering: Used to track the lifecycle status of the party role.") @Valid @RequestParam(value = "status", required = false) String status, @ApiParam(value = "For filtering: A string providing an explanation on the value of the status lifecycle. For instance if the status is Rejected, statusReason will provide the reason for rejection.") @Valid @RequestParam(value = "statusReason", required = false) String statusReason, @ApiParam(value = "For filtering: An instant of time, ending at the TimePeriod.") @Valid @RequestParam(value = "validFor.endDateTime", required = false) OffsetDateTime validForEndDateTime, @ApiParam(value = "For filtering: An instant of time, starting at the TimePeriod") @Valid @RequestParam(value = "validFor.startDateTime", required = false) OffsetDateTime validForStartDateTime, @ApiParam(value = "For filtering: Name of the referred party (such as a partner or any other party role)") @Valid @RequestParam(value = "engagedParty.name", required = false) String engagedPartyName, @ApiParam(value = "For filtering: The name of the role type. It uniquely identifies the role type within the partnership type.") @Valid @RequestParam(value = "type.name", required = false) String typeName, @ApiParam(value = "For filtering: Reference url of the partnership type containing the role type") @Valid @RequestParam(value = "type.partnershipHref", required = false) String typePartnershipHref, @ApiParam(value = "For filtering: The identifier of the partnership type containing the role type") @Valid @RequestParam(value = "type.partnershipId", required = false) String typePartnershipId, @ApiParam(value = "For filtering: The name of the partnership type defining this role type") @Valid @RequestParam(value = "type.partnershipName", required = false) String typePartnershipName, @ApiParam(value = "For filtering: Name of the account") @Valid @RequestParam(value = "account.name", required = false) String accountName, @ApiParam(value = "For filtering: Name of the payment mean") @Valid @RequestParam(value = "paymentMethod.name", required = false) String paymentMethodName, @ApiParam(value = "For filtering: If true, indicates that is the preferred contact medium") @Valid @RequestParam(value = "contactMedium.preferred", required = false) Boolean contactMediumPreferred, @ApiParam(value = "For filtering: Type of the contact medium, such as: email address, telephone number, postal address") @Valid @RequestParam(value = "contactMedium.type", required = false) String contactMediumType, @ApiParam(value = "For filtering: Name of the characteristic") @Valid @RequestParam(value = "characteristic.name", required = false) String characteristicName, @ApiParam(value = "For filtering: Value of the characteristic") @Valid @RequestParam(value = "characteristic.value", required = false) String characteristicValue, @ApiParam(value = "For filtering: The date the profile was established") @Valid @RequestParam(value = "creditProfile.creditProfileDate", required = false) OffsetDateTime creditProfileCreditProfileDate, @ApiParam(value = "For filtering: This is an integer whose value is used to rate the risk") @Valid @RequestParam(value = "creditProfile.creditRiskRating", required = false) Integer creditProfileCreditRiskRating, @ApiParam(value = "For filtering: A measure of a person's or an organization's creditworthiness calculated on the basis of a combination of factors such as their income and credit history.") @Valid @RequestParam(value = "creditProfile.creditScore", required = false) Integer creditProfileCreditScore, @ApiParam(value = "For filtering: Name of the agreement") @Valid @RequestParam(value = "agreement.name", required = false) String agreementName, @ApiParam(value = "For filtering: Name of the related party") @Valid @RequestParam(value = "relatedParty.name", required = false) String relatedPartyName, @ApiParam(value = "For filtering: Role of the related party.") @Valid @RequestParam(value = "relatedParty.role", required = false) String relatedPartyRole) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<List<Customer>>(
                        customerService.list(),
                        HttpStatus.OK
                );

            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Customer>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<List<Customer>> retrieveCustomer(@ApiParam(value = "Identifier of the Customer", required = true) @PathVariable("id") String id) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {

                return new ResponseEntity<List<Customer>>(
                        List.of(customerService.retrieve(id)),
                        HttpStatus.OK
                );
//                return new ResponseEntity<List<Customer>>(objectMapper.readValue("[ {  \"contactMedium\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"type\" : \"type\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"city\" : \"city\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"type\" : \"type\"    }  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"type\" : \"type\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"city\" : \"city\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"type\" : \"type\"    }  } ],  \"creditProfile\" : [ {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"creditRiskRating\" : 0  }, {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"creditRiskRating\" : 0  } ],  \"agreement\" : [ {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"type\" : {    \"partnershipId\" : \"partnershipId\",    \"name\" : \"name\",    \"partnershipName\" : \"partnershipName\",    \"partnershipHref\" : \"partnershipHref\"  },  \"relatedParty\" : [ {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"characteristic\" : [ {    \"name\" : \"name\",    \"value\" : \"value\"  }, {    \"name\" : \"name\",    \"value\" : \"value\"  } ],  \"statusReason\" : \"statusReason\",  \"name\" : \"name\",  \"paymentMethod\" : [ {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"href\" : \"href\",  \"id\" : \"id\",  \"engagedParty\" : {    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"account\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"status\" : \"status\"}, {  \"contactMedium\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"type\" : \"type\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"city\" : \"city\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"type\" : \"type\"    }  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"type\" : \"type\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"city\" : \"city\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"type\" : \"type\"    }  } ],  \"creditProfile\" : [ {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"creditRiskRating\" : 0  }, {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"creditRiskRating\" : 0  } ],  \"agreement\" : [ {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"type\" : {    \"partnershipId\" : \"partnershipId\",    \"name\" : \"name\",    \"partnershipName\" : \"partnershipName\",    \"partnershipHref\" : \"partnershipHref\"  },  \"relatedParty\" : [ {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"characteristic\" : [ {    \"name\" : \"name\",    \"value\" : \"value\"  }, {    \"name\" : \"name\",    \"value\" : \"value\"  } ],  \"statusReason\" : \"statusReason\",  \"name\" : \"name\",  \"paymentMethod\" : [ {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"href\" : \"href\",  \"id\" : \"id\",  \"engagedParty\" : {    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"account\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"status\" : \"status\"} ]", List.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<List<Customer>>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<List<Customer>>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Customer> updateCustomer(@ApiParam(value = "Identifier of the Customer", required = true) @PathVariable("id") String id, @ApiParam(value = "The Customer to be updated", required = true) @Valid @RequestBody CustomerUpdate customer) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
//                return new ResponseEntity<Customer>(objectMapper.readValue("{  \"contactMedium\" : [ {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"type\" : \"type\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"city\" : \"city\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"type\" : \"type\"    }  }, {    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"type\" : \"type\",    \"preferred\" : true,    \"characteristic\" : {      \"country\" : \"country\",      \"emailAddress\" : \"emailAddress\",      \"phoneNumber\" : \"phoneNumber\",      \"stateOrProvince\" : \"stateOrProvince\",      \"city\" : \"city\",      \"faxNumber\" : \"faxNumber\",      \"postCode\" : \"postCode\",      \"street1\" : \"street1\",      \"street2\" : \"street2\",      \"type\" : \"type\"    }  } ],  \"creditProfile\" : [ {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"creditRiskRating\" : 0  }, {    \"creditProfileDate\" : \"2000-01-23T04:56:07.000+00:00\",    \"creditScore\" : 6,    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"creditRiskRating\" : 0  } ],  \"agreement\" : [ {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"validFor\" : {    \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",    \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"  },  \"type\" : {    \"partnershipId\" : \"partnershipId\",    \"name\" : \"name\",    \"partnershipName\" : \"partnershipName\",    \"partnershipHref\" : \"partnershipHref\"  },  \"relatedParty\" : [ {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"role\" : \"role\",    \"validFor\" : {      \"startDateTime\" : \"2000-01-23T04:56:07.000+00:00\",      \"endDateTime\" : \"2000-01-23T04:56:07.000+00:00\"    },    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"characteristic\" : [ {    \"name\" : \"name\",    \"value\" : \"value\"  }, {    \"name\" : \"name\",    \"value\" : \"value\"  } ],  \"statusReason\" : \"statusReason\",  \"name\" : \"name\",  \"paymentMethod\" : [ {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"href\" : \"href\",  \"id\" : \"id\",  \"engagedParty\" : {    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  },  \"account\" : [ {    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  }, {    \"name\" : \"name\",    \"description\" : \"description\",    \"href\" : \"href\",    \"id\" : \"id\"  } ],  \"status\" : \"status\"}", Customer.class), HttpStatus.NOT_IMPLEMENTED);
                customerService.update(id, customer);
                return new ResponseEntity<Customer>(customerService.retrieve(id), HttpStatus.OK);
            } catch (Exception e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Customer>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Customer>(HttpStatus.NOT_IMPLEMENTED);
    }

}
