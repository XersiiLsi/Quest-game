# Project-Quest

Well, I did this big project🥳. 
I gained a lot of experience working with html, css, js, jsp, servlets and of course java.

For start:
Local server tomcat10
Ide for start


Well, let's start with parsing the internal code (java server)

The project has created the structure of a quest game, let's go through the classes. We have a mainChapter folder in which there are classes, enums, which are combined into a hierarchy, for example, take my favorite quality folder, which contains three enums called BadSkills, GoodSkills, Phobias.

then, in the mainCharacter folder itself, I created a Feature class that created sheets for each enum and randomly selected values ​​from there. Then I added getters to these sheets for correct operation and eventually got a ready-made class, which was added directly to Person.class and was tailored to return skill values ​​in a given situation

This is exactly the structure I have

Well, now we'll talk about Person.class. This class is the main class of the entire folder, it returns values ​​directly to jsp when it is requested. The person class is skeleton.class, so it can only be created once during the entire operation of the server, I know, it’s such an idea, I’m just practice ツ

Now let's move on to our webapp, oh, there was a lot of work. If you start the server and go to the page, you will see how many effects there are on it. Some effects were made in a css file, some in js code. I generated the images using the midjorney neural network, and it turned out very interesting. Unfortunately, automatic redirection does not work on this page, so you can see the <a>Click me<\a> transition at the top. The reason for this is an unsecured connection that does not allow redirection.

Click on the redirect and go to the quest itself. In it, the pictures change depending on the question, each button is a $.ajax request to the server, which transmits data about the button pressed and the current Count. The page itself was made on a web servlet, I can say that it was very inconvenient 😅

Let's move on to our servlet; a post request is sent to the server via url(/controller) with data about the button pressed and the current count element in the form of a json file. With the help of Gson, the data on the server is deciphered and added to a specially designated class. Afterwards, we assign values ​​from this class to our variables and begin checking. There is a pass through the pressed button and through the current count element, after similarities are found, we use Gson parsing string element to json string and return this data to the client.

on its part, the client decrypts this data and receives a value about the change in the current question, picture and game state
using code written in js we change these values ​​on the page

that's all! I hope you enjoyed this project!🎉
