package ar.edu.unq.desapp.grupoB022015.test;
import org.junit.Test;

import ar.edu.unq.desapp.grupoB022015.model.Defender;


public class DefenderTest {
	
	
	@Test
	public void test() {
		assert(new Defender().calculatePoints() == 3);
	}

}
