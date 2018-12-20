package com.akshaydaketest.pitest;

import org.junit.Before;
import org.junit.Test;

import com.akshaydake.pitest.Passenger;
import com.akshaydake.pitest.TicketPriceCalculator;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class TicketPriceCalculatorTest {

    private static int ADULT_TICKET_PRICE_BUS = 40;
    private static int CHILD_TICKER_PRICE_BUS = 20;
    
    private static int ADULT_TICKET_PRICE_TRAIN = 20;
    private static int CHILD_TICKER_PRICE_TRAIN = 10;
    
    private static int ADULT_TICKET_PRICE_TAXI = 80;
    private static int CHILD_TICKER_PRICE_TAXI = 50;
    
    private static int ADULT_TICKET_PRICE_AIRPLANE = 4000;
    private static int CHILD_TICKER_PRICE_AIRPLANE = 2000;
    

    private static int ADULT_TICKET_PRICE_SHIP = 4000;
    private static int CHILD_TICKER_PRICE_SHIP = 2000;
    

    private static int ADULT_TICKET_PRICE_MOVIE = 4000;
    private static int CHILD_TICKER_PRICE_MOVIE = 2000;
    private TicketPriceCalculator calculator;
    
    
    @Before
	  public void setUp() {
    	calculator = new TicketPriceCalculator();
	  }

    @Test
    public void calculatePriceForOneAdultBUS() {
    
    	List<Passenger> passengers = new ArrayList<>();
        Passenger passenger = new Passenger(20);
        passengers.add(passenger);
        int[] arr = {10,30,35,28,22,25,29,50,78,44};
        int n=10;
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(ADULT_TICKET_PRICE_BUS, price, 0);
    
    }
/*
    @Test
    public void sortPassengerAgeBUS() {
    
    	
        int[] arr = {10,30,35,28,22,25,29,50,78,44};
        int n=10;
        int[] age = calculator.mergeSort(arr,n);
        assertEquals(arr,age);
    
    }
    */
    
    @Test
    public void calculatePriceForChildBUS() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(15);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(CHILD_TICKER_PRICE_BUS, price, 0);
    
    }

    @Test
    public void calculatePriceForFamilyBUS() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger3 = new Passenger(12);
        Passenger childPassenger4 = new Passenger(4);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger3);
        passengers.add(childPassenger4);
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals((2 * ADULT_TICKET_PRICE_BUS + 2 * CHILD_TICKER_PRICE_BUS) *
                (1 - TicketPriceCalculator.FAMILY_DISCOUNT_BUS), price, 0);
    
    }

    @Test
    public void calculatePriceForChildNarrowCaseBUS() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(18);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(CHILD_TICKER_PRICE_BUS, price, 0);
    
    }

    @Test
    public void calculatePriceForFreeTicketNarrowCaseBUS() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(3);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals(0, price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithAdultsBUS() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger1);
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals((2 * ADULT_TICKET_PRICE_BUS + CHILD_TICKER_PRICE_BUS), price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithChildrenBUS() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        Passenger childPassenger2 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(childPassenger1);
        passengers.add(childPassenger2);
        double price = calculator.calculatePriceBus(passengers, ADULT_TICKET_PRICE_BUS, CHILD_TICKER_PRICE_BUS);
        assertEquals((ADULT_TICKET_PRICE_BUS + 2 * CHILD_TICKER_PRICE_BUS), price, 0);
    
    }
    
    
    @Test
    public void calculatePriceForOneAdultTRAIN() {
    
    	List<Passenger> passengers = new ArrayList<>();
        Passenger passenger = new Passenger(20);
        passengers.add(passenger);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals(ADULT_TICKET_PRICE_TRAIN, price, 0);
    
    }

    @Test
    public void calculatePriceForChildTRAIN() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(15);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals(CHILD_TICKER_PRICE_TRAIN, price, 0);
    
    }

    @Test
    public void calculatePriceForFamilyTRAIN() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger3 = new Passenger(12);
        Passenger childPassenger4 = new Passenger(4);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger3);
        passengers.add(childPassenger4);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals((2 * ADULT_TICKET_PRICE_TRAIN + 2 * CHILD_TICKER_PRICE_TRAIN) *
                (1 - TicketPriceCalculator.FAMILY_DISCOUNT_TRAIN), price, 0);
    
    }

    @Test
    public void calculatePriceForChildNarrowCaseTRAIN() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(18);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals(CHILD_TICKER_PRICE_TRAIN, price, 0);
    
    }

    @Test
    public void calculatePriceForFreeTicketNarrowCaseTRAIN() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(3);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals(0, price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithAdultsTRAIN() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger1);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals((2 * ADULT_TICKET_PRICE_TRAIN + CHILD_TICKER_PRICE_TRAIN), price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithChildrenTRAIN() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        Passenger childPassenger2 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(childPassenger1);
        passengers.add(childPassenger2);
        double price = calculator.calculatePriceTrain(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals((ADULT_TICKET_PRICE_TRAIN + 2 * CHILD_TICKER_PRICE_TRAIN), price, 0);
    
    }
    
    
    @Test
    public void calculatePriceForOneAdultTAXI() {
    
    	List<Passenger> passengers = new ArrayList<>();
        Passenger passenger = new Passenger(20);
        passengers.add(passenger);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TRAIN, CHILD_TICKER_PRICE_TRAIN);
        assertEquals(ADULT_TICKET_PRICE_TRAIN, price, 0);
    
    }

    @Test
    public void calculatePriceForChildTAXI() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(15);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TAXI, CHILD_TICKER_PRICE_TRAIN);
        assertEquals(CHILD_TICKER_PRICE_TRAIN, price, 0);
    
    }

    @Test
    public void calculatePriceForFamilyTAXI() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger3 = new Passenger(12);
        Passenger childPassenger4 = new Passenger(4);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger3);
        passengers.add(childPassenger4);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TAXI, CHILD_TICKER_PRICE_TAXI);
        assertEquals((2 * ADULT_TICKET_PRICE_TAXI + 2 * CHILD_TICKER_PRICE_TAXI) *
                (1 - TicketPriceCalculator.FAMILY_DISCOUNT_TAXI), price, 0);
    
    }

    @Test
    public void calculatePriceForChildNarrowCaseTAXI() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(18);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TAXI, CHILD_TICKER_PRICE_TAXI);
        assertEquals(CHILD_TICKER_PRICE_TAXI, price, 0);
    
    }

    @Test
    public void calculatePriceForFreeTicketNarrowCaseTAXI() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(3);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TAXI, CHILD_TICKER_PRICE_TAXI);
        assertEquals(0, price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithAdultsTAXI() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger1);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TAXI, CHILD_TICKER_PRICE_TAXI);
        assertEquals((2 * ADULT_TICKET_PRICE_TAXI + CHILD_TICKER_PRICE_TAXI), price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithChildrenTAXI() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        Passenger childPassenger2 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(childPassenger1);
        passengers.add(childPassenger2);
        double price = calculator.calculatePriceTaxi(passengers, ADULT_TICKET_PRICE_TAXI, CHILD_TICKER_PRICE_TAXI);
        assertEquals((ADULT_TICKET_PRICE_TAXI + 2 * CHILD_TICKER_PRICE_TAXI), price, 0);
    
    }
    
    @Test
    public void calculatePriceForOneAdultShip() {
    
    	List<Passenger> passengers = new ArrayList<>();
        Passenger passenger = new Passenger(20);
        passengers.add(passenger);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_SHIP, CHILD_TICKER_PRICE_SHIP);
        assertEquals(ADULT_TICKET_PRICE_SHIP, price, 0);
    
    }

    @Test
    public void calculatePriceForChildShip() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(15);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_SHIP, CHILD_TICKER_PRICE_SHIP);
      assertEquals(CHILD_TICKER_PRICE_SHIP, price, 0);
    
    }

    @Test
    public void calculatePriceForFamilyShip() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger3 = new Passenger(12);
        Passenger childPassenger4 = new Passenger(4);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger3);
        passengers.add(childPassenger4);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_SHIP, CHILD_TICKER_PRICE_SHIP);
       assertEquals((2 * ADULT_TICKET_PRICE_SHIP + 2 * CHILD_TICKER_PRICE_SHIP) *
                (1 - TicketPriceCalculator.FAMILY_DISCOUNT_SHIP), price, 0);
    
    }

    @Test
    public void calculatePriceForChildNarrowCaseShip() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(18);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_SHIP, CHILD_TICKER_PRICE_AIRPLANE);
        assertEquals(CHILD_TICKER_PRICE_AIRPLANE, price, 0);
    
    }

    @Test
    public void calculatePriceForFreeTicketNarrowCaseShip() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(3);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_SHIP, CHILD_TICKER_PRICE_SHIP);
       assertEquals(0, price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithAdultsShip() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger1);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_SHIP, CHILD_TICKER_PRICE_SHIP);
     assertEquals((2 * ADULT_TICKET_PRICE_SHIP + CHILD_TICKER_PRICE_SHIP), price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithChildrenShip() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        Passenger childPassenger2 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(childPassenger1);
        passengers.add(childPassenger2);
        double price = calculator.calculatePriceShip(passengers, ADULT_TICKET_PRICE_AIRPLANE, CHILD_TICKER_PRICE_SHIP);
        assertEquals((ADULT_TICKET_PRICE_SHIP + 2 * CHILD_TICKER_PRICE_SHIP), price, 0);
    
    }
    
    @Test
    public void calculatePriceForOneAdultMovie() {
    
    	List<Passenger> passengers = new ArrayList<>();
        Passenger passenger = new Passenger(20);
        passengers.add(passenger);
        double price = calculator.calculatePriceMovie(passengers, ADULT_TICKET_PRICE_MOVIE, CHILD_TICKER_PRICE_MOVIE);
        assertEquals(ADULT_TICKET_PRICE_MOVIE, price, 0);
    
    }
    

    @Test
    public void calculatePriceForChildMovie() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(15);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceAirPlane(passengers, ADULT_TICKET_PRICE_AIRPLANE, CHILD_TICKER_PRICE_AIRPLANE);
        assertEquals(CHILD_TICKER_PRICE_AIRPLANE, price, 0);
    
    }

    @Test
    public void calculatePriceForFamilyMovie() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger3 = new Passenger(12);
        Passenger childPassenger4 = new Passenger(4);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger3);
        passengers.add(childPassenger4);
        double price = calculator.calculatePriceMovie(passengers, ADULT_TICKET_PRICE_MOVIE, CHILD_TICKER_PRICE_MOVIE);
        assertEquals((2 * ADULT_TICKET_PRICE_MOVIE + 2 * CHILD_TICKER_PRICE_MOVIE) *
                (1 - TicketPriceCalculator.FAMILY_DISCOUNT_MOVIE), price, 0);
    
    }

    @Test
    public void calculatePriceForChildNarrowCaseMovie() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(18);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceMovie(passengers, ADULT_TICKET_PRICE_MOVIE, CHILD_TICKER_PRICE_MOVIE);
        assertEquals(CHILD_TICKER_PRICE_MOVIE, price, 0);
    
    }

    @Test
    public void calculatePriceForFreeTicketNarrowCaseMovie() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger childPassenger = new Passenger(3);
        passengers.add(childPassenger);
        double price = calculator.calculatePriceMovie(passengers, ADULT_TICKET_PRICE_MOVIE, CHILD_TICKER_PRICE_MOVIE);
        assertEquals(0, price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithAdultsMovie() {
      
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger adultPassenger2 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(adultPassenger2);
        passengers.add(childPassenger1);
        double price = calculator.calculatePriceMovie(passengers, ADULT_TICKET_PRICE_MOVIE, CHILD_TICKER_PRICE_MOVIE);
        assertEquals((2 * ADULT_TICKET_PRICE_MOVIE + CHILD_TICKER_PRICE_MOVIE), price, 0);
    
    }

    @Test
    public void shouldNotCalculatePriceForFamilyEdgeCaseWithChildrenMovie() {
       
    	List<Passenger> passengers = new ArrayList<>();
        Passenger adultPassenger1 = new Passenger(20);
        Passenger childPassenger1 = new Passenger(12);
        Passenger childPassenger2 = new Passenger(12);
        passengers.add(adultPassenger1);
        passengers.add(childPassenger1);
        passengers.add(childPassenger2);
        double price = calculator.calculatePriceMovie(passengers, ADULT_TICKET_PRICE_MOVIE, CHILD_TICKER_PRICE_MOVIE);
        assertEquals((ADULT_TICKET_PRICE_MOVIE + 2 * CHILD_TICKER_PRICE_MOVIE), price, 0);
    
    }
    
    
  
}