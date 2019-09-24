package br.com.help.services;

import br.com.help.beans.Profissional;
import javassist.tools.rmi.ObjectNotFoundException;

public interface ProfissionalService extends IService<Profissional> {
	
	Profissional find (Long id) throws ObjectNotFoundException;

}
