package ea.project.domain;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

import org.hibernate.validator.constraints.NotEmpty;

@Entity
//@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Customer implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7229488317098431281L;

	@Id
	@GeneratedValue
	private int customerId;

	@Embedded
	private PersonalDetail personalDetail;
	
	@Embedded
	private BillingAddress billingAddress;
	
	@Embedded
	private CreditCard creditCard;
	
	@Column(unique = true)
	@NotEmpty(message = "The customer username must not be null")
	private String username;

	@NotEmpty(message = "The customer password must not be null")
//	@Length(min = 6, message = "Password should be more than 5 characters")
	private String password;
	
	public enum Role {
		ROLE_USER, ROLE_ADMIN
	};
	
	public Customer() {
		// TODO Auto-generated constructor stub
		super();
	}

	public Customer(PersonalDetail personalDetail, BillingAddress billingAddress, CreditCard creditCard) {
		// TODO Auto-generated constructor stub
		this.personalDetail = personalDetail;
		this.billingAddress = billingAddress;
		this.creditCard = creditCard;
	}
	
	@Enumerated(EnumType.STRING)
	private Role authority;

	@Column(nullable = true)
	boolean enabled;

	public Role getAuthority() {
		return authority;
	}

	public void setAuthority(Role authority) {
		this.authority = authority;
	}

	public boolean getEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}
	
	
	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public BillingAddress getBillingAddress() {
		return billingAddress;
	}

	public void setBillingAddress(BillingAddress billingAddress) {
		this.billingAddress = billingAddress;
	}

	public PersonalDetail getPersonalDetail() {
		return personalDetail;
	}

	public void setPersonalDetail(PersonalDetail personalDetail) {
		this.personalDetail = personalDetail;
	}


	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


}
