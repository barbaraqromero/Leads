package br.com.zup.Lead.Lead;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LeadService {
  private List<LeadDTO> leads = new ArrayList<>();


  public void cadastrarLead (LeadDTO leadDTO){
    leads.add(leadDTO);
  }

  public List<LeadDTO> listarLeads(){
    return leads;
  }
}
