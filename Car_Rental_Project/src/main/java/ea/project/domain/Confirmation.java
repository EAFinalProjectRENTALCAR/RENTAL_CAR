package ea.project.domain;

import java.beans.Transient;
import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;


/**
 * @author swoven
 * @version 1.0
 *Confirmation POJO
 */

@Entity
public class Confirmation implements Serializable 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = -8276340068505700851L;
	
	@Id @GeneratedValue
	private int id;
	@Column(name="ConfirmationNumber")
	private long confirmationNumber;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Customer_Id")
	private Users user;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Vehicle_Id")
	private Vehicle vehicle;
	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="Reservation_Id")
	private Reservation reservation;
	
	public Confirmation(){
		//default
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(long confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

	public Users getUsers() {
		return user;
	}

	public void setUsers(Users users) {
		this.user = users;
	}

	public Vehicle getVehicle() {
		return vehicle;
	}

	public void setVehicle(Vehicle vehicle) {
		this.vehicle = vehicle;
	}

	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	
	@Transient
	//Generating random number between 99 and 9999 for confirmation Number
	public long createRandom(){
		long rand= (long)Math.floor(Math.random()*9999)+99;
		return rand;
	}
}