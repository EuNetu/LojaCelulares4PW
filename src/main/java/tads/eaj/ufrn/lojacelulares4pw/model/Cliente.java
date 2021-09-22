package tads.eaj.ufrn.lojacelulares4pw.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "clientes")
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_cliente")
    private Long id;
    private String name;
    private String sobrenome;
    private String cpf;
    private String telefone;
    private String email;
    private Date deleted;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_celular")
    private List<Celular> celular;
}
