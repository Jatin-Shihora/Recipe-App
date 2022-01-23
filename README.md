<!-- PROJECT LOGO -->
<br />
<p align="center">
  <a href="https://github.com/Jatin-Shihora/Recipe-App">
  </a>

  <h3 align="center">Recipe App</h3>

  <p align="center">
    Developing a app that fetches more than 3000 recipes with different types of dishes and shows user how to make those recipes . 
    <br />
    <a href="https://github.com/Jatin-Shihora/Recipe-App"><strong>Explore the Repo »</strong></a>
    <br />
    <br />
  </p>
</p>

<!-- TABLE OF CONTENTS -->
<details open="open">
  <summary>Table of Contents</summary>
  <ol>
    <li>
      <a href="#about-the-project">About The Project</a>
      <ul>
        <li><a href="#built-with">Built With</a></li>
      </ul>
    </li>
    <li>
      <a href="#getting-started">Getting Started</a>
      <ul>
        <li><a href="#prerequisites">Prerequisites</a></li>
        <li><a href="#installation">Installation</a></li>
      </ul>
    </li>
    <li><a href="#usage">Usage</a></li>
    <li><a href="#design workflow">Design Workflow</a></li>
    <li><a href="#contributing">Contributing</a></li>
    <li><a href="#license">License</a></li>
    <li><a href="#contact">Contact</a></li>
    <li><a href="#acknowledgements">Acknowledgements</a></li>
  </ol>
</details>

#### #Note: The app is still under development, many features are still to be developed so the images that you are viewing are till this point and will get updated as the app progresses.

<!-- ABOUT THE PROJECT -->

## About The Project

Demo run:-

https://user-images.githubusercontent.com/75017563/150692270-633d5ad8-1691-45de-9469-0b85fd3f6712.mp4

From the app's name it get's clear that it is being developed for the purpose of making different new recipes from all over the world whether it's an Indian cuisine, USA cuisine ,Mexican cuisine or Italian cuisine. The app fetches more than 3000 recipes in it. The main structure of the app is like an recipe book diary which helps the user to make some good recipes of dishes they always wanted to taste and since it will be in the form of digital records the users will enjoy the tracking of the recipes in an optimized manner and also in a clean manner. Usually the person who cooks have tendency to write everthing in traditional pen-paper system which later becomes tedious for them to track or sometimes it may get slipped through their mind and in the end they loose the track and the chaos starts in the recipes . So to prevent this chaos the app is being deveoped.

Of course,my app does not have everything and since your needs may be different or I may have missed some corner cases or features . So I'll be adding more features in the near future. You may also suggest changes by forking this repo and creating a pull request or opening an issue. Thanks to all the people who have inspired me for working towards this app :) !!

A list of commonly used resources that I find helpful are listed in the acknowledgements ;).

### Built With

This app was build with the help of Kotlin for coding the brain of the app and for ui part the app used the new ui declarative way approach known as Jetpack compose ui.
So the beautification comes throughout the app because of the jetpack compose way. The XML are also used were there is a need. The hilt is used for dependency injection .

- [Kotlin](https://kotlinlang.org/docs/android-overview.html)
- [Hilt](https://developer.android.com/training/dependency-injection/hilt-android)
- [Jetpack-Compose](https://developer.android.com/jetpack/compose/documentation)
- [XML](https://developer.mozilla.org/en-US/docs/Web/XML/XML_introduction)

<!-- GETTING STARTED -->

## Getting Started :

### App Compatibility

Android device running with Android OS 4.0.4 (API Level 15) or above. Best experienced on Android Noughat 7.1 and above. The app was tested on api level 27,28,29,30,31. Designed for Phones and NOT for Tablets.

### Prerequisites

Before getting in to this project you should have basic knowledge of the following terms

- Kotlin
- Jetpack Compose
- Hilt dependency injection
- MVVP architecture
- XML
- AndroidX compose ui
- Android SDK
- Android Studio

### Installation

1. Clone the repo
   ```sh
   git clone https://github.com/Jatin-Shihora/Recipe-App.git
   ```
2. Run the Gradle build Properly .
3. Develop some more amazing features .

<!-- USAGE EXAMPLES -->

## Usage

The App is being created while keeping in mind that a user from any part of the world can access the app as the dish variety is humongous in nature. Since the nature of the app is of international scope

The main structure of the app is like an recipe book diary which helps the user to make some good recipes of dishes they always wanted to taste and since it will be in the form of digital records the users will enjoy the tracking of the recipes in an optimized manner and also in a clean manner. Usually the person who cooks have tendency to write everthing in traditional pen-paper system which later becomes tedious for them to track or sometimes it may get slipped through their mind and in the end they loose the track and the chaos starts in the recipes . So to prevent this chaos the app is being deveoped.

<!-- Design Workflow -->

## Design Workflow

The App is being created while keeping in mind that a user from any part of the world can access the app as the dish variety is humongous in nature.

### The below are the some images of the app so that you can gauge the app more precisely

| Data fetching                                                                                                  | Main Screen                                                                                                                  | Searching                                                                                            |
| -------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------- |
| ![Data fetching](https://github.com/Jatin-Shihora/Recipe-App/blob/main/Recipe%20App%20Images/First%20load.png) | ![Main Screen](https://github.com/Jatin-Shihora/Recipe-App/blob/main/Recipe%20App%20Images/Main%20screen%20with%20chips.png) | ![Searching](https://github.com/Jatin-Shihora/Recipe-App/blob/main/Recipe%20App%20Images/typing.png) |

#### Using Fast search tags

| Fast search load                                                                                                           | Dessert tag                                                                                                    | Donut tag                                                                                                  |
| -------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------- |
| ![Fast search load](https://github.com/Jatin-Shihora/Recipe-App/blob/main/Recipe%20App%20Images/Dessert%20chip%20load.png) | ![Dessert tag](https://github.com/Jatin-Shihora/Recipe-App/blob/main/Recipe%20App%20Images/Dessert%20chip.png) | ![Donut tag](https://github.com/Jatin-Shihora/Recipe-App/blob/main/Recipe%20App%20Images/Donut%20chip.png) |

#### App in landscape mode

| Data fetching                                                                                                    |
| ---------------------------------------------------------------------------------------------------------------- |
| ![Data fetching](https://github.com/Jatin-Shihora/Recipe-App/blob/main/Recipe%20App%20Images/Landscape_load.png) |

| Main Screen                                                                                                    |
| -------------------------------------------------------------------------------------------------------------- |
| ![Main Screen](https://github.com/Jatin-Shihora/Recipe-App/blob/main/Recipe%20App%20Images/Landscape_Main.png) |

| Searching                                                                                                         |
| ----------------------------------------------------------------------------------------------------------------- |
| ![Donut tag](https://github.com/Jatin-Shihora/Recipe-App/blob/main/Recipe%20App%20Images/Landscap_donut_chip.png) |

<!-- CONTRIBUTING -->

## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request

### **Note** :

Make sure you push only those files that you have changed .

<!-- LICENSE -->

## License

```
Copyright 2022 Jatin C Shihora
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
   http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```

<!-- CONTACT -->

## Contact

Feel free to contact if you want to discus some ideas or issues .I will be happy to hear you all.

Linkedin(Jatin Shihora) - [https://www.linkedin.com/in/jatin-shihora/](https://www.linkedin.com/in/your_username/)

Mail - jatinshihora0123@gmail.com

Project Link: [https://github.com/Jatin-Shihora/Recipe-App](https://github.com/your_username/repo_name)

<!-- ACKNOWLEDGEMENTS -->

## Acknowledgements

- [ Apache License 2.0](http://www.apache.org/licenses/)
- [Official website of Andorid developers](https://developer.android.com/)
- [Kotlin](https://kotlinlang.org/docs/android-overview.html)
- [Font Awesome](https://fontawesome.com)
- [Icons8](https://icons8.com/)

<!-- MARKDOWN LINKS & IMAGES -->
<!-- https://www.markdownguide.org/basic-syntax/#reference-style-links -->
