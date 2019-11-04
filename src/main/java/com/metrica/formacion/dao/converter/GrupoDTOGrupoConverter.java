package com.metrica.formacion.dao.converter;

import java.sql.Time;
import java.sql.Timestamp;

import com.metrica.formacion.entity.Grupo;
import com.metrica.formacion.entity.GrupoDTO;

public class GrupoDTOGrupoConverter implements Converter<GrupoDTO, Grupo> {

	@Override
	public Grupo apply(GrupoDTO original) {
		Grupo convertido = new Grupo();

		convertido.setId(original.getId());
		convertido.setHuecos(original.getHuecos());
		convertido.setNombre(Time.valueOf(original.getNombre()));
		convertido.setCreatedAT(Timestamp.valueOf(original.getCreatedAT()));
		convertido.setUltima_modificacion(Timestamp.valueOf(original.getUltima_modificacion()));
		return convertido;
	}

}