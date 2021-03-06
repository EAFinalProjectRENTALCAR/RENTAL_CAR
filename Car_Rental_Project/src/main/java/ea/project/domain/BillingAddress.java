package ea.project.domain;

import javax.persistence.Embeddable;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.NotEmpty;

@Embeddable
public class BillingAddress {
	
	@NotEmpty
	private String streetName;

	@NotEmpty
	private String city;
	
	/*@NotEmpty
	private String state;*/
	
	@NotEmpty
	private String country;
	
	@Pattern(regexp="^[0-9]{5}(?:-[0-9]{4})?$", message="{BillingAddress.zipCode.validFormat}")
	private String zipCode;
	
    public String getStreetName() {
        return streetName;
    }

    public void setStreetName(String streetName) {
        this.streetName = streetName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

 /*   public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }*/

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    @Override
    public String toString() {
        return "BillingAddress{" +
                "streetName='" + streetName + '\'' +
                ", city='" + city + '\'' +
                + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
	
	

}
