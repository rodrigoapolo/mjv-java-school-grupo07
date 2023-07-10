package com.mjv.digytal.peoplejob.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mjv.digytal.peoplejob.dto.view.CadastroView;
import com.mjv.digytal.peoplejob.dto.view.CadastroViewPretensao;
import com.mjv.digytal.peoplejob.dto.view.CadastroViewProfissao;
import com.mjv.digytal.peoplejob.model.Cadastro;


@Repository
public interface CadastroRepository extends JpaRepository<Cadastro, Integer> {

    Cadastro getByCpf(String cpf);
    
	@Query("SELECT c FROM Cadastro c WHERE c.experiencia.empregoAtual = :empregoAtual")
	List<CadastroView> findNotWorkingCandidates(@Param("empregoAtual") boolean empregoAtual);
    
	@Query("SELECT c FROM Cadastro c JOIN c.profissao p WHERE p.nome <> :nome")
	List<CadastroViewProfissao> findNotProfissao(@Param("nome") String nome);
	
	@Query("SELECT c FROM Cadastro c WHERE c.pretencaoSalarial.pretencaoMinima >= :salarioMinimoMenor AND c.pretencaoSalarial.pretencaoMinima < :salarioMinimoMaior")
	List<CadastroViewPretensao> findIntervaloSalarioMinimo(@Param("salarioMinimoMenor") Double salarioMinimoMenor, @Param("salarioMinimoMaior") Double salarioMinimoMaior);

}
