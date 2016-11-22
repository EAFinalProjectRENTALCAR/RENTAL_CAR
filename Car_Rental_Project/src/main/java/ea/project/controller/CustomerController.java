package ea.project.controller;



import java.util.Collection;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import ea.project.domain.Customer;
import ea.project.service.ICustomerService;

@Controller
public class CustomerController {
	
	@Autowired
	ICustomerService customerService;
	
//	@RequestMapping("/")
//    public String redirectRoot() {
//        return "redirect:/addCustomer";
//    }
	
	@RequestMapping(value={"","/showCustomer"}, method = RequestMethod.GET)
	public String showCustomers(Model model){
		Collection<Customer> customers = customerService.getCustomers();
		model.addAttribute("customers", customers);
		return "clientList";
	}
	
//	@RequestMapping("/customerDetail")
//	public String getCustomerByUserName(Model model, @RequestParam("userName") String userName) {
//		System.out.println("=========== Customer Details");
//		Customer customer = customerService.findCustomerByUserName(userName);
//		System.out.println("=============" + customer.getCustomerId());
//		model.addAttribute("customer", customer);
//		return "customerDetails";
//	}
	
//	@RequestMapping("/login")
//	public String getCustomerByUserNameAndPassword(BindingResult bindingResult, @RequestParam("userName") String userName, @RequestParam("password") String password) {
//		if(bindingResult.hasErrors()){
//			return "customer/login";
//		}
//		Customer customer = customerService.findCustomerByUserNameAndPassword(userName, password);
//		if(null != customer)
//			return "home";
//		return "login";
//	}
	
	@RequestMapping(value="/addCustomer", method = RequestMethod.GET)
	public String addCustomer(@ModelAttribute("newCustomer") Customer customer, Model model){
		return "addCustomer";
	}
	
	@RequestMapping(value="/addCustomer", method = RequestMethod.POST)
	public String saveCustomer(@ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult, RedirectAttributes redirectAttributes, HttpServletRequest request){
		if(bindingResult.hasErrors()){
			return "customer/addCustomer";
		}
		customerService.addCustomer(customer);
		redirectAttributes.addFlashAttribute(customer);
		return "redirect:/login";
	}
}
