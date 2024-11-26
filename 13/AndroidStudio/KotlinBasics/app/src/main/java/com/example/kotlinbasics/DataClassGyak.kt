package com.example.kotlinbasics

class DataClassGyak {
    //1. feladat
    data class Course(
        val courseName: String,
        val credits: String
    )

    data class Student(
        val name: String,
        val studentId: String,
        val courses: List<Course>
    )

    data class Professor(
        val name: String,
        val subject: String
    )

    data class Department(
        val name: String,
        val professors: List<Professor>
    )

    data class University(
        val universityName: String,
        val departments: List<Department>,
        val students: List<Student>,
    )

    //2. feladat
    data class Airline(
        val name: String,
        val country: String
    )

    data class Flight(
        val flightNumber: String,
        val destination: String,
        val airline: Airline
    )

    data class Terminal(
        val terminalName: String,
        val flights: List<Flight>
    )

    data class Airport(
        val airportName: String,
        val terminals: List<Terminal>
    )

    //3. feladat
    data class Rating(
        val rating: Byte,
        val comment: String
    )

    data class Book(
        val title: String,
        val year: Int,
        val ratings: List<Rating>
    )

    data class Author(
        val authorName: String,
        val books: List<Book>
    )

    data class Publisher(
        val publisherName: String,
        val authors: List<Author>
    )

    //4. feldat
    data class Activity(
        val activityName: String,
        val type: String
    )

    data class Packagee(
        val packageId : String,
        val destination: String,
        val durationDays: Byte,
        val price: Long,
        val activities: List<Activity>
    )

    data class Ratingg(
        val score: Byte,
        val comment: String
    )

    data class Booking(
        val bookingId: String,
        val packagee: Packagee,
        val rating: Ratingg ?
    )

    data class Customer(
        val customerId: String,
        val name: String,
        val email: String,
        val bookings: List<Booking>,
    )

    data class Agency(
        val agencyName: String,
        val customers: List<Customer>
    )

    //uj 11-25
    //1 feladat
    data class UjCustomer(
        val customerId: String,
        val name: String,
        val email: String,
        val phone: String
    )

    data class Items(
        val itemId: String,
        val productName: String,
        val quantity: Byte,
        val pricePerUnit: Double,
        val discount: Double //vagy boolean
    )

    data class Shipping(
        val address: Address,
        val shippingMethod: String,
        val estimatedDeliveryDays: Byte
    )

    data class Address(
        val street: String,
        val city: String,
        val postalCode: Int,
        val country: String
    )

    data class Payment(
        val paymentMethod: String,
        val totalAmount: Double,
        val paid: Boolean
    )

    data class Order(
        val orderId: String,
        val customer: UjCustomer,
        val orderItems: List<Items>,
        val shipping: Shipping,
        val payment: Payment,
        val status: String
    )
    //2 feladat
    data class Member(
        val studentId: String,
        val name: String,
        val grade: Byte,
        val hasCompleted: Boolean
    )

    data class Assignment(
        val assignmentName: String,
        val maxPoints: Int,
        val studentScores: List<StudentScore>
    )

    data class StudentScore(
        val STU123: Int,
        val STU124: Int,
        val STU125: Int,
    )

    data class  Project(
        val projectName: String,
        val subject: String,
        val durationWeeks: Byte,
        val teamMembers: List<Member>,
        val assignments: List<Assignment>,
        val completed: Boolean
    )
    //3 feladat
    data class Location(
        val latitude: Double,
        val longitude: Double
    )

    data class Vehicle(
        val vehicleId: String,
        val capacity: Byte,
        val currentLocation: Location,
        val status: String
    )

    data class Schedule(
        val weekday: List<DepArr>,
        val weekend: List<DepArr>,
    )

    data class DepArr(
        val departureTime: String,
        val arrivalTime: String
    )

    data class Bus(
        val routeNumber: Int,
        val routeName: String,
        val vehicles: List<Vehicle>,
        val schedule: Schedule,
    )

    data class Tram(
        val routeNumber: Int,
        val routeName: String,
        val vehicles: List<Vehicle>,
        val schedule: Schedule,
    )

    data class TransitSystem(
        val busses: List<Bus>,
        val trams: List<Tram>
    )

    data class EmergencyContact(
        val name: String,
        val phone: String,
        val shift: String
    )

    data class ControlCenter(
        val contactNumber: String,
        val emergencyContacts: List<EmergencyContact>
    )

    data class City(
        val cityName: String,
        val transitSystem: TransitSystem,
        val controlCenter: ControlCenter,


    )

}