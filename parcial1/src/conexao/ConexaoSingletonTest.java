package conexao;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class ConexaoSingletonTest {

	@Test
	void testGetInstance() {
		ConexaoSingleton instancia = ConexaoSingleton.getInstance();
		assertNotNull(instancia);
	}

}
