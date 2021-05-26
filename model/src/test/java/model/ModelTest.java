

package model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ModelTest {
	/** The model for the tests */
	/**
	 * The Actions class.
	 * @author Maiva
	 * @author Chabain
	 *  @author Vladimir
	 *
	 */
    private Model model;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
    }

    /**
     * Instantiates a new model.
     * @throws Exception in case of an exception
     */
    @Before
    public void setUp() throws Exception {
        this.model = new Model();
    }

    @After
    public void tearDown() throws Exception {
    }

    @Test
    public void testContentOfMap() {
      Assert.assertEquals("", this.model.getGame().getContentOfGame());
    }

    
    /**
     * Test the limit of level loading. If there is an exception, assertEquals will return true
     */
    @Test
    public void testLimitLoadingMap() {

        try {
        	this.model.loadGame(8);
            fail("Failed");
        } catch (IndexOutOfBoundsException e) {
            assertEquals(e.getMessage(), "Incorrect id !"); 
        }
    }
    
    
    
    /**
     * Verify the correct content of the map is picked from the database depending on the level.
     */
    @Test
    public void testGetContentOfGame() {
        this.model.loadGame(1);
        assertEquals("wwwwwwwwwwwwwwwwwwwwwwwww\r\n"
        		+ "wdsddsddwdsdddDdwdddpdsdw\r\n"
        		+ "wdddddddwddddddpwppdpdddw\r\n"
        		+ "wadddddddddddddsddsdddddw\r\n"
        		+ "wDddddddwdsddddswdsdpddpw\r\n"
        		+ "wdddddddwdsddddswdsdppddw\r\n"
        		+ "wwwwwwwwwwwwwwwwwwwwpwwww\r\n"
        		+ "wddddssdwddpddddwdddpddsw\r\n"
        		+ "wdddddddwddpddddwdddpdddw\r\n"
        		+ "wWpppppppppsppppppppppppw\r\n"
        		+ "wsddsdddwddddsddwddssdddw\r\n"
        		+ "wsddddsdwddsddsdwdddsdssw\r\n"
        		+ "wdsddDddwdddsddDwdddddddw\r\n"
        		+ "wwwwwwwwwwwwwwwwwwwwwwwww", this.model.getGame().getContentOfGame());
        this.model.loadGame(2);
        assertEquals("wwwwwwwwwwwwwwwwwwwwwwwww\r\n"
        		+ "wddddssdwddpddddwdddpddsw\r\n"
        		+ "wdddddddwddpddddwdddpdddw\r\n"
        		+ "wapppppppppsppppppppppppw\r\n"
        		+ "wsddsdddwddddsddwddssdddw\r\n"
        		+ "wsddddsdwddsddsdwdddsdssw\r\n"
        		+ "wdsddDddwdddsDddwdddddddw\r\n"
        		+ "wwwwwwwwwwwwwwwwwwppwwwww\r\n"
        		+ "wsWpepddwddddsdswdddpdddw\r\n"
        		+ "wdddddpdwpddddddwddDpdddw\r\n"
        		+ "wppppppppsppppppppppppDpw\r\n"
        		+ "wdDdddspwddpddddwddDpsddw\r\n"
        		+ "wdsdWddswddsddsdwddddddDw\r\n"
        		+ "wwwwwwwwwwwwwwwwwwwwwwwww", this.model.getGame().getContentOfGame());
        this.model.loadGame(3);
        assertEquals("wwwwwwwwwwwwwwwwwwwwwwwww\r\n"
        		+ "wdddddsddddddwwddddsDdddw\r\n"
        		+ "wddwdwdwddwddwdwddwddwwdw\r\n"
        		+ "wawdswwwdddddswddddddwwww\r\n"
        		+ "wdwdDwdwdwwwdwdwdwwwdwwdw\r\n"
        		+ "wddwdwdwDwdwDwwddsdwdwwdw\r\n"
        		+ "wdddddddddddddddddddDdddw\r\n"
        		+ "wwwwppwwwwwwwwwwwwwppwwww\r\n"
        		+ "wdddddddwdddssdwddddpppdw\r\n"
        		+ "wddddpppwdDsdddwdddspepsw\r\n"
        		+ "wddsdpeppddddddwddDdpppdw\r\n"
        		+ "wDsddpppwddsddDwddddddddw\r\n"
        		+ "wdddddddwddddWdwddddddddw\r\n"
        		+ "wwwwwwwwwwwwwwwwwwwwwwwww", this.model.getGame().getContentOfGame());
        this.model.loadGame(4);
        assertEquals("wwwwwwwwwwwwwwwwwwwwwwwww\r\n"
        		+ "wdddddsddddwdsddddddddddw\r\n"
        		+ "wdddddddwdddddddddwddsddw\r\n"
        		+ "wdswdwdddddwdwDwdddddsDdw\r\n"
        		+ "waswwwdwwwdwdwdwdwwwdsddw\r\n"
        		+ "wddwDwdwdwdwddwddwdwdddsw\r\n"
        		+ "wddppdddddpepdsdsdddddddw\r\n"
        		+ "wwwppwwwwwwwwDwpwwddwwwww\r\n"
        		+ "wdddsdwdDdddwpwpwdwdddddw\r\n"
        		+ "wdspppwddsdswwwwwddwdsddw\r\n"
        		+ "wdspepwdddwddddddDddsdddw\r\n"
        		+ "wdDpppwdddwdpepddddsdpddw\r\n"
        		+ "wsdddDwdWdwdddddddsddwddw\r\n"
        		+ "wwwwwwwwwwwwwwwwwwwwwwwww", this.model.getGame().getContentOfGame());
        this.model.loadGame(5);
        assertEquals("wwwwwwwwwwwwwwwwwwwwwwwww\r\n"
        		+ "wdddddwddwddddddsdddddddw\r\n"
        		+ "wddwdwwdddddwwdwdwDwdwwww\r\n"
        		+ "wadwdwwdwdwdwdwwdwwwdwwwd\r\n"
        		+ "wdddwdwwwdwdwwdwdwdwdwwpw\r\n"
        		+ "wddddsddddddddddddddddddw\r\n"
        		+ "wdwwddddwwwwwwwwwwwwwssdw\r\n"
        		+ "wddDwddwddddddddddddwdddw\r\n"
        		+ "wwwwddwddwwwwwwpeppwddwdw\r\n"
        		+ "wdsddwDdwWddddddddwddwddw\r\n"
        		+ "wdddwdddwwwwwwwwwwddwwdsw\r\n"
        		+ "wDdwddswddssssdddddwDwpdw\r\n"
        		+ "wdwdddddddddddddddwdddpdw\r\n"
        		+ "wwwwwwwwwwwwwwwwwwwwwwwww", this.model.getGame().getContentOfGame());
    }
}
