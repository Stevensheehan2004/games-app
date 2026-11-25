# Games App

Games App was created because I wanted to build something simple and useful while learning Kotlin. It's a lightweight console app with minimal dependencies and a small codebase.

## Features

* Add, list, update and delete games from a simple menu
* Give each game a name, genre, price, production cost, copies sold and company ID
* Unique auto-generated ID for every game
* Robust input handling: invalid numbers are re-prompted instead of crashing the app
* Clean, readable game listing using a custom `toString()`
* Startup and exit logging
* Written in Kotlin with a small layered structure (model, service, utils)

## Models

* **Game:** name, genre, price, production cost, copies sold, company ID
* **Company:** name, year founded, expected margin

## Built With

* Kotlin
* Gradle (Kotlin DSL)
* kotlin-logging
* slf4j-simple

## Running the App

* Clone the repository
* Open the project in IntelliJ IDEA and let Gradle sync
* Run `Main.kt`

## Limitations

* Data is stored in memory only, so it's lost when the app closes
* Company management is not supported yet
* Console only, with no graphical interface
