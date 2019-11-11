package br.com.gft.vendas.ApiEstoqueVendas.jms;

import br.com.gft.vendas.ApiEstoqueVendas.models.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class EnviarVendaJms {

    @Autowired
    private JmsTemplate jmsTemplate;

    public void enviarVendaJms(Venda venda) {
        jmsTemplate.convertAndSend("vendaQueue", venda);
    }
}
