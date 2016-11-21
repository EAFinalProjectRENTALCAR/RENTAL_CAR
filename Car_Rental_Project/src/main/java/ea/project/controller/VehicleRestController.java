package ea.project.controller;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ea.project.service.VehicleService;

/**
 * @author Bharat Pandey
 *
 */
@RestController
@RequestMapping(value="/vehicleRest")
public class VehicleRestController {
	
	@Autowired
	VehicleService vehicleService;
	
	@RequestMapping(value="/checkAvailability", method= RequestMethod.POST)
	public Object checkAvailability(@RequestParam Integer vehicleId, @RequestParam Date checkoutDate, @RequestParam Date returnDate  ){
		Boolean isAvailable = true;
		System.out.println("=======================REST before ..." + isAvailable);
		try{
			isAvailable = vehicleService.isAvailable(vehicleId, checkoutDate, returnDate);
			System.out.println("=======================REST between ..." + isAvailable);
		}catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("=======================REST after ..." + isAvailable);
		return isAvailable;		
	}

}
