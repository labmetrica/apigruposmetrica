package com.metrica.formacion.dao;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metrica.formacion.entity.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Object>  {
	
	@Query(value = "select * from grupos_de_comida where Huecos_Libres > 0", nativeQuery = true)
	public List<Grupo> getHuecosLibres() ;
			
	@Query(value = "select * from grupos_de_comida where nombre <= ?1", nativeQuery = true)
	public Grupo findByNombre(LocalTime horario);

	@Query(value = "select * from grupos_de_comida where id_grupo = ?1 and Huecos_Libres > 0 ", nativeQuery = true)
	public Grupo comprobarGrupoExisteNoLleno(long id);
	
	@Transactional
	@Modifying
	@Query(value = "update grupos_de_comida set Huecos_Libres = Huecos_Libres+1 where id_grupo = ?1", nativeQuery = true)
	public int mas1Hueco(long id);

	@Transactional
	@Modifying
	@Query(value = "update grupos_de_comida set Huecos_Libres = Huecos_Libres-1 where id_grupo = ?1", nativeQuery = true)
	public int menos1hueco(long id);
	
	@Transactional
	@Modifying
	@Query(value = "update grupos_de_comida set ultima_modificacion = ?1 where id_grupo = ?2", nativeQuery = true)
	public int updateUltimaModificacion(LocalDateTime ahora, long id);
}
