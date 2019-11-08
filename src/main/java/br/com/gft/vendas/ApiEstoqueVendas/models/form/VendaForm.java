package br.com.gft.vendas.ApiEstoqueVendas.models.form;

import br.com.gft.vendas.ApiEstoqueVendas.models.enums.StatusVenda;

public class VendaForm {
    private StatusVenda venStatus;

    public StatusVenda getVenStatus() {
        return venStatus;
    }

    public void setVenStatus(StatusVenda venStatus) {
        this.venStatus = venStatus;
    }
}
