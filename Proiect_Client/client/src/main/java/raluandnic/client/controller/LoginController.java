package raluandnic.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import raluandnic.client.model.Doctor;
import raluandnic.client.model.Pacient;
import raluandnic.client.model.User;

@Controller
public class LoginController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/login")
    public ModelAndView login(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Login");
        mv.addObject("User", new User());
        return mv;
    }

    @PostMapping(value = "/loginUser")
    public String loginUser(User user, RedirectAttributes redirectAttributes) {
        User new_user = restTemplate.getForObject("http://localhost:8081/user/findbyusername/" + user.getUsername(), user.getClass(), User.class);
        if (new_user != null) {
            if (user.getPassword().equals(new_user.getPassword())) {

                if (new_user.getType().equals("pacient")) {
                    Pacient pacient = restTemplate.getForObject("http://localhost:8081/pacient/findbyid/" + new_user.getId(), Pacient.class);
                    redirectAttributes.addFlashAttribute(pacient);
                    return "redirect:pacient";
                } else {
                    Doctor doctor = restTemplate.getForObject("http://localhost:8081/doctor/findbyid/" + new_user.getId(), Doctor.class);
                    redirectAttributes.addFlashAttribute(doctor);
                    return "redirect:doctor";
                }
            } else
                return "redirect:login";
        }
        return "redirect:login";
    }
}
