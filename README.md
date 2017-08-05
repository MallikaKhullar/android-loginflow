# Assignment: Login Flow for Zolostays

### Summary
Project Author: Mallika Priya Khullar

### Libraries/Concepts/Tools used:
* MVP
* Dagger2
* Butterknife
* SQLite

### Things left to be implemented (can be done if required):
* Password (left drawable icon)
* Email Service - (Gmail Authentication)
* Unit testing due to lack of time (Can implement unit tests for LoginPresenter in a separate branch if required).

### Flow:
* Open -> If logged in -> Profile Page
* Open -> If not logged in -> Log in page

* Log in -> Correct creds -> Profile page
* Log in -> Incorrect creds -> Snackbar

* Forgot password -> Send email -> Redirect to log in page

* Registration page -> On successful registration -> Redirect to log in page
