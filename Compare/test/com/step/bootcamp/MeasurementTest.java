package com.step.bootcamp;

import com.sun.jdi.InvalidTypeException;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;


public class MeasurementTest {
    @Test
    public void shouldGiveTrueForOneFeetAndOneFeet() {
        Measurement oneFoot = Measurement.inFeet(1);
        Measurement expectedFoot = Measurement.inFeet(1);
        assertEquals(oneFoot, expectedFoot);
        assertEquals(oneFoot.hashCode(),expectedFoot.hashCode());
    }

    @Test
    public void shouldGiveTrueForOneFeetAndTwelveInch() {
        Measurement oneFoot = Measurement.inFeet(1);
        Measurement twelveInches = Measurement.inInch(12);
        assertEquals(oneFoot, twelveInches);
        assertEquals(oneFoot.hashCode(),twelveInches.hashCode());
    }

    @Test
    public void shouldGiveFalseForUnequalFeet() {
        Measurement oneFoot = Measurement.inFeet(1);
        Measurement twoFeet = Measurement.inFeet(2);
        assertNotEquals(twoFeet,oneFoot);
        assertNotEquals(oneFoot.hashCode(),twoFeet.hashCode());
    }

    @Test
    public void shouldGiveFalseForOneFootAndSixInch() {
        Measurement oneFoot = Measurement.inFeet(1);
        Measurement sixInches = Measurement.inInch(6);
        assertNotEquals(oneFoot,sixInches);
    }




    @Test
    public void twoInchShouldBeEqualToFiveCentimeter() {
        Measurement fiveCentimeters = Measurement.inCentimeters(5);
        Measurement twoInches = Measurement.inInch(2);
        assertEquals(twoInches,fiveCentimeters);
    }

    @Test
    public void fourInchesShouldBeEqualToTenCentimeter() {
        Measurement tenCentimeter = Measurement.inCentimeters(10);
        Measurement fourInch = Measurement.inInch(4);
        assertEquals(fourInch,tenCentimeter);
    }

    @Test
    public void tenMillimetersShouldBeEqualToOneCentimeter() {
        Measurement oneCentimeter = Measurement.inCentimeters(1);
        Measurement tenMillimeters = Measurement.inMillimeter(10);
        assertEquals(oneCentimeter,tenMillimeters);
    }

    @Test
    public void oneGallonShouldBeEqualToThreePointSevenEightLitres() {
        Measurement threePointSevenEightLitres = Measurement.inLitres(3.78);
        Measurement oneGallon = Measurement.inGallon(1);
        assertEquals(oneGallon,threePointSevenEightLitres);
    }

    @Test
    public void oneGallonShouldNotBeEqualToOneInch() {
        Measurement oneInch = Measurement.inInch(1);
        Measurement oneLitre = Measurement.inLitres(1);
        assertNotEquals(oneLitre,oneInch);
    }

    @Test
    public void oneKgShouldBeEqualToThousandGrams() {
        Measurement oneKiloGram = Measurement.inKilograms(1);
        Measurement thousandGrams = Measurement.inGrams(1000);
        assertEquals(oneKiloGram,thousandGrams);
    }

    @Test
    public void oneTonShouldBeEqualToThousandKg() {
        Measurement oneTon = Measurement.inTon(1);
        Measurement thousandKg = Measurement.inKilograms(1000);
        assertEquals(oneTon,thousandKg);
    }

    @Test
    public void addingTwo2InchesShouldbeEqualTo4Inches() throws InvalidTypeException {
        Measurement twoInches = Measurement.inInch(2);
        Measurement anotherTwoInches = Measurement.inInch(2);
        Measurement fourInches = Measurement.inInch(4);
        Measurement actual = twoInches.add(anotherTwoInches);
        assertEquals(actual,fourInches);
    }

    @Test(expected = InvalidTypeException.class)
    public void shouldNotAddLitreAndInches() throws InvalidTypeException {
        Measurement twoInches = Measurement.inInch(2);
        Measurement twoLitres = Measurement.inLitres(2);
        Measurement nothing = twoLitres.add(twoInches);
    }

    @Test
    public void addingOf2InchesAnd2Point5CentimetersShouldbeEqualTo3Inches() throws InvalidTypeException {
        Measurement twoInches = Measurement.inInch(2);
        Measurement twoPoint5cm = Measurement.inCentimeters(2.5);
        Measurement threeInches = Measurement.inInch(3);
        Measurement actual = twoInches.add(twoPoint5cm);
        assertEquals(actual,threeInches);
        assertEquals(actual.toString(),threeInches.toString());
    }



    @Test
    public void addingOneGallonAndOneLitreShouldbeEqualToFourPointSevenEight() throws InvalidTypeException {
        Measurement oneGallon = Measurement.inGallon(1);
        Measurement oneLitre = Measurement.inLitres(1);
        Measurement fourPointSevenEight = Measurement.inLitres(4.8);
        Measurement actual = oneLitre.add(oneGallon);
        System.out.println(actual);
        assertEquals(fourPointSevenEight,actual);
    }

    @Test
    public void twoHunderedTwelveFahernheitShouldbeEqualToOneHunderedCelcius() {
        Measurement oneHunderedCelcius = Measurement.inCelcius(100);
        Measurement twoHunderedTweleveFahrenheit = Measurement.inFahrenheit(212);
        assertEquals(oneHunderedCelcius,twoHunderedTweleveFahrenheit);
    }


    @Test
    public void oneKgShouldCovertToThousandGrams() throws InvalidTypeException {
        Measurement oneKg = Measurement.inKilograms(1);
        Measurement thousandGrams = Measurement.inGrams(1000);
        assertEquals(oneKg.toUnit(Unit.GRAM),thousandGrams);
    }
}
