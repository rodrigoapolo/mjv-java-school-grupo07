package com.mjv.digytal.peoplejob.controller.exceptions;

import java.io.Serializable;
import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Error implements Serializable {

	private static final long serialVersionUID = 1L;

	private String err;
	private Integer codigo;
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	private String path;

	public Error() {
		super();
	}

	public Error(String err, Integer codigo, LocalDate data, String path) {
		super();
		this.err = err;
		this.codigo = codigo;
		this.data = data;
	}

	public String getError() {
		return err;
	}

	public void setError(String error) {
		this.err = error;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public String getPath() {
		return path;
	}

	public void setPath(String path) {
		this.path = path;
	}

}
