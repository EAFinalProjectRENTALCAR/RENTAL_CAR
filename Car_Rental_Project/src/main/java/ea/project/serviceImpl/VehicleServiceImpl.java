package ea.project.serviceImpl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ea.project.domain.Vehicle;
import ea.project.repository.VehicleRepository;
import ea.project.service.IReservationService;
import ea.project.service.VehicleService;
/**
 * @author Bharat Pandey
 *
 */
@Service
@Transactional
public class VehicleServiceImpl implements VehicleService{
	
	@Autowired
	VehicleRepository vehicleRepository;
	
	@Autowired
	IReservationService reservationService;
	
	@Override
	public void saveVehicle(Vehicle vehicle){
		vehicleRepository.save(vehicle);
	}

	@Override
	public List<Vehicle> getAllVehicles() {
		return (List<Vehicle>) vehicleRepository.findAll();
	}

	@Override
	public Vehicle findVehicleById(Integer vehicleId) {
		Integer vId = (Integer) vehicleId;
		return vehicleRepository.findVehicleById(vId);
	}

	@Override
	public Boolean isAvailable(Integer vehicleId, Date checkoutDate, Date returnDate) {
		 return reservationService.isAvailable(vehicleId,  checkoutDate,  returnDate);
		/*if(vehicleId%2==1)
			return true;
		else
			return false;*/
	}

	@Override
	public void removeVehicle(Integer id) {
		vehicleRepository.delete(id);
		
	}

}
