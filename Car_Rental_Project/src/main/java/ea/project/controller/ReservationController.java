package ea.project.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ea.project.domain.CreditCard;
import ea.project.domain.Customer;
import ea.project.domain.PersonalDetail;
import ea.project.domain.Reservation;
import ea.project.domain.Users;
import ea.project.domain.Vehicle;
import ea.project.service.VehicleService;

/**
 * @author swoven
 * @version 1.0
 */
@Controller
@RequestMapping(value="/reservation")
public class ReservationController 
{	
	@Autowired
	private VehicleService vehicleService;
	
	
	@RequestMapping(method= RequestMethod.GET)
	public String setReservation(@RequestParam("id") int id, Model model, HttpServletRequest request){
		Reservation reservation=new Reservation();
		//Below code is only for test and will be removed
		Users user=new Users();
		PersonalDetail per=new PersonalDetail();
		Customer cust=new Customer();
		per.setFirstName("Swoven");
		per.setLastName("Pokharel");
		CreditCard card=new CreditCard();
//		card.creditcardType="Visa";
		cust.setPersonalDetail(per);
//		cust.setCreditCard(card);
		user.setCustomer(cust);
		//Test Code End
		Vehicle vehicle=vehicleService.findVehicleById(id);
		HttpSession session=request.getSession();
		session.setAttribute("vehicle", vehicle);
		session.setAttribute("vehicleId", id);
		//test again
		session.setAttribute("user", user);
		model.addAttribute("reservationForm", reservation);
		return "ReservationForm";
	}
	
	@RequestMapping(method= RequestMethod.POST) 
	public String createReservation(@ModelAttribute("reservationForm") Reservation reservation, BindingResult result,
			final RedirectAttributes redirectAttributes, HttpServletRequest request){
		//Handling Error
		if(result.hasErrors()) {
			return "/ReservationForm";
		}
		HttpSession session=request.getSession();
		//Getting vehicle object from the vehicle service with the use of session id
		Vehicle vehicle=vehicleService.findVehicleById((Integer)session.getAttribute("vehicleId"));
		//setting up the reservation cost
		reservation.setCost(reservation.calculateCost(reservation.getPickUpDate(), reservation.getReturnDate(),vehicle.getPrice()));
		reservation.setVehicleId((Integer)session.getAttribute("vehicleId"));
		//adding flash attribute 
		redirectAttributes.addFlashAttribute("reservationAttribute", reservation);
		//adding reservation in session so that it can be accessed when we are in session
		session.setAttribute("reservation", reservation);		
//		System.out.println(reservation.getPickUpDate());
//		System.out.println(reservation.getReturnDate());
//		System.out.println(reservation.getCost());
		//reservationService.createReservation(reservation);
		return "redirect:/payment";
	}
}
