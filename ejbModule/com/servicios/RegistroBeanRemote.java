package com.servicios;

import javax.ejb.Remote;

import com.entities.Registro;
import com.exception.ServiciosException;

@Remote
public interface RegistroBeanRemote {
	
	Registro crear(Registro reg) throws ServiciosException;

}
