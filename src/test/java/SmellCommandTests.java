import org.improving.tag.commands.DanceCommand;
import org.improving.tag.commands.SmellCommand;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class SmellCommandTests {
    SmellCommand target;
    TestInputOutput io;

    @BeforeEach
    public void arrange() {
        //Arrange
        io = new TestInputOutput();
        target = new SmellCommand(io);
    }

    @Test
    public void execute_should_return_phrase() {
        //act
        target.execute(null);

        //assert
        assertEquals("I'd rather not..", io.lastText);
    }

    @Test
    public void isValid_should_be_true_when_input_is_smell() {
        //Act
        var result = target.isValid("smell");

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_smell_with_spaces() {
        //Act
        var result = target.isValid("    smell     ");

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_true_when_input_is_smell_with_caps() {
        //Act
        var result = target.isValid("sMeLL");

        //Assert
        assertTrue(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_foobar() {
        //Act
        var result = target.isValid("foobar");

        //Assert
        assertFalse(result);
    }

    @Test
    public void isValid_should_be_false_when_input_is_null() {
        //Act
        var result = target.isValid(null);

        //Assert
        assertFalse(result);
    }

}
