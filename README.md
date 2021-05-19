# Waiterless
Contactless Ordering Android App

# Instructions
API Needs to be run first. Required installs are Flask and Pusher which should be included in the venv.
Simpliest way is to use PyCharm, run commands:
pip install flask
pip install pusher
This is only if the venv is not sufficent 

# General
This app is for ordering items at a restaurant without the need of a waiter taking the order
It uses an external app for communuication between customer and employee

# Login page
Uses for guest, returning customer, new customer, and employee
Gust/customer buttons lead to customer page
Employee page leads to employee page

# Employee
Sees which tables need service
Sees orders as they come in

# Customer
Able to change personal info
Able to select restaurant and table
Able to select food

# Restaurant
Populates menu based on which restaurant is needed
Able to send message to the employees
