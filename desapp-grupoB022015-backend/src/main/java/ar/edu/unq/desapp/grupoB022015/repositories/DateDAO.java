package ar.edu.unq.desapp.grupoB022015.repositories;

import ar.edu.unq.desapp.grupoB022015.model.Date;

public class DateDAO extends HibernateGenericDAO<Date> implements GenericRepository<Date> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -393825772280498748L;

	@Override
	protected Class<Date> getDomainClass() {
		// TODO Auto-generated method stub
		return Date.class;
	}

}
