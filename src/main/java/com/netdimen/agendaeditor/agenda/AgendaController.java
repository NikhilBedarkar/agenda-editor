package com.netdimen.agendaeditor.agenda;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class AgendaController {

    private AgendaRepository agendaRepository;

    public AgendaController(AgendaRepository agendaRepository) {

        this.agendaRepository = agendaRepository;
    }

    @GetMapping("/")
    public String index() {

        return "index";
    }

    
    @DeleteMapping("/agendas/{agendaId}")
    public String deleteAgenda(@PathVariable("agendaId") long agendaId) {
        System.out.println("==============="+ agendaId);
        agendaRepository.deleteById(agendaId);
        return agendaId + " Deleted Successfully";
    }

    @GetMapping("/agendas/{agendaId}")
    public Agenda findById(@PathVariable("agendaId") long agendaId) {
       Agenda agenda=agendaRepository.findById(agendaId).get();
        return  agenda==null?null:agenda;
    }

    @PostMapping("/agendas")
    public Agenda save(@RequestBody Agenda theAgenda) {
        Agenda agenda=agendaRepository.save(theAgenda);
        return agenda;
    }

}
