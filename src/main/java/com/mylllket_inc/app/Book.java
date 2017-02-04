package com.mylllket_inc.app;

/**
 * Using to keep {@link String} data
 * and implements operations:
 * <ul>
 * <li>{@link #add(String)} to add data </li>
 * <li>{@link #remove(int)} to remove data by number</li>
 * <li>{@link #modify(int, String)} to replace data at number with new data</li>
 * </ul>
 */

public class Book {
    /**
     * {@link String} data for storing
     */
    private String[] data;
    /**
     * ID that changes when new {@link #Book()} added
     */
    private static int globalID;
    /**
     * ID of the {@link #Book()}
     */
    private int ID;
    /**
     * Size of the {@link #Book()}
     */
    private static int notes = 0;


    /**
     * Constructor generates {@link #ID} for new book
     */
    public Book() {
        globalID++;
        ID = globalID;
    }

    /**
     * Creates new book with specified size
     *
     * @param size Size of new book
     */
    private Book(int size) {
        data = new String[size];
    }

    /**
     * Creates copy of old {@link #Book()} with new {@link String} field in {@link #data}
     *
     * @param text {@link String} data
     */
    public void add(String text) {
        notes++;
        Book res = new Book(notes);
        if (this.data != null) {
            System.arraycopy(this.data, 0, res.data, 0, this.data.length);
        }
        res.data[notes - 1] = text;
        this.data = res.data;
    }

    /**
     * Creates new {@link #Book()} without specified <code>ID</code> field in {@link #data}
     *
     * @param ID Number of field to delete
     */
    public void remove(int ID) {
        if (ID < 0 || ID >= notes) return;
        if (this.data != null) {
            notes--;
            if (notes == 0) {
                this.data = null;
                return;
            }
            Book res = new Book(notes);
            System.arraycopy(this.data, 0, res.data, 0, ID);
            System.arraycopy(this.data, ID + 1, res.data, ID, res.data.length - ID);
            this.data = res.data;
        }
    }

    /**
     * Creates new {@link #Book()} with modified field at <code>ID</code> to <code>text</code>
     *
     * @param ID   Number to modify
     * @param text New text
     */
    public void modify(int ID, String text) {
        if (ID < 0 || ID >= notes) return;
        if (this.data != null) {
            Book res = new Book(notes);
            this.data[ID] = text;
            System.arraycopy(this.data, 0, res.data, 0, this.data.length);
            this.data = res.data;
        }
    }

    /**
     * Prints {@link #Book()} storage to console
     */
    public void printData() {
        if (this.data != null) {
            for (int i = 0; i < this.data.length; i++) {
                System.out.printf("BookID:%d data[%d]=%s%n", ID, i, this.data[i]);
            }
            System.out.println();
        } else {
            System.out.println("No data");
        }
    }
}
