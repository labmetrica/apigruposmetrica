package com.metrica.formacion.dao.converter;

import com.metrica.formacion.entity.Grupo;
import com.metrica.formacion.entity.GrupoDTO;

public class GrupoGrupoDTOConverter implements Converter<Grupo, GrupoDTO> {

	public GrupoDTO apply(Grupo original) {
		GrupoDTO convertido = new GrupoDTO();

		convertido.setId(original.getId());
		convertido.setHuecos(original.getHuecos());
		convertido.setNombre(original.getNombre().toLocalTime());
		convertido.setCreatedAT(original.getCreatedAT().toLocalDateTime());
		convertido.setUltima_modificacion(original.getUltima_modificacion().toLocalDateTime());
		return convertido;
	}

}