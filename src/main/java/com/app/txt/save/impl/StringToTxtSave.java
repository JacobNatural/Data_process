package com.app.txt.save.impl;

import com.app.txt.Transfer;
import com.app.txt.save.Save;
import com.app.txt.save.generic.SaveToTxt;

/**
 * Implementation of the Save interface for saving {@link String} data to a text file.
 *
 * <p>This class extends {@link SaveToTxt} and implements the {@link Save} interface, providing
 * a specific implementation for saving {@link String} data using the provided {@link Transfer}
 * mechanism.</p>
 *
 * @see Save
 * @see SaveToTxt
 * @see Transfer
 */
public class StringToTxtSave extends SaveToTxt<String> implements Save<String> {

    /**
     * Constructs a new StringToTxtSave instance.
     *
     * @param transfer the {@link Transfer} instance used for reading and writing data
     */
    public StringToTxtSave(Transfer<String, String> transfer) {
        super(transfer);
    }
}
