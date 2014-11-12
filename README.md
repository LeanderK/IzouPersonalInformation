#Personal Information Addon for Izou
This addon stores all the information about the user in Izou. I can be used by other plugins to get Information like:
* the name
* the email-adress
* the location
* etc.

## Usage
### User
Run this addon for the first time, it will generate a properties file called:
leanderk.izou.personalinformation.InformationAddOn.properties

copy and replace the following text into the properties file and restart Izou:
```
#This is the template for the properties-file containing information about the User
#not everything is needed, but plugins may not work if information is missing

#basic data:

#first name of the user:
firstname = NameOfTheUser
#last name of the user:
lastname = LastNameOfTheUser


#email
email = example.mail@example.com


#location data

#postal code
postalcode = 11111
#town
town = karlsruhe
#street
street = streetname
#housenumer
housenumber = 1
```
### AddOn
A ContentGenerator with the ID `leanderk.izou.personalinformation.InformationAddOn` will generate a Content Data for every event. Content Data will hold a HashMap<String, String>, with the keys the keys from the properties file and the values the value. The ContentGenerator also has a getData method, which is thread-safe.
