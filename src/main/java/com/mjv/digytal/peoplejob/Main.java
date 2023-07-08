package com.mjv.digytal.peoplejob;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import com.mjv.digytal.peoplejob.model.Cadastro;
import com.mjv.digytal.peoplejob.service.CadastroService;

public class Main {

	public static void main(String[] args) {

		List<Cadastro> cadastros = new ArrayList<>();
		CadastroService service = new CadastroService();

		Cadastro joelson = new Cadastro();
		joelson.setNome("joelson");
		joelson.setDataNascimento(LocalDate.parse("14/05/1989", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		Cadastro jamile = new Cadastro();
		jamile.setNome("jamile");
		jamile.setDataNascimento(LocalDate.parse("19/05/1992", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		Cadastro zelia = new Cadastro();
		zelia.setNome("zelia");
		zelia.setDataNascimento(LocalDate.parse("02/09/1957", DateTimeFormatter.ofPattern("dd/MM/yyyy")));

		cadastros.add(zelia);
		cadastros.add(jamile);
		cadastros.add(joelson);

		System.out.println(service.buscar_candidatos_entre_anos_oitenta_a_vinte_e_tres());
	}

}
