# Super Hero App
##Description
This app is test app for Westpoint UK, author: Elcio Abrahão, Nov/2019
##Features
The features described below apper on the order of the source folders of the repository.
####Architecture
- Kotlin: less code, well organized, no bolierplate, current Android standard language.
- Android Jetpack (Databinding, ViewModel, LiveData): ultimate Google recomendation, native libs, less code do more.
- MVVM: simple to organize code, could use MVI or MVP as it is a small app.
- Uncle Bob Clean Architecture: standard to name vars and methods, keep code organized (source folders) with high quality and easy maintenance.
- Kotlin coroutines: make assynk calls native for Kotlin, easy integrated with retrofit2, very fast and small footprint.
- Dependecy Injection: simple solution, no need to use big libs as Dagguer2 or Koin.
- ViewModel: keep data on screen turn, avoid memory leaks.
####Network
- Retrofit2: realy an standard for REST calls, avoid a lot of boilerplate, small implementation when using Kotlin coroutines, nice Logs.
####Data
- Repostiroty pattern: keep code as uncle boob clean code standars, easy to test, allow use Room to cache network data if needed (not implemented on the example).
####UI
- Simple activity with fragment, data binding with the XML layouts.
- Androidx libs: new standard for views.
- Adapter claas link ViewHolder thru databinding, less boilerplate, clean code on the fragment, easy to maintenance.
####ViewModel
- Very simple code, no need of AndroidRx or RXJava, using LiveData instead.
- Elegant solution to sort data and select only the first 3 super heros with only one line of code:
            val list: List<Hero> = retrivedHeroes.heroes.sortedWith(compareBy({it.score})).sortedByDescending { it.score }.dropLast(1)
####Tests
- UnitTest: not implemented.
- Integration Test: Expresso: simple wake up the main activity, swipe 6 times, check if the list changes.
- Custom Matcher for swipe refreshing.
- Custom Matcher for time delay.
####Screenshots
![](https://elcioabrahao.github.io/super1.jpg)
> 2006 ranking

![](https://elcioabrahao.github.io/super2.jpg)
> 2009 ranking

![](https://elcioabrahao.github.io/super3.jpg)
> 2012 ranking


##### Copyright 2019 - Elcio Abrahão - MIT Licence
