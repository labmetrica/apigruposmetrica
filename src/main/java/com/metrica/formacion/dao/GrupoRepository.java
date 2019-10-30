package com.metrica.formacion.dao;

import java.sql.Time;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.metrica.formacion.entity.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Object>  {
	
	@Query(value = "select * from grupos where Huecos_Libres > 0", nativeQuery = true)
	public List<Grupo> getHuecosLibres() ;
			
	@Query(value = "select * from grupos where nombre <= ?1", nativeQuery = true)
	public Grupo findByNombre(Time horario);

	@Query(value = "select * from grupos where id = ?1 and Huecos_Libres > 0 ", nativeQuery = true)
	public Grupo comprobarGrupoExisteNoLleno(int id);
	
	@Transactional
	@Modifying
	@Query(value = "update grupos set Huecos_Libres = Huecos_Libres+1 where id = ?1", nativeQuery = true)
	public int mas1Hueco(int id);

	@Transactional
	@Modifying
	@Query(value = "update grupos set Huecos_Libres = Huecos_Libres-1 where id = ?1", nativeQuery = true)
	public int menos1hueco(int id);
	
	@Transactional
	@Modifying
	@Query(value = "update grupos set ultima_modificacion = ?1 where id = ?2", nativeQuery = true)
	public int updateUltimaModificacion(Timestamp ahora, int id);
}
