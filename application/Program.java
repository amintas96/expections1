package application;

import model.entities.Reservation;
import model.exceptions.DomainExpections;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Program {
    public static void main(String[] args)  {

        try {
            Scanner sc = new Scanner(System.in);
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            System.out.println("Room Number: ");
            int number = sc.nextInt();
            System.out.println("Check-in date (dd/mm/yyyy)");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/mm/yyyy)");
            Date checkOut = sdf.parse(sc.next());

            Reservation reservation = new Reservation(number, checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

            System.out.println();
            System.out.println("Enter data to update the reservation:");
            System.out.println("Check-in date (dd/mm/yyyy)");
            checkIn = sdf.parse(sc.next());
            System.out.println("Check-out date (dd/mm/yyyy)");
            checkOut = sdf.parse(sc.next());

            reservation.updateDates(checkIn, checkOut);
            System.out.println("Reservation: " + reservation);

        } catch (ParseException e) {
            System.out.println("Invalid date format");
        } catch (DomainExpections e) {
            System.out.println("Error in reservation " + e.getMessage());
        }

    }

}
