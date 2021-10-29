package br.com.zup.Lead.Lead;

import br.com.zup.Lead.Produto.ProdutoDTO;

import java.util.ArrayList;
import java.util.List;

public class LeadDTO {
  private String email;
  private String nome;
  private String telefone;
  private List<ProdutoDTO> produtos = new ArrayList<>();

  public LeadDTO() {
  }

  public LeadDTO(String email, String nome, String telefone, List<ProdutoDTO> produtos) {
    this.email = email;
    this.nome = nome;
    this.telefone = telefone;
    this.produtos = produtos;
  }


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public String getTelefone() {
    return telefone;
  }

  public void setTelefone(String telefone) {
    this.telefone = telefone;
  }

  public List<ProdutoDTO> getProdutos() {
    return produtos;
  }

  public void setProdutos(List<ProdutoDTO> produtos) {
    this.produtos = produtos;
  }
}




