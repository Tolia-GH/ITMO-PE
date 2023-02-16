<%--
  Created by IntelliJ IDEA.
  User: 2398768715qq.com
  Date: 2023/2/16
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <meta charset = "UTF-8">
    <title>Студент: Чжоу Хунсян P32131 Вариант: 13111</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
  </head>

  <body>

    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script src="js/clientHandler.js"></script>

    <h1>
      Студент: Чжоу Хунсян P32131 <br> Вариант: 13111
    </h1>

    <h2>
      Lab 2
    </h2>

    <form id = "pointForm" class="dataForm" method = "get">
      <fieldset>
        <legend class="InputX">
          Please choose value of X<span class = "required">*</span>
        </legend>
        <div class = "InputX">
          <label>
            <input type="radio" value="-3" name="X">-3
            <input type="radio" value="-2" name="X">-2
            <input type="radio" value="-1" name="X">-1
            <input type="radio" value="0" name="X">0
            <input type="radio" value="1" name="X">1
            <input type="radio" value="2" name="X">2
            <input type="radio" value="3" name="X">3
            <input type="radio" value="4" name="X">4
            <input type="radio" value="5" name="X">5
          </label>
        </div>
      </fieldset>

      <fieldset>
        <legend class="inputY">
          Please input value of Y<span class = "required">*</span>
        </legend>
        <div class = "inputY">
          <label>
            <input type="text" placeholder="from -3 to 3" id="valueOfY" name = "Y">
          </label>
        </div>
      </fieldset>

      <fieldset>
        <legend class="InputR">
          Please choose value of R<span class = "required">*</span>
        </legend>
        <div class = "InputR">
          <label>
            <input type="radio" value="1" name="R">1
            <input type="radio" value="2" name="R">2
            <input type="radio" value="3" name="R">3
            <input type="radio" value="4" name="R">4
            <input type="radio" value="5" name="R">5
          </label>

        </div>
      </fieldset>

      <br>

      <div class="submit">
        <input type="submit" class="submitButton" value="Submit">
      </div>

    </form>
  </body>
</html>
