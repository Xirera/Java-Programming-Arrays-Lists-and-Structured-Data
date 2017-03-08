

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class CaesarCipherTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CaesarCipherTest
{
    /**
     * Default constructor for test class CaesarCipherTest
     */
    
    public CaesarCipherTest()
    {
    }
    
    @Test
    public void TestCipher() {
        assertEquals("CFOPQ IBDFLK XQQXZH BXPQ CIXKH!", CaesarCipher.encrypt("FIRST LEGION ATTACK EAST FLANK!", 23));
        assertEquals("Cfopq Ibdflk", CaesarCipher.encrypt("First Legion", 23) );
        assertEquals("Wzijk Cvxzfe", CaesarCipher.encrypt("First Legion", 17));
    }
    
    @Test
    public void TestTwoKeys() {
        assertEquals("Czojq Ivdzle", CaesarCipher.encryptTwoKeys("First Legion", 23, 17));
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
}
