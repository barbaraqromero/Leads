package br.com.zup.Lead.Lead;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeadService {
  private List<LeadDTO> leads = new ArrayList<>();


  public void cadastrarLead(LeadDTO leadDTO) {
    leads.add(leadDTO);
  }

  public List<LeadDTO> listarLeads() {
    return leads;
  }

  public void validarEmail(LeadDTO leadDTO) {
    for (LeadDTO referencia : leads) {
      if (referencia.getEmail().equalsIgnoreCase(leadDTO.getEmail())) {
        throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY, "E-mail já cadastrado!");
      }
    }
    leads.add(leadDTO);

  }



}
