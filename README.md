# Spring-MicroService-Api

Backend Application:


● This is comprised of three APIs.

● The user should be assigned an account number. The AccountNumGenAPI will take care of generating this number.

● The user must also know how much cash they are entitled to; this service will be taken care of by the AccountPrizeAPI.

● We do not want the Browser to make calls to multiple APIs. Instead we want it to make calls to a main API which will then make the appropriate calls to AccountNumGenAPI and AccountPrizeAPI. This main API will be AccountAPI.
