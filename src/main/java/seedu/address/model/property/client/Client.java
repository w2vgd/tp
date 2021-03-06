package seedu.address.model.property.client;

import java.util.Objects;

import seedu.address.model.name.Name;

/**
 * Represents the seller of a Property.
 * Guarantees: field values are validated, immutable.
 */
public class Client {
    public static final String STRING_CLIENT_NAME = "Client Name: ";
    public static final String STRING_CLIENT_CONTACT = "Client Contact: ";
    public static final String STRING_CLIENT_EMAIL = "Client Email: ";
    public static final String STRING_CLIENT_PRICE = "Client Asking Price: ";
    public static final String DELIMITER = "; ";

    private final Name clientName;
    private final Contact clientContact;
    private final Email clientEmail;
    private final AskingPrice clientAskingPrice;

    /**
     * Constructs a null {@code Client}.
     */
    public Client() {
        this.clientName = null;
        this.clientContact = null;
        this.clientEmail = null;
        this.clientAskingPrice = null;
    }

    /**
     * Constructs a {@code Client}.
     */
    public Client(Name clientName, Contact clientContact, Email clientEmail, AskingPrice clientAskingPrice) {
        this.clientName = clientName;
        this.clientContact = clientContact;
        this.clientEmail = clientEmail;
        this.clientAskingPrice = clientAskingPrice;
    }

    public Name getClientName() {
        return clientName;
    }

    public Contact getClientContact() {
        return clientContact;
    }

    public Email getClientEmail() {
        return clientEmail;
    }

    public AskingPrice getClientAskingPrice() {
        return clientAskingPrice;
    }

    @Override
    public int hashCode() {
        // use this method for custom fields hashing instead of implementing your own
        return Objects.hash(clientName, clientContact, clientEmail, clientAskingPrice);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();

        if (clientName != null) {
            builder.append(STRING_CLIENT_NAME).append(getClientName());
        }
        if (clientContact != null) {
            if (builder.length() != 0) {
                builder.append(DELIMITER);
            }
            builder.append(STRING_CLIENT_CONTACT).append(getClientContact());
        }
        if (clientEmail != null) {
            if (builder.length() != 0) {
                builder.append(DELIMITER);
            }
            builder.append(STRING_CLIENT_EMAIL).append(getClientEmail());
        }
        if (clientAskingPrice != null) {
            if (builder.length() != 0) {
                builder.append(DELIMITER);
            }
            builder.append(STRING_CLIENT_PRICE).append(getClientAskingPrice());
        }

        return builder.toString();
    }
}
