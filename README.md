# Template Project

This is the very base kotlin project template that I use for upcoming projects.
It includes some interesting architecture- and implementation presets that can be used or customized for your needs.

To show how a default setup may look I implemented a simple network request that returns the constributor of this template from github on first app opening. The response is stored in a local database by using 'Room' and after that has been done, the result is delivered by the database and no network call is requested anymore.
(Hint: There is no database update implemented for now)

For now, no tests are included, but i will add some default dummy unit- and android tests to show how it could be done.

As you can see, it's just a small example but I tried to implement all that things I dont't want to write again every time when i start a new Project ;)

Feel free to contact me if something is incomprehensible or you have suggestions for improvement.


## Architectural Pattern
 * [MVVM](https://de.wikipedia.org/wiki/Model_View_ViewModel)
 
 
## External Libraries
 * [Retrofit](https://square.github.io/retrofit/)
 * [Dagger2](https://google.github.io/dagger/)
 * [Room](https://developer.android.com/topic/libraries/architecture/room.html)


## Evironment

```
Android Studio 3.0 
Build #AI-171.4408382, built on October 20, 2017
JRE: 1.8.0_152-release-915-b08 x86_64
JVM: OpenJDK 64-Bit Server VM by JetBrains s.r.o
Mac OS X 10.12.3
```