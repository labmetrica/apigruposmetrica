package Entity;

import java.util.Date;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name= "Grupos de Comida")
@Data
public class Grupo {
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "IdGrupo")
	private long  id ;	
	
	@Column(name = "Nombre", nullable = false)
	private Date nombre;
	
	@Column(name = "HuecosLibres")
	private int huecos;
	
	@Column(name = "Horario")
	private Date horario;
}
