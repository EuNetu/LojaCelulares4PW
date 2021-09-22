package tads.eaj.ufrn.lojacelulares4pw.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import tads.eaj.ufrn.lojacelulares4pw.model.Celular;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CelularResponseDTO {
    private String modelo;
    private String marca;
    private String preco;

    public CelularResponseDTO(Celular celular){

        this.modelo = celular.getModelo();
        this.marca = celular.getMarca();
        this.preco = celular.getPreco();
    }

}

