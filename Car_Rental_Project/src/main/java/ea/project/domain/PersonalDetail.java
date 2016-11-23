package ea.project.domain;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Future;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

@Embeddable
public class PersonalDetail {
	
	private String title; 
	
	@NotEmpty
	private
	String firstName;
	
	@NotEmpty
	private
	String middleName;
	
	@NotEmpty
	private
	String lastName;
	
    //@Past(message="{PersonalDetail.dateOfBirth}")
    @DateTimeFormat(pattern = "mm/dd/yyyy")
    @Temporal(TemporalType.DATE)
	private Date dateOfBirth;
		
	@NotEmpty
	@Email
	private String customerEmail;
	
	@Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$",
    message="{PersonalDetail.customerPhone}")
	private String customerPhone;

	//Driver license
	@NotEmpty
	private String driverLicenceNumber;
	
	private String driverLicenceUsingCountryOrState;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "mm/dd/yyyy")
	//@Future(message="{PersonalDetail.driverLicenceNumberExpirationDate}")
	private Date driverLicenceNumberExpirationDate;
	
	
	
	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPhone() {
		return customerPhone;
	}

	public void setCustomerPhone(String customerPhone) {
		this.customerPhone = customerPhone;
	}


	public String getDriverLicenceNumber() {
		return driverLicenceNumber;
	}

	public void setDriverLicenceNumber(String driverLicenceNumber) {
		this.driverLicenceNumber = driverLicenceNumber;
	}

	public String getDriverLicenceUsingCountryOrState() {
		return driverLicenceUsingCountryOrState;
	}

	public void setDriverLicenceUsingCountryOrState(String driverLicenceUsingCountryOrState) {
		this.driverLicenceUsingCountryOrState = driverLicenceUsingCountryOrState;
	}

	public Date getDriverLicenceNumberExpirationDate() {
		return driverLicenceNumberExpirationDate;
	}

	public void setDriverLicenceNumberExpirationDate(Date driverLicenceNumberExpirationDate) {
		this.driverLicenceNumberExpirationDate = driverLicenceNumberExpirationDate;
	}
}
