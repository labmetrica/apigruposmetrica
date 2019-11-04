package com.metrica.formacion.dao.converter;

import com.metrica.formacion.entity.Grupo;
import com.metrica.formacion.entity.GrupoDTO;

public class GrupoDTOGrupoConverter implements Converter<GrupoDTO, Grupo> {

	@Override
	public Grupo apply(GrupoDTO original) {
		Grupo convertido = new Grupo();

		convertido.setId(original.getId());
		convertido.setHuecos(original.getHuecos());
		convertido.setNombre(original.getNombre());
		convertido.setCreatedAT(original.getCreatedAT());
		convertido.setUltima_modificacion(original.getUltima_modificacion());
		return convertido;
	}

}