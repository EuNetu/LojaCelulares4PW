package tads.eaj.ufrn.lojacelulares4pw.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tads.eaj.ufrn.lojacelulares4pw.model.Celular;
import tads.eaj.ufrn.lojacelulares4pw.model.Cliente;


import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteRequestDTO {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String email;
    private List<Celular> celular;


    public Cliente build(){
        Cliente cliente = new Cliente();

        cliente.setNome(this.nome);
        cliente.setSobrenome(this.sobrenome);
        cliente.setCpf(this.cpf);
        cliente.setTelefone(this.telefone);
        cliente.setEmail(this.email);
        cliente.setCelular(this.celular);
        return cliente;
    }
}
