package com.metrica.formacion.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metrica.formacion.entity.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Object>  {
	
	// ITS ALIIIIVE
	@Query(value = "select * from grupos_de_comida where Huecos_Libres > 0", nativeQuery = true)
	public List<Grupo> getHuecosLibres() ;
			
	@Query(value = "select * from grupos_de_comida where nombre < ?1", nativeQuery = true)
	public Date findByNombre(Date horario);

	// ITS ALIIIIVE
	@Query(value = "select id from grupos_de_comida where id_grupo = ?1 and Huecos_Libres > 0 ", nativeQuery = true)
	public Grupo comprobarGrupoExisteNoLleno(long id);
	
	@Modifying
	@Query(value = "update grupos_de_comida set Huecos_Libres = Huecos_Libres-1 where id_grupo = ?1", nativeQuery = true)
	public int mas1Hueco(long id);

	@Modifying
	@Query(value = "update grupos_de_comida set Huecos_Libres = Huecos_Libres+1 where id_grupo = ?1", nativeQuery = true)
	public int	 menos1hueco(long id);
}
