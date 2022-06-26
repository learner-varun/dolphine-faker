# Welcome to Dolphin Faker

 **Dolphin Faker** is a example for mocking the API response using Wiremock Server, This is a simple and easy to use tool for testing apps/ websites  using mocked APIs and this can be used to learn basics of API automation or practising API verification tools. 


# How To Use ?

- Clone the project
- Create a JSON file in `'src/main/resources/APIDetails'` and add details in below format

> `[{  
    "URL": "/SampleURL",  
    "HTTPMethod": "GET",  
    "ResponseCode": 200,  
    "LoadFromFile": true,  
    "ResponseFile": "File Path",  
    "Response": ""  
  },  
  {  
    "URL": "/SampleURL",  
    "HTTPMethod": "POST",  
    "ResponseCode": 200,  
    "LoadFromFile": false,  
    "ResponseFile": "",  
    "Response": "Response"
    }]
    `

You can add as many APIs you need and If you need to read response from a file Pass the file URL in `'ResponseFile'` and mark `'LoadFromFile'=true` 

- Run the below command after navigating to root folder 
> mvn clean install -DJsonFile="API_DETAILS_JSON_FILE_NAME"

- Now APIs are available in http://localhost:9909

There is a default JSON file loaded for sample data, The API details and post man collection is available here - https://www.getpostman.com/collections/cfc46083f9d9860a8405
