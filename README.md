geostats
========

Show user geographical statistics from social (demography of countries), physical (rivers, mountains, ...), meteorological (rain, hurricane, ...) areas, stats of extraction of mineral resources on Earth, ...

App requires two external libraries for launch:
- ActionBarSherlock [http://actionbarsherlock.com/] and
- Android-ViewPagerIndicator [http://viewpagerindicator.com/]

Implementation in Eclipse
If you’re using the Eclipse Development Environment with the ADT plugin version 0.9.7 or greater
you can include ActionBarSherlock and Android-ViewPagerIndicator as a library project.
Create a new Android project in Eclipse using the /actionbarsherlock folder for ActionBarSherlock
and /library folder for Android-ViewPagerIndicator as the existing source.
Then, in your project properties, add the created project under the ‘Libraries’ section of the ‘Android’ category.

There are also another ways to leverage ActionBarSherlock in your projects:
- ActionBarSherlock [http://actionbarsherlock.com/usage.html]

All versions of the android support libraries must be the same at this time. In case that there will be found
not identical versions of android-support-v4.jar in the dependency list, update them with Android Tools > Add Support Library
in Eclipse for all projects: ActionBarSherlock, Android-ViewPagerIndicator and geostats.