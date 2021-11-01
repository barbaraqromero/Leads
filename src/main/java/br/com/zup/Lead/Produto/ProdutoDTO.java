package br.com.zup.Lead.Produto;

import java.util.Objects;

public class ProdutoDTO {
  private String nomeDoProduto;
  private double valor;

  public ProdutoDTO() {
  }

  public ProdutoDTO(String nomeDoProduto, double valor) {
    this.nomeDoProduto = nomeDoProduto;
    this.valor = valor;
  }

  public String getNomeDoProduto() {
    return nomeDoProduto;
  }

  public void setNomeDoProduto(String nomeDoProduto) {
    this.nomeDoProduto = nomeDoProduto;
  }

  public double getValor() {
    return valor;
  }

  public void setValor(double valor) {
    this.valor = valor;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ProdutoDTO that = (ProdutoDTO) o;
    return Double.compare(that.valor, valor) == 0 && Objects.equals(nomeDoProduto, that.nomeDoProduto);
  }




}
