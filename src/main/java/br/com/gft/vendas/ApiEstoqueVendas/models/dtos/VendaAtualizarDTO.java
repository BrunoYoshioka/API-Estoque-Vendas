package br.com.gft.vendas.ApiEstoqueVendas.models.dtos;

import br.com.gft.vendas.ApiEstoqueVendas.models.enums.StatusVenda;

public class VendaAtualizarDTO {
    private StatusVenda venStatus;

    public StatusVenda getVenStatus() {
        return venStatus;
    }

    public void setVenStatus(StatusVenda venStatus) {
        this.venStatus = venStatus;
    }
}
