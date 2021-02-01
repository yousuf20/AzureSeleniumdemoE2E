Feature: Login into Application

Scenario Outline: Positive Test validate login
Given Initialize the driver with browser
And Navigate to "https://www.2degreesmobile.co.nz/" Website
And Click Submit link to land on Login Page
When User enters <Username> and <Password> and Logs in
Then Verify User logged in Successfully
And Close browsers

Examples:
|Username	         |Password		|
|ysyed2006@gmail.com |Bissmillah1	|
|khsyed3@gmail.com   |Bissmillah1   |