package com.app.model;

/**
 * The Filename class represents a filename with an associated unique identifier.
 * This class is a record, which means it is a special kind of class that has private final fields,
 * a public constructor, accessor methods, equals, hashCode, and toString methods all generated automatically.
 *
 * @param id the unique identifier of the filename
 * @param filename the name of the file
 */
public record Filename(Long id, String filename) {
}