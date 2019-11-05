package com.metrica.formacion.converter;

import com.metrica.formacion.entity.grupos;
import com.metrica.formacion.entity.gruposDTO;

public class gruposGruposDTOConverter implements Converter<grupos, gruposDTO> {

	public gruposDTO apply(grupos original) {
		gruposDTO convertido = new gruposDTO();

		convertido.setId(original.getId());
		convertido.setHuecos(original.getHuecos());
		convertido.setNombre(original.getNombre());
		convertido.setCreatedAT(original.getCreatedAT());
		convertido.setUltima_modificacion(original.getUltimaModificacion());
		return convertido;
	}

}