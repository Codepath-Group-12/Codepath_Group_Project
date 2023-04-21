# Concert Finder

## Table of Contents

1. [App Overview](#App-Overview)
1. [Product Spec](#Product-Spec)
1. [Wireframes](#Wireframes)
1. [Build Notes](#Build-Notes)

## App Overview
This app provides information on upcoming concerts based on location.
### Description 

This app allows you to search for concerts by entering location and date. The user can swipe through concerts vertically. Optionally they may be able to "favorite" certain concerts to save in a list 

### App Evaluation

<!-- Evaluation of your app across the following attributes -->
- Category
    - Events/Music
- Mobile: How uniquely mobile is the product experience?
    - What makes your app more than a glorified website?
        - People would use this app while they are out and they are trying to find something to do. 
- Story: How compelling is the story around this app once completed?
    - How clear is the value of this app to your audience?
        - Music lovers will be able to easily discover new bands.
    - How well would your friends or peers respond to this product idea?
        - it makes it convenient for finding shows 
- Market: How large or unique is the market for this app?
    - What's the size and scale of your potential user base?
        - In 2022, over 33.5 million people attended LiveNation shows.
    - Does this app provide huge value to a niche group of people?
        - This app could be valuable to music lovers looking for ease of access to find out information on a concert without resorting to the big name websites (Ticketmaster, seatgeek, etc.)
    - Do you have a well-defined audience of people for this app?
        - Yes, any music lover or someone who loves to go to shows

- Habit: How habit-forming or addictive is this app?
    - How frequently would an average user open and use this app?
        - A user might want to use this on weekends when they're bored
    - Does an average user just consume your app, or do they use it to create something?
        - A user might utilize this app to create an itinerary for their day, weekend, or a trip

- Scope: How well-formed is the scope for this app?
    - How technically challenging will it be to complete this app by the deadline?
        - The most challenging part of this app will be working with the API
    - Is a stripped-down version of this app still interesting to build?
        - A stripped-down version could remove the search functionality or limit the number of concerts shown. This would still be interesting to build and useful for those that are not picky.
    - How clearly defined is the product you want to build
        - We have a good idea of what we want this app to do. We want search functionality and recyclerview to display concert options as a start. We can build from there once this has been implemented.

## Product Spec

### 1. User Features (Required and Optional)

Required Features:

- Search concerts by location (zip code)
- Displays list of concerts, showing name of concert, location, and date of each concert


Stretch Features:

- Paradox of Choice Mode - Limits the user to three concerts
- Option to filter results by price, date (month)
- Ability to create a list of events you have saved

### 2. Chosen API(s)

- SeatGeek API
  - Provides all information needed for app to have functionality (including location, venue, artist, dates, price)


### 3. User Interaction

Required Feature

- Search box and button, enter text (requested location)
  - List of concerts displayed below search box
- Swipe vertically on screen
  - Swipes through the list of concerts

## Wireframes

<!-- Add picture of your hand sketched wireframes in this section -->
<img src="https://i.imgur.com/W1CDWt4.png" width="600" >

### [BONUS] Digital Wireframes & Mockups

### [BONUS] Interactive Prototype

## Build Notes

Here's a place for any other notes on the app, it's creation 
process, or what you learned this unit!  

For Milestone 2, include **2+ GIFs** of the build process here!

## License

Copyright 2023 Emily Craven, Ignacio De La Cruz, Joshua Randle

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
