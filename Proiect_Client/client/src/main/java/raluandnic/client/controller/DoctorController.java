package raluandnic.client.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import raluandnic.client.model.Consultatie;
import raluandnic.client.model.Doctor;
import raluandnic.client.model.Pacient;

import java.util.List;

@Controller
@SessionAttributes("doctor")
public class DoctorController {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/doctor", method = RequestMethod.GET)
    public ModelAndView doctor(@ModelAttribute("doctor") Doctor doctor){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Doctor");

        Consultatie consultatiaActuala = new Consultatie();
        mv.addObject("ConsultatiaActuala", consultatiaActuala);
        List<Consultatie> consultatiiActuale = doctor.getConsultatii();

        mv.addObject("ConsultatiiActuale", consultatiiActuale);

        return mv;
    }

    @RequestMapping(value = "/doctor/finalizareConsultatie", method = RequestMethod.POST)
    public String finalizareConsultatie(@ModelAttribute("doctor") Doctor doctor, Consultatie consultatie){
        System.out.println(doctor.getId());
        Consultatie nouaConsultatie = restTemplate.getForObject("http://localhost:8081/consultatie/findbyid/" + consultatie.getDoctor().getId(), Consultatie.class);
        if (nouaConsultatie != null) {
            nouaConsultatie.setDiagnostic(consultatie.getDiagnostic());
            nouaConsultatie.setReteta(consultatie.getReteta());

            restTemplate.postForObject("http://localhost:8081/consultatie/updateData", nouaConsultatie, Consultatie.class);

            Consultatie noulConsultatie = restTemplate.getForObject("http://localhost:8081/consultatie/findbyid/" + consultatie.getDoctor().getId(), Consultatie.class);

            Doctor doctor_nou = restTemplate.getForObject("http://localhost:8081/doctor/findbyid/" + doctor.getId(), Doctor.class);
            doctor.setConsultatii(doctor_nou.getConsultatii());
        }
        return "redirect:";
    }
}
