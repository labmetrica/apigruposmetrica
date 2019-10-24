package com.metrica.formacion.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.metrica.formacion.entity.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Object>  {
	
	@Query(value = "select * from Grupo where Huecos_Libres < 12", nativeQuery = true)
	public List<Grupo> getHuecosLibres() ;
	
	@Query(value = "select * from Grupo where id = ?1", nativeQuery = true)
	public Grupo getById(long id) ;
	
	public Grupo findByNombre(String nombre);
	
	@Query(value = "select * from Grupo where horario < ?1", nativeQuery = true)
	public Grupo findByHorario(Date horario);

	@Query(value = "select id from Grupo where id = ?1 and Huecos_Libres < 12 ", nativeQuery = true)
	public Grupo comprobarGrupoExisteNoLleno(long id);
	
	@Query(value = "update Grupo set Huecos_Libres = Huecos_Libres-1 where id = ?1", nativeQuery = true)
	public Grupo menos1Hueco(long id);


}
