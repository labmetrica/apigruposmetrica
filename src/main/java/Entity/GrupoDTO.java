package Entity;

import java.util.Date;

import lombok.Data;

@Data
public class GrupoDTO {
	private long  id ;	
	private Date nombre;
	private int huecos;
	private Date horario;
}
