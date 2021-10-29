package br.com.zup.Lead.Lead;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/leads")
public class LeadController {
  @Autowired
  private LeadService leadService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public void cadastrarLead(@RequestBody LeadDTO leadDTO) {
    leadService.validarEmail(leadDTO);
    leadService.cadastrarLead(leadDTO);
  }

  @GetMapping
  public List<LeadDTO> listarLeads() {
    return leadService.listarLeads();
  }

  /*@PostMapping
  public void validarEmail(LeadDTO lead){
    leadService.validarEmail(lead);

  }*/

}
