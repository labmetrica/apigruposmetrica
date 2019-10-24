package dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import Entity.Grupo;

public interface GrupoRepository extends JpaRepository<Grupo, Object>  {
	
	@Query("select * from Grupo where HuecosLibres < 12")
	public List<Grupo> getHuecosLibres() ;
	
	@Query("select * from Grupo where id = ?1")
	public Grupo getById(long id) ;
	
	public Grupo findByNombre(String nombre);
	
	@Query("select * from Grupo where horario < ?1")
	public Grupo findByHorario(Date horario);

	@Query("select id from Grupo where id = ? and HuecosLibres < 12 ")
	public Grupo comprobarGrupoExisteNoLleno(long id);
	
	@Query("update Grupo set HuecosLibres = HuecosLibres-1 where id = ?1")
	public Grupo menos1Hueco(long id);


}
