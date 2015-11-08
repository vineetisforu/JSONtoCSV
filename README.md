# JSONtoCSV
Conversion of Json to CSV

# Specify the api(Get Method) in the job.properties file which should return json output of this format
[
    {
        "_id": 376217,
        "key": null,
        "name": "Berlin",
        "fullName": "Berlin, Germany",
        "iata_airport_code": null,
        "type": "location",
        "country": "Germany",
        "geo_position": {
            "latitude": 52.52437,
            "longitude": 13.41053
        },
        "locationId": 8384,
        "inEurope": true,
        "countryCode": "DE",
        "coreCountry": true,
        "distance": null
    },
    {
        "_id": 448103,
        "key": null,
        "name": "Berlingo",
        "fullName": "Berlingo, Italy",
        "iata_airport_code": null,
        "type": "location",
        "country": "Italy",
        "geo_position": {
            "latitude": 45.50298,
            "longitude": 10.04366
        },
        "locationId": 147721,
        "inEurope": true,
        "countryCode": "IT",
        "coreCountry": true,
        "distance": null
    }
]

# Running the process
java -jar com.ge.converter.driver.Invoker
