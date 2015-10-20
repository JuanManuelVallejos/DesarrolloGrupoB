package ar.edu.unq.desapp.grupoB022015.repositories;

import ar.edu.unq.desapp.grupoB022015.model.Position;

public class PositionDAO extends HibernateGenericDAO<Position>  implements GenericRepository<Position> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7974698388410943468L;

	@Override
	protected Class<Position> getDomainClass() {
		return Position.class;
	}

}
