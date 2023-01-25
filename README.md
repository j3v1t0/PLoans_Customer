# Project Loans - Microservice Customer
Crud and loan project functions - Microservice Customer

Create Customer (POST - http://localhost:1122/api/customer/save)

  {

    "customer":{
        "customerName": "Alexander",
        "customerLastname": "Grullón",
        "identificationType": "PERSONAL_ID",
        "identification": "201-3116246-8",
        "email": "alexander@gmail.com",
        "sex": "MALE",
        "civilStatus": "MARRIED",
        "customerStatus": "ACTIVE",
        "phoneList": [
            {
                "phoneLabel": "CELLPHONE",
                "number": "8013481",
                "cityCode": "1",
                "countryCode": "829"
            },
            {
                "phoneLabel": "HOME",
                "number": "5113714",
                "cityCode": "1",
                "countryCode": "849"
            }

        ],
        "residenceDetails": [
            {
            "ownershipStatus": "RENTED",
            "timeLivingYears": 4,
            "timeLivingMonth": 3,
            "addressCustomer": "Center St. 24",
            "apartmentNumber": "B"
            }
        ]
    }
  }

Get Customer Details for a list view (GET - http://localhost:1122/api/customer/findallcustomerlist)

"Result":

  
    {
        "customerReference": 20230,
        "customerName": "Alexander",
        "customerLastname": "Grullón",
        "identification": "201-3116246-8",
        "email": "alexander@gmail.com",
        "customerStatus": "ACTIVE",
        "dateCreated": "2023-01-25T11:40:24.849399"
    },
    {
        "customerReference": 20231,
        "customerName": "Alfredo",
        "customerLastname": "Caceres",
        "identification": "001-1211135-3",
        "email": "alfredo@gmail.com",
        "customerStatus": "ACTIVE",
        "dateCreated": "2023-01-25T16:29:18.806675"
    }
  




update for client status - ACTIVE OR INACTIVE(PUT - http://localhost:1122/api/customer/change/16b26ef5-ef77-4a2c-a8dc-39e24bff3b5c/INACTIVE)
returns true or false

Updating any saved customer data (PUT - http://localhost:1122/api/customer/update/16b26ef5-ef77-4a2c-a8dc-39e24bff3b5c)

  {

    "customer":{
        "customerName": "Alexander",
        "customerLastname": "Grullón",
        "identificationType": "PERSONAL_ID",
        "identification": "201-3116246-8",
        "email": "alexandergrullon@gmail.com",
        "sex": "MALE",
        "civilStatus": "SINGLE",
        "customerStatus": "ACTIVE",
        "phoneList": [
            {
                "phoneLabel": "CELLPHONE",
                "number": "8013481",
                "cityCode": "1",
                "countryCode": "829"
            },
            {
                "phoneLabel": "HOME",
                "number": "5113714",
                "cityCode": "1",
                "countryCode": "849"
            }

        ],
        "residenceDetails": [
            {
            "ownershipStatus": "OWNED",
            "timeLivingYears": 5,
            "timeLivingMonth": 2,
            "addressCustomer": "Center St. 24",
            "apartmentNumber": "B"
            }
        ]
    }
  }
