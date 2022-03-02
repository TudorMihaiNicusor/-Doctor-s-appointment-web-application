package raluandnic.client.controller;

import org.dom4j.rule.Mode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import raluandnic.client.model.Doctor;
import raluandnic.client.model.Pacient;
import raluandnic.client.model.User;


import javax.swing.*;
import java.util.List;

@Controller
public class RegisterController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/register", method=RequestMethod.GET)
    public ModelAndView register(){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Register");
        User user = new User();
        mv.addObject("User", user);
        User doctor_id = new User();
        mv.addObject("Doctor_id", doctor_id);
        List<Doctor> doctors = restTemplate.getForObject("http://localhost:8081/doctor/findall", List.class);
        mv.addObject("Doctors", doctors);
        return mv;
    }

    @RequestMapping(value = "/registerUser", method = RequestMethod.POST)
    public String registration(User user1, User user2) throws InterruptedException {
        if (user1.getType().equals("doctor")) {
            Doctor doctor = new Doctor(user1);
            if (restTemplate.getForObject("http://localhost:8081/user/findbyusername/" + doctor.getUsername(), User.class) != null){
                return "redirect:register";
            }
            else
                restTemplate.postForObject("http://localhost:8081/doctor/saveDoctor", doctor, Doctor.class);
        }
        else {
            Pacient pacient = new Pacient(user1);
            if (restTemplate.getForObject("http://localhost:8081/user/findbyusername/" + pacient.getUsername(), User.class) != null){
                return "redirect:register";
            }
            else {
                Doctor doctor = restTemplate.getForObject("http://localhost:8081/doctor/findbyid/" + user2.getId(), Doctor.class);
                pacient.setDoctor(doctor);
                restTemplate.postForObject("http://localhost:8081/pacient/savePacient", pacient, Pacient.class);
            }
        }
        return "redirect:login";
    }
}
