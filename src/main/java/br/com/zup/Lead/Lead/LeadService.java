package br.com.zup.Lead.Lead;

import br.com.zup.Lead.Produto.ProdutoDTO;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


import java.util.ArrayList;
import java.util.List;

@Service
public class LeadService {
  private List<LeadDTO> leads = new ArrayList<>();


  public void cadastrarLead(LeadDTO leadDTO) {
    if (verificarEmailRepetido(leadDTO) == true) {
      compararListasDeProdutos(leadDTO);
      atualizarProdutos(leadDTO);

    } else {
      leads.add(leadDTO);

    }

  }

  public List<LeadDTO> listarLeads() {
    return leads;
  }

  public boolean verificarEmailRepetido(LeadDTO leadDTO) {
    boolean emailRepetido = false;
    for (LeadDTO referencia : leads) {
      if (referencia.getEmail().equalsIgnoreCase(leadDTO.getEmail())) {
        emailRepetido = true;
      }
    }
    return emailRepetido;

  }

  public LeadDTO buscarLead(String email) {
    for (LeadDTO referencia : leads) {
      if (referencia.getEmail().equalsIgnoreCase(email)) {
        return referencia;
      }
    }
    throw new ResponseStatusException(HttpStatus.NOT_FOUND);


  }

  public void compararListasDeProdutos(LeadDTO leadNovo) {
    LeadDTO leadAntigo = buscarLead(leadNovo.getEmail());
    for (ProdutoDTO produtosNovos : leadNovo.getProdutos()) {
      for (ProdutoDTO produtosAntigos : leadAntigo.getProdutos()) {
        if (produtosNovos.equals(produtosAntigos)) {
          throw new ResponseStatusException(HttpStatus.UNPROCESSABLE_ENTITY);
        }
      }

    }
  }

  public void atualizarProdutos(LeadDTO leadNovo) {
    LeadDTO leadAntigo = buscarLead(leadNovo.getEmail());
    for (ProdutoDTO referencia : leadNovo.getProdutos()) {
      leadAntigo.getProdutos().add(referencia);
    }


  }


}





