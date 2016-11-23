package ea.project.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ea.project.domain.Confirmation;
import ea.project.domain.Customer;
import ea.project.domain.Reservation;
import ea.project.domain.Vehicle;
import ea.project.service.IConfirmationService;
import ea.project.service.IReservationService;





/**
 * @author swoven
 *@version 1.0
 *This Controller class  handles all URL with ./payment
 */

@Controller
@RequestMapping(value="/payment")
public class PaymentController 
{	
	@Autowired
	private IReservationService reservationService;
	
	@Autowired
	private IConfirmationService confirmationService;
	
	@RequestMapping(method= RequestMethod.GET)
	public String setPayment(Model model){
		return "CreditCard";
	}
	
	@RequestMapping(value="/completeReservation", method=RequestMethod.POST)
	public String confirmPayment(HttpServletRequest request){
		
		HttpSession session=request.getSession();
		
		//Getting attributes from the session to create confirmation and reservation entity
		Reservation rev=(Reservation)session.getAttribute("reservation");
		Vehicle vehicle=(Vehicle)session.getAttribute("vehicle");
		Customer customer=(Customer)session.getAttribute("customer");
		
		//Creating confirmation Object
		Confirmation confirm=new Confirmation();
		
		//creating random confirmation number
		confirm.setConfirmationNumber(confirm.createRandom());
		
		//setting the confirmation values 
		confirm.setReservation(rev);
		confirm.setCustomer(customer);
		confirm.setVehicle(vehicle);
		
		//setting confirmation object in session so that it can be used whenever needed while user is logged on
		session.setAttribute("confirmation", confirm);
		
		//creating Reservation and Confirmation entity
		reservationService.createReservation(rev);
		confirmationService.createConfirmation(confirm);
		
		return "redirect:/confirmation";
	}
	
	@RequestMapping(value="/cancelReservation")
	public String cancelPayment(HttpServletRequest request){
		
		HttpSession session=request.getSession();
		
		//If payment is cancelled reservation is removed from the session and is 
		//forwarded to home
		session.removeAttribute("reservation");
		return "home";
	}
}
