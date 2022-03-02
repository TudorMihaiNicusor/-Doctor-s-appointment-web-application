package raluandnic.client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import raluandnic.client.model.Consultatie;
import raluandnic.client.model.Doctor;
import raluandnic.client.model.Pacient;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@SessionAttributes("pacient")
public class PacientController {

    private long serialVersionUID = 7173883641356636820L;

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value = "/pacient", method = RequestMethod.GET)
    public ModelAndView pacient(@ModelAttribute("pacient") Pacient pacient){
        ModelAndView mv = new ModelAndView();
        mv.setViewName("Pacient");
//        System.out.println(pacient.getId());
        Consultatie nouaConsultatie = new Consultatie();
        mv.addObject("NouaConsultatie", nouaConsultatie);
        List<Consultatie> consultatiiAnterioare = pacient.getConsultatii();
//        System.out.println(pacient.getConsultatii());
        mv.addObject("ConsultatiiAnterioare", consultatiiAnterioare);
//        Consultatie consultatieAnteriora = new Consultatie();
//        mv.addObject("ConsultatieAnteriora", consultatieAnteriora);

        return mv;
    }

    @RequestMapping(value = "/pacient/createConsultatie", method = RequestMethod.POST)
    public String createConsultatie(@ModelAttribute("pacient") Pacient pacient, Consultatie consultatie){

        Consultatie nouaConsultatie = new Consultatie();
        nouaConsultatie.setAntecedente(pacient.getAntecedente());
        nouaConsultatie.setHeredocolaterale(pacient.getHeredocolaterale());
        nouaConsultatie.setTemperatura(consultatie.getTemperatura());
        nouaConsultatie.setSimptome(consultatie.getSimptome());
        nouaConsultatie.setTensiunea(consultatie.getTensiunea());

        nouaConsultatie.setPacient(restTemplate.getForObject("http://localhost:8081/pacient/findbyid/" + pacient.getId(), Pacient.class));
        nouaConsultatie.setDoctor(restTemplate.getForObject("http://localhost:8081/doctor/findbyid/" + pacient.getDoctor().getId(), Doctor.class));

        Date data = new Date();
        SimpleDateFormat formator = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        String dataExacta = formator.format(data);
        nouaConsultatie.setData(dataExacta);

        restTemplate.postForObject("http://localhost:8081/consultatie/saveConsultatie", nouaConsultatie, Consultatie.class);
        Pacient pacient_nou = restTemplate.getForObject("http://localhost:8081/pacient/findbyid/" + pacient.getId(), Pacient.class);
        pacient.setConsultatii(pacient_nou.getConsultatii());

        return "redirect:";
    }

    @RequestMapping(value = "/pacient/updateData", method = RequestMethod.POST)
    public String updatePacient(@ModelAttribute("pacient") Pacient pacient){
        restTemplate.postForObject("http://localhost:8081/pacient/updateData", pacient, Pacient.class);
        return "redirect:";
    }


}
