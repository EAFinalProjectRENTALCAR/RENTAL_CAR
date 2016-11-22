package ea.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    
//	@RequestMapping("/")
//    public String redirectRoot() {
//        return "redirect:/register";
//    }
	
//    @RequestMapping({"/","index"})
//    public String home(Model model){
////        List<Product> products = productService.getRecentProducts();
////        List<Category> categories = categoryService.getCategoryList();
////        model.addAttribute("products", products);
////        model.addAttribute("categories", categories);
//        return "index";
//    }

   /* @RequestMapping("/ad")
    public String adminhome(){
        return "adminhome";
    }
*/
//    @RequestMapping("/login")
//    public String login(
//            @RequestParam(value="error", required = false)
//                    String error,
//            @RequestParam(value="logout", required = false)
//                    String logout,
//            Model model){
//
//        if(error != null){
//            model.addAttribute("error", "Invalid username and password");
//        }
//
//        if (logout !=null){
//            model.addAttribute("msg", "You have been logged out successfully");
//        }
//
//        return "login";
//    }

/*    @RequestMapping("/about")
    public String about(){
        return "about";
    }*/
    
//    @RequestMapping("/")
//    public String redirectRoot() {
//        return "redirect:/login";
//    }
    
//    @RequestMapping("/home")
//    public String goLogin() {
//        return "/login";
//    }
	@RequestMapping(value={"/login"}, method = RequestMethod.GET)
	public String displayLoginForm() {
		return "login";
	}
	
    @RequestMapping("/home")
    public String goAddCustomer() {
        return "addCustomer";
    }
}


