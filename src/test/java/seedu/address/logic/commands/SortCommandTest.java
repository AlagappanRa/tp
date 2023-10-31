package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.commands.CommandTestUtil.assertCommandSuccess;
import static seedu.address.logic.commands.testdata.FindCommandTestCompanies.getFindCommandTestAddressBook;

import org.junit.jupiter.api.Test;

import seedu.address.logic.SortOrder;
import seedu.address.model.Model;
import seedu.address.model.ModelManager;
import seedu.address.model.UserPrefs;

/**
 * Contains integration tests (interaction with the Model) and unit tests for SortCommand.
 */
public class SortCommandTest {
    private Model model = new ModelManager(getFindCommandTestAddressBook(), new UserPrefs());
    private Model expectedModel = new ModelManager(getFindCommandTestAddressBook(), new UserPrefs());

    @Test
    public void execute_sortAscending_success() {
        SortCommand sortCommand = new SortCommand(SortOrder.ASCENDING);
        String expectedMessage = SortCommand.MESSAGE_SUCCESS_ASCENDING;

        expectedModel.sortCompaniesByDeadline(SortOrder.ASCENDING);

        assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void execute_sortDescending_success() {
        SortCommand sortCommand = new SortCommand(SortOrder.DESCENDING);
        String expectedMessage = SortCommand.MESSAGE_SUCCESS_DESCENDING;

        expectedModel.sortCompaniesByDeadline(SortOrder.DESCENDING);

        assertCommandSuccess(sortCommand, model, expectedMessage, expectedModel);
    }

    @Test
    public void equals() {
        SortCommand sortAscendCommand = new SortCommand(SortOrder.ASCENDING);
        SortCommand sortDescendCommand = new SortCommand(SortOrder.DESCENDING);

        // same object -> returns true
        assertTrue(sortAscendCommand.equals(sortAscendCommand));

        // same values -> returns true
        SortCommand sortAscendCommandCopy = new SortCommand(SortOrder.ASCENDING);
        assertTrue(sortAscendCommand.equals(sortAscendCommandCopy));

        // different types -> returns false
        assertFalse(sortAscendCommand.equals(1));

        // null -> returns false
        assertFalse(sortAscendCommand.equals(null));

        // different order -> returns false
        assertFalse(sortAscendCommand.equals(sortDescendCommand));
    }

    @Test
    public void toStringTest() {
        SortCommand sortAscendCommand = new SortCommand(SortOrder.ASCENDING);
        assertEquals(SortCommand.COMMAND_WORD + " " + SortOrder.ASCENDING, sortAscendCommand.toString());

        SortCommand sortDescendCommand = new SortCommand(SortOrder.DESCENDING);
        assertEquals(SortCommand.COMMAND_WORD + " " + SortOrder.DESCENDING, sortDescendCommand.toString());
    }
}
