package tads.eaj.ufrn.lojacelulares4pw.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tads.eaj.ufrn.lojacelulares4pw.model.Celular;
import tads.eaj.ufrn.lojacelulares4pw.model.Cliente;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ClienteResponseDTO {
    private String nome;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String email;
    private List<CelularResponseDTO> celular;

    public ClienteResponseDTO(Cliente cliente){
        this.nome = cliente.getNome();
        this.sobrenome = cliente.getSobrenome();
        this.cpf = cliente.getCpf();
        this.telefone = cliente.getTelefone();
        this.email = cliente.getEmail();

        ArrayList<CelularResponseDTO> listaCelulares = new ArrayList<>();
        for (Celular celular: cliente.getCelular())
            listaCelulares.add(new CelularResponseDTO(celular));
        this.celular = listaCelulares;

    }
}
