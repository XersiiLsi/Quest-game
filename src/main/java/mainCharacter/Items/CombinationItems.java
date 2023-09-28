package mainCharacter.Items;

import java.util.EnumSet;
import java.util.List;


public class CombinationItems {

    public static Item combineItems(Item... items) {
        if (items.length == 2) {
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.stone, Item.stone)))
                return Item.groundStone;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.campfire, Item.meat)))
                return Item.cookedMeat;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.campfire, Item.fish)))
                return Item.cookedFish;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.gasMaskFilter, Item.bottle)))
                return Item.cleaningBottle;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.cleaningBottle, Item.water)))
                return Item.drinkingWaterBottle;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.pureWater, Item.bottle)))
                return Item.cleanWaterBottle;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.worm, Item.fishingRod)))
                return Item.finishedFishingRot;

        } else if (items.length == 3) {
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.groundStone, Item.stick, Item.rope)))
                return Item.axe;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.textile, Item.stick, Item.gasoline)))
                return Item.torch;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.water, Item.pot, Item.campfire)))
                return Item.pureWater;

        } else if (items.length == 4) {
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.riceCerealBag, Item.pot, Item.water, Item.campfire)))
                return Item.cookedRise;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.bagOfBuckwheat, Item.pot, Item.water, Item.campfire)))
                return Item.cookedBuckwheat;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.meat, Item.pot, Item.water, Item.campfire)))
                return Item.soup;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.fish, Item.pot, Item.water, Item.campfire)))
                return Item.soup;

            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.leaflet, Item.bills, Item.leaves, Item.magnifyingGlass)))
                return Item.campfire;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.branch, Item.book, Item.documentation, Item.matches)))
                return Item.campfire;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.leaves, Item.branch, Item.magazine, Item.flint)))
                return Item.campfire;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.log, Item.newspaper, Item.leaves, Item.lighter)))
                return Item.campfire;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.flint, Item.branch, Item.leaves, Item.newspaper)))
                return Item.campfire;
            if (EnumSet.copyOf(List.of(items)).containsAll(EnumSet.of(Item.leaflet, Item.leaves , Item.documentation , Item.lighter)))
                return Item.campfire;
        }
        return null;
    }
    }
