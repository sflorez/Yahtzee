/**
 * Category type class that sets up categoryType enumeration
 * @author Katie Porterfield, Melissa Abramson, Sebastian Florez
 */
package yahtzee.model;

public enum CategoryType
{
    ONES("Ones"),
    TWOS("Twos"),
    THREES("Threes"),
    FOURS("Fours"),
    FIVES("Fives"),
    SIXES("Sixes"),
    THREE_OF_KIND("Three of a kind"),
    FOUR_OF_KIND("Four of a kind"),
    SMALL_STRAIGHT("Small Straight"),
    LARGE_STRAIGHT("Large Straight"),
    FULL_HOUSE("Full House"),
    YAHTZEE("Yahtzee"),
    CHANCE("Chance");

    private String myName;
    CategoryType(String name)
    {
        myName = name;
    }

    public String getName()
    {
        return myName;
    }
}
