package exceptions;

/**
 * Created by Linus on 2018-05-18.
 */
public class ItemNotFoundException extends Exception {

    public ItemNotFoundException(int queriedId) {
        super("Item with identifier \"" + queriedId + "\" could not be found in registry");
    }
}
