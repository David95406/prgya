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
}