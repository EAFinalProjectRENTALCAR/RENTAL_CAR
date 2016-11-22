package ea.project.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Future;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class CreditCard {
	
	private String creditcardType;
	
//	@Pattern(regexp = "\\d{11}", message = "Incorrect credit card Format")
	@CreditCardNumber
	private String creditCardNumber;
	
	@DateTimeFormat(pattern="MM/dd/yyyy")
    @Future
   // @NotEmpty(message="The credit card expiration date must not be null")
	private
	String creditCardExpirationDate;
	
	public String getCreditcardType() {
		return creditcardType;
	}
	public void setCreditcardType(String creditcardType) {
		this.creditcardType = creditcardType;
	}
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	public String getCreditCardExpirationDate() {
		return creditCardExpirationDate;
	}
	public void setCreditCardExpirationDate(String creditCardExpirationDate) {
		this.creditCardExpirationDate = creditCardExpirationDate;
	}
}
