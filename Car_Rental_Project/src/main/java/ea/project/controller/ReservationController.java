package ea.project.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ea.project.domain.Customer;
import ea.project.domain.Reservation;
import ea.project.domain.Vehicle;
import ea.project.service.ICustomerService;
import ea.project.service.VehicleService;

/**
 * @author swoven
 * @version 1.0
 * This Controller class  handles all URL with ./reservation
 */
@Controller
@RequestMapping(value="/reservation")
public class ReservationController 
{	
	@Autowired
	private VehicleService vehicleService;
	
	@Autowired
	private ICustomerService customerService;
	
	@RequestMapping(method= RequestMethod.GET)
	public String setReservation(@RequestParam("id") int id, Model model, HttpServletRequest request){
		
		/*If user or admin is authenticated getting the user name
		 * first and using customer service to get the customer object so 
		 * that it could be used to display receipt of transaction with customer information*/
		Authentication auth=SecurityContextHolder.getContext().getAuthentication();
		
		//getting user name
		String name=auth.getName();
		
		//getting customer from service
		Customer customer=(Customer)customerService.findCustomerByUserName(name);
		
		//creating reservation object to be used in the form
		Reservation reservation=new Reservation();
		
		//Using the vehicle service to get the vehicle from the vehicle id
		//vehicle id is received as a parameter
		Vehicle vehicle=vehicleService.findVehicleById(id);
		
		//Creating the session so that the object could be used. 
		HttpSession session=request.getSession();
		session.setAttribute("customer", customer);
		session.setAttribute("vehicle", vehicle);
		session.setAttribute("vehicleId", id);
		model.addAttribute("reservationForm", reservation);
		
		return "ReservationForm";
	}
	
	@RequestMapping(method= RequestMethod.POST) 
	public String createReservation(@Valid @ModelAttribute("reservationForm") Reservation reservation, BindingResult result,
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
		//setting the vehicle id in reservation object
		reservation.setVehicleId((Integer)session.getAttribute("vehicleId"));
		//adding flash attribute 
		redirectAttributes.addFlashAttribute("reservationAttribute", reservation);
		//adding reservation in session so that it can be accessed when we are in session
		session.setAttribute("reservation", reservation);		

		return "redirect:/payment";
	}
}
