# Google Maps Route with Selenium and TestNG
This project uses Selenium Webdriver, TestNG and Java to automate the process of checking public transport between two locations, and returns journey times using Google Maps.
## Features
- Opens Google Maps
- Enters From and To locations
- Switches to public transport icon
- Extracts and prints
    - Next available public transport
    - Total journey duration
 - Data driven using CVS file

## Tech Stack
- Java
- Selenium
- TestNG
- Maven
- Github Actions

## CSV test data
...csv
from,to
Paddington station,Swindon
Victoria station.Brighton

How to run locally
1. Clone the repo:
   git clone https://github.com/sonig82/Google-Maps-Route.git
   cd Google-Maps-Route
2. Update path/to/chromedriver in GoogleMapsRoute.java with the actual path to you ChromeDriver
3. Run tests via Maven:
     mvn test

Notes
- Google Maps UI changes often, so element locators might need to be updated periodically.

  Created by Gaurav Soni
