package com.isilSoftSpring.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Usuario {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String correo;
	private String password;
	private String activo;
	private String nombre;
	private String apePaterno;
	private String apeMaterno;
	private String direccion;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String getCorreo() {
		return correo;
	}
	
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getActivo() {
		return activo;
	}
	
	public void setActivo(String activo) {
		this.activo = activo;
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	public String getApePaterno() {
		return apePaterno;
	}
	
	public void setApePaterno(String apePaterno) {
		this.apePaterno = apePaterno;
	}
	
	public String getApeMaterno() {
		return apeMaterno;
	}
	
	public void setApeMaterno(String apeMaterno) {
		this.apeMaterno = apeMaterno;
	}
	
	public String getDireccion() {
		return direccion;
	}
	
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
