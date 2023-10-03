<%--
  Created by IntelliJ IDEA.
  User: zheka
  Date: 06.09.2023
  Time: 20:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="mainCharacter.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%Person person = Person.getInstance();%>

<html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>History</title>
    <link rel="stylesheet" href="css/style.css">
</head>

<body onpageshow="perfomance()">
 <div class="css-typing">
    <div id="title">
        <h1 class="type-animation" id="name" style="--typewriterCharacters: 1; --typewriterSpeed: 5s;">
            <% out.print(person.name());%>
        </h1>
        <h2 class="type-animation" id="profession" style="--typewriterCharacters: 8; --typewriterSpeed: 3s;">
            <% out.print(person.profession());%>
        </h2>
        <a href="http://localhost:8080/quest">Click me</a>
    </div>
        <p id="smooth-effect"><% out.print(person.history());%></p>
        <h4 class="subtitle-glow">Good skills: <% out.print(person.goodSkills());%></h4>
        <h4 class="subtitle-glow">Bad skills: <% out.print(person.badSkills());%></h4>
        <h4 class="subtitle-glow">Phobias: <% out.print(person.phobias());%></h4>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script src="js/main.js"></script>
    <script src="js/imageChanger.js"></script>
</body>
</html>
