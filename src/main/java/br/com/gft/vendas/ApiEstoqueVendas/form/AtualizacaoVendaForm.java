package br.com.gft.vendas.ApiEstoqueVendas.form;

import br.com.gft.vendas.ApiEstoqueVendas.models.enums.StatusVenda;

public class AtualizacaoVendaForm {
    private StatusVenda venStatus;

    public StatusVenda getVenStatus() {
        return venStatus;
    }

    public void setStatusVenda(StatusVenda venStatus) {
        this.venStatus = venStatus;
    }
}
