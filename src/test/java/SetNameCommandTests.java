import org.improving.tag.Game;
import org.improving.tag.Player;
import org.improving.tag.SpringContext;
import org.improving.tag.commands.SetNameCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.mockito.Mockito.*;

public class SetNameCommandTests {
    SetNameCommand target;
    TestInputOutput io;
    Game game;

    @BeforeEach
    public void arrange() {
        //Arrange
        io = new TestInputOutput();
        target = new SetNameCommand(io);
        game = mock(Game.class);

    }

    @Test
    public void isValid_should_be_true_when_input_is_set_name_and_name() {
        Player player = new Player(null);
        player.setName("hi");
        player.setHitPoints(50);
        when(game.getPlayer()).thenReturn(player);

        //Act
        target.execute("@set name=jennifer", game);
        //Arrange
        assertEquals("jennifer", game.getPlayer().getName());
    }

    @Test
    public void isValid_should_be_true_when_input_is_set_name_with_caps() {
        //Act
        var result = target.isValid("@sEt NAme=JEnnIFer", game);
        //Arrange
       assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_foobar() {
        //Act
        var result = target.isValid("foobar", null);

        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_null() {
        //Act
        var result = target.isValid(null, null);

        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_only_first_array() {
        //Act
        var result = target.isValid("@set name", null);

        //Assert
        assertFalse(result);
    }

}
