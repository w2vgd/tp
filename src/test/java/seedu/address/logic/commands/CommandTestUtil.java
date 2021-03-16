package seedu.address.logic.commands;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static seedu.address.logic.parser.CliSyntax.PREFIX_ADDRESS;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DATE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_DEADLINE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_EMAIL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_NAME;
import static seedu.address.logic.parser.CliSyntax.PREFIX_PHONE;
import static seedu.address.logic.parser.CliSyntax.PREFIX_POSTAL;
import static seedu.address.logic.parser.CliSyntax.PREFIX_REMARK;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TAG;
import static seedu.address.logic.parser.CliSyntax.PREFIX_TYPE;
import static seedu.address.testutil.Assert.assertThrows;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import seedu.address.commons.core.index.Index;
import seedu.address.logic.commands.exceptions.CommandException;
import seedu.address.model.AddressBook;
import seedu.address.model.Model;
import seedu.address.model.person.NameContainsKeywordsPredicate;
import seedu.address.model.person.Person;
import seedu.address.testutil.EditPersonDescriptorBuilder;
import seedu.address.testutil.SortAppointmentDescriptorBuilder;

/**
 * Contains helper methods for testing commands.
 */
public class CommandTestUtil {

    // For testing properties
    public static final String VALID_NAME_MAYFAIR = "Mayfair";
    public static final String VALID_NAME_BURGHLEY_DRIVE = "Burghley Drive";
    public static final String VALID_TYPE_MAYFAIR = "Condo";
    public static final String VALID_TYPE_BURGHLEY_DRIVE = "Landed";
    public static final String VALID_ADDRESS_MAYFAIR = "1 Jurong East Street 32, #08-111";
    public static final String VALID_ADDRESS_BURGHLEY_DRIVE = "12 Burghley Drive";
    public static final String VALID_POSTAL_MAYFAIR = "609477";
    public static final String VALID_POSTAL_BURGHLEY_DRIVE = "123456";
    public static final String VALID_DEADLINE_MAYFAIR = "31-12-2021";
    public static final String VALID_DEADLINE_BURGHLEY_DRIVE = "31-07-2021";

    public static final String NAME_DESC_MAYFAIR = " " + PREFIX_NAME + VALID_NAME_MAYFAIR;
    public static final String NAME_DESC_BURGHLEY_DRIVE = " " + PREFIX_NAME + VALID_NAME_BURGHLEY_DRIVE;
    public static final String TYPE_DESC_MAYFAIR = " " + PREFIX_TYPE + VALID_TYPE_MAYFAIR;
    public static final String TYPE_DESC_BURGHLEY_DRIVE = " " + PREFIX_TYPE + VALID_TYPE_BURGHLEY_DRIVE;
    public static final String ADDRESS_DESC_MAYFAIR = " " + PREFIX_ADDRESS + VALID_ADDRESS_MAYFAIR;
    public static final String ADDRESS_DESC_BURGHLEY_DRIVE = " " + PREFIX_ADDRESS + VALID_ADDRESS_BURGHLEY_DRIVE;
    public static final String POSTAL_DESC_MAYFAIR = " " + PREFIX_POSTAL + VALID_POSTAL_MAYFAIR;
    public static final String POSTAL_DESC_BURGHLEY_DRIVE = " " + PREFIX_POSTAL + VALID_POSTAL_BURGHLEY_DRIVE;
    public static final String DEADLINE_DESC_MAYFAIR = " " + PREFIX_DEADLINE + VALID_DEADLINE_MAYFAIR;
    public static final String DEADLINE_DESC_BURGHLEY_DRIVE = " " + PREFIX_DEADLINE + VALID_DEADLINE_BURGHLEY_DRIVE;

    public static final String INVALID_PROPERTY_NAME_DESC =
            " " + PREFIX_NAME + "Mayfair&"; // '&' not allowed in names
    public static final String INVALID_PROPERTY_TYPE_DESC =
            " " + PREFIX_TYPE + "apartment"; // 'apartment' is not a valid type
    public static final String INVALID_PROPERTY_ADDRESS_DESC =
            " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_PROPERTY_POSTAL_DESC =
            " " + PREFIX_POSTAL + "12a"; // 'a' not allowed in postal codes
    public static final String INVALID_PROPERTY_DEADLINE_DESC =
            " " + PREFIX_DEADLINE + "31-04-2021"; // 31st April not valid

    // For testing appointments
    public static final String VALID_NAME_MEET_ALEX = "Meet Alex";
    public static final String VALID_NAME_MEET_BOB = "Meet Bob";
    public static final String VALID_REMARK_MEET_ALEX = "At M Hotel";
    public static final String VALID_REMARK_MEET_BOB = "At Plaza Sing Starbucks";
    public static final String VALID_DATE_MEET_ALEX = "25-12-2021";
    public static final String VALID_DATE_MEET_BOB = "25-02-2021";

    public static final String NAME_DESC_MEET_ALEX = " " + PREFIX_NAME + VALID_NAME_MEET_ALEX;
    public static final String NAME_DESC_MEET_BOB = " " + PREFIX_NAME + VALID_NAME_MEET_BOB;
    public static final String REMARK_DESC_MEET_ALEX = " " + PREFIX_REMARK + VALID_REMARK_MEET_ALEX;
    public static final String REMARK_DESC_MEET_BOB = " " + PREFIX_REMARK + VALID_REMARK_MEET_BOB;
    public static final String DATE_DESC_MEET_ALEX = " " + PREFIX_DATE + VALID_DATE_MEET_ALEX;
    public static final String DATE_DESC_MEET_BOB = " " + PREFIX_DATE + VALID_DATE_MEET_BOB;

    public static final String INVALID_APPOINTMENT_NAME_DESC =
            " " + PREFIX_NAME + "Meet Alex&"; // '&' not allowed in names
    public static final String INVALID_APPOINTMENT_REMARK_DESC =
            " " + PREFIX_REMARK; // empty string not allowed for remark
    public static final String INVALID_APPOINTMENT_DATE_DESC =
            " " + PREFIX_DATE + "31-04-2021"; // 31st April not valid

    // For testing of persons (to be removed)
    public static final String VALID_NAME_AMY = "Amy Bee";
    public static final String VALID_NAME_BOB = "Bob Choo";
    public static final String VALID_PHONE_AMY = "11111111";
    public static final String VALID_PHONE_BOB = "22222222";
    public static final String VALID_EMAIL_AMY = "amy@example.com";
    public static final String VALID_EMAIL_BOB = "bob@example.com";
    public static final String VALID_ADDRESS_AMY = "Block 312, Amy Street 1";
    public static final String VALID_ADDRESS_BOB = "Block 123, Bobby Street 3";
    public static final String VALID_TAG_HUSBAND = "husband";
    public static final String VALID_TAG_FRIEND = "friend";

    public static final String NAME_DESC_AMY = " " + PREFIX_NAME + VALID_NAME_AMY;
    public static final String NAME_DESC_BOB = " " + PREFIX_NAME + VALID_NAME_BOB;
    public static final String PHONE_DESC_AMY = " " + PREFIX_PHONE + VALID_PHONE_AMY;
    public static final String PHONE_DESC_BOB = " " + PREFIX_PHONE + VALID_PHONE_BOB;
    public static final String EMAIL_DESC_AMY = " " + PREFIX_EMAIL + VALID_EMAIL_AMY;
    public static final String EMAIL_DESC_BOB = " " + PREFIX_EMAIL + VALID_EMAIL_BOB;
    public static final String ADDRESS_DESC_AMY = " " + PREFIX_ADDRESS + VALID_ADDRESS_AMY;
    public static final String ADDRESS_DESC_BOB = " " + PREFIX_ADDRESS + VALID_ADDRESS_BOB;
    public static final String TAG_DESC_FRIEND = " " + PREFIX_TAG + VALID_TAG_FRIEND;
    public static final String TAG_DESC_HUSBAND = " " + PREFIX_TAG + VALID_TAG_HUSBAND;

    public static final String INVALID_NAME_DESC = " " + PREFIX_NAME + "James&"; // '&' not allowed in names
    public static final String INVALID_PHONE_DESC = " " + PREFIX_PHONE + "911a"; // 'a' not allowed in phones
    public static final String INVALID_EMAIL_DESC = " " + PREFIX_EMAIL + "bob!yahoo"; // missing '@' symbol
    public static final String INVALID_ADDRESS_DESC = " " + PREFIX_ADDRESS; // empty string not allowed for addresses
    public static final String INVALID_TAG_DESC = " " + PREFIX_TAG + "hubby*"; // '*' not allowed in tags

    // For testing of SortAppointmentDescriptor
    public static final String VALID_SORTING_ORDER_ASC = "asc";
    public static final String VALID_SORTING_ORDER_DES = "des";
    public static final String VALID_SORTING_KEY_APPOINTMENT_DATETIME = "datetime";
    public static final String VALID_SORTING_KEY_APPOINTMENT_NAME = "name";

    public static final SortAppointmentCommand.SortAppointmentDescriptor ASC_DATETIME;
    public static final SortAppointmentCommand.SortAppointmentDescriptor DES_NAME;

    public static final String PREAMBLE_WHITESPACE = "\t  \r  \n";
    public static final String PREAMBLE_NON_EMPTY = "NonEmptyPreamble";

    public static final EditCommand.EditPersonDescriptor DESC_AMY;
    public static final EditCommand.EditPersonDescriptor DESC_BOB;

    static {
        DESC_AMY = new EditPersonDescriptorBuilder().withName(VALID_NAME_AMY)
                .withPhone(VALID_PHONE_AMY).withEmail(VALID_EMAIL_AMY).withAddress(VALID_ADDRESS_AMY)
                .withTags(VALID_TAG_FRIEND).build();
        DESC_BOB = new EditPersonDescriptorBuilder().withName(VALID_NAME_BOB)
                .withPhone(VALID_PHONE_BOB).withEmail(VALID_EMAIL_BOB).withAddress(VALID_ADDRESS_BOB)
                .withTags(VALID_TAG_HUSBAND, VALID_TAG_FRIEND).build();
        ASC_DATETIME = new SortAppointmentDescriptorBuilder().withSortingOrder(VALID_SORTING_ORDER_ASC)
                .withAppointmentSortingKey(VALID_SORTING_KEY_APPOINTMENT_DATETIME).build();
        DES_NAME = new SortAppointmentDescriptorBuilder().withSortingOrder(VALID_SORTING_ORDER_DES)
                .withAppointmentSortingKey(VALID_SORTING_KEY_APPOINTMENT_NAME).build();
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - the returned {@link CommandResult} matches {@code expectedCommandResult} <br>
     * - the {@code actualModel} matches {@code expectedModel}
     */
    public static void assertCommandSuccess(Command command, Model actualModel, CommandResult expectedCommandResult,
            Model expectedModel) {
        try {
            CommandResult result = command.execute(actualModel);
            assertEquals(expectedCommandResult, result);
            assertEquals(expectedModel, actualModel);
        } catch (CommandException ce) {
            throw new AssertionError("Execution of command should not fail.", ce);
        }
    }

    /**
     * Convenience wrapper to {@link #assertCommandSuccess(Command, Model, CommandResult, Model)}
     * that takes a string {@code expectedMessage}.
     */
    public static void assertCommandSuccess(Command command, Model actualModel, String expectedMessage,
            Model expectedModel) {
        CommandResult expectedCommandResult = new CommandResult(expectedMessage);
        assertCommandSuccess(command, actualModel, expectedCommandResult, expectedModel);
    }

    /**
     * Executes the given {@code command}, confirms that <br>
     * - a {@code CommandException} is thrown <br>
     * - the CommandException message matches {@code expectedMessage} <br>
     * - the address book, filtered person list and selected person in {@code actualModel} remain unchanged
     */
    public static void assertCommandFailure(Command command, Model actualModel, String expectedMessage) {
        // we are unable to defensively copy the model for comparison later, so we can
        // only do so by copying its components.
        AddressBook expectedAddressBook = new AddressBook(actualModel.getAddressBook());
        List<Person> expectedFilteredList = new ArrayList<>(actualModel.getFilteredPersonList());

        assertThrows(CommandException.class, expectedMessage, () -> command.execute(actualModel));
        assertEquals(expectedAddressBook, actualModel.getAddressBook());
        assertEquals(expectedFilteredList, actualModel.getFilteredPersonList());
    }
    /**
     * Updates {@code model}'s filtered list to show only the person at the given {@code targetIndex} in the
     * {@code model}'s address book.
     */
    public static void showPersonAtIndex(Model model, Index targetIndex) {
        assertTrue(targetIndex.getZeroBased() < model.getFilteredPersonList().size());

        Person person = model.getFilteredPersonList().get(targetIndex.getZeroBased());
        final String[] splitName = person.getName().name.split("\\s+");
        model.updateFilteredPersonList(new NameContainsKeywordsPredicate(Arrays.asList(splitName[0])));

        assertEquals(1, model.getFilteredPersonList().size());
    }

}
