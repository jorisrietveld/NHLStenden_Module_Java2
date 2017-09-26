package ZuulBetter;

import java.util.ArrayList;
import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Class Room - a room in an adventure game.
 * <p>
 * This class is part of the "World of Zuul" application.
 * "World of Zuul" is a very simple, text based adventure game.
 * <p>
 * A "Room" represents one location in the scenery of the game.  It is
 * connected to other rooms via exits.  For each existing exit, the room
 * stores a reference to the neighboring room.
 *
 * @author Michael Kolling and David J. Barnes
 * @version 2008.03.30
 */
public class Room
{
    private String description;
    private HashMap<String, Room> exits;        // stores exits of this room.
    private HashMap<String, Item> items;
    private Room previousRoom;

    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     *
     * @param description The room's description.
     */
    public Room(String description)
    {
        this.description = description;
        exits = new HashMap<String, Room>();
        items = new HashMap<>();
    }

    /**
     * Gets previous room.
     *
     * @return the previous room
     */
    public Room getPreviousRoom()
    {
        return previousRoom;
    }

    /**
     * Sets previous room.
     *
     * @param previousRoom the previous room
     */
    public void setPreviousRoom(Room previousRoom)
    {
        this.previousRoom = previousRoom;
    }

    /**
     * Define an exit from this room.
     *
     * @param direction The direction of the exit.
     * @param neighbor  The room to which the exit leads.
     */
    public void setExit(String direction, Room neighbor)
    {
        exits.put(direction, neighbor);
    }

    /**
     * Gets short description.
     *
     * @return The short description of the room (the one that was defined in the constructor).
     */
    public String getShortDescription()
    {
        return description;
    }

    /**
     * Return a description of the room in the form:
     * You are in the kitchen.
     * Exits: north west
     *
     * @return A long description of this room
     */
    public String getLongDescription()
    {
        return "You are " + description + ".\n" + getExitString();
    }

    /**
     * Return a string describing the room's exits, for example
     * "Exits: north west".
     * @return Details of the room's exits.
     */
    private String getExitString()
    {
        String returnString = "Exits:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }

    /**
     * Return the room that is reached if we go from this room in direction
     * "direction". If there is no room in that direction, return null.
     *
     * @param direction The exit's direction.
     * @return The room in the given direction.
     */
    public Room getExit(String direction)
    {
        return exits.get(direction);
    }

    /**
     * Gets item.
     *
     * @param name the name
     * @return the item
     */
    public Item getItem( String name )
    {
        return items.getOrDefault( name, null );
    }

    /**
     * Sets item.
     *
     * @param item the item
     */
    public void setItem( Item item )
    {
        this.items = items;
    }

    /**
     * Gets items.
     *
     * @return the items
     */
    public HashMap<String, Item> getItems()
    {
        return items;
    }

    /**
     * Sets items.
     *
     * @param items the items
     */
    public void setItems(HashMap<String, Item> items)
    {
        this.items = items;
    }
}

