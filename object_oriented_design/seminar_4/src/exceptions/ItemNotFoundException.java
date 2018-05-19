package exceptions;

/**
 * Created by Linus on 2018-05-18.
 */
public class ItemNotFoundException extends Exception {

    /**
     * Thrown when an invalid identifier is used to try and
     * locate an item in the <code>InventoryHandler</code>
     *
     * @param queriedId - The ID that was used when no item was found
     */
    public ItemNotFoundException(int queriedId) {
        super("Item with identifier \"" + queriedId + "\" could not be found in registry.");
    }
}
