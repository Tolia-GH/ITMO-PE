<%--
  Created by IntelliJ IDEA.
  User: 2398768715qq.com
  Date: 2023/2/16
  Time: 12:43
  To change this template use File | Settings | File Templates.
--%>
<% String path = request.getContextPath(); %>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" %>
<html>
  <head>
    <meta charset = http-equiv="Content-Type" content="text/html; charset=utf-8">
    <title>Студент: Чжоу Хунсян P32131 Вариант: 13111</title>
    <link rel="stylesheet" href="css/indexStyle.css">
    <script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
    <script type="text/javascript"> <%@include file='js/canvasDrawer.js' %> </script>
    <script type="text/javascript"> <%@include file='js/clientHandler.js' %> </script>
  </head>

  <body onload="init()">
  <center>
    <div id="header">
      <h1>Lab 2</h1>
      <h2>Студент: Чжоу Хунсян P32131</h2>
      <h2>Вариант: 13111</h2>
    </div>
    <div id="form">
      <table id="formTable">
        <tr>
          <td>
            <fieldset class="InputX">
              <legend class="InputX">
                Please choose value of X<span class = "required">*</span>
              </legend>

              <label>
                <input type="radio" onclick="setRadioValue(this)" value="-3" name="X">-3
                <input type="radio" onclick="setRadioValue(this)" value="-2" name="X">-2
                <input type="radio" onclick="setRadioValue(this)" value="-1" name="X">-1
                <input type="radio" onclick="setRadioValue(this)" value="0" name="X">0
                <input type="radio" onclick="setRadioValue(this)" value="1" name="X">1
                <input type="radio" onclick="setRadioValue(this)" value="2" name="X">2
                <input type="radio" onclick="setRadioValue(this)" value="3" name="X">3
                <input type="radio" onclick="setRadioValue(this)" value="4" name="X">4
                <input type="radio" onclick="setRadioValue(this)" value="5" name="X">5
              </label>

              <p id="errorX" class="errorMessage"></p>
            </fieldset>

            <fieldset>
              <legend class="inputY">
                Please input value of Y<span class = "required">*</span>
              </legend>

              <label>
                <input type="text" placeholder="from -5 to 5" id="Y" name = "Y">
              </label>

              <p id="errorY" class="errorMessage"></p>
            </fieldset>

            <fieldset>
              <legend class="InputR">
                Please choose value of R<span class = "required">*</span>
              </legend>

              <label>
                <input type="radio" onclick="setRadioValue(this)" value="1" name="R">1
                <input type="radio" onclick="setRadioValue(this)" value="2" name="R">2
                <input type="radio" onclick="setRadioValue(this)" value="3" name="R">3
                <input type="radio" onclick="setRadioValue(this)" value="4" name="R">4
                <input type="radio" onclick="setRadioValue(this)" value="5" name="R">5
              </label>

              <p id="errorR" class="errorMessage"></p>
            </fieldset>

            <div>
              <form method="GET" id="hiddenForm" action="<%=path%>/Controller">
                <input type="hidden" name="x_hidden" id="x_hidden_id">
                <input type="hidden" name="y_hidden" id="y_hidden_id">
                <input type="hidden" name="r_hidden" id="r_hidden_id">
              </form>
            </div>

          </td>
          <td id="graph">
            <div class="graphic centered">
              <canvas id="canvas" onclick="clickCanvas()" width="300" height="300">canvas load fail!</canvas>
            </div>
          </td>


        </tr>

      </table>

      <div class="submit">
        <input type="button" class="submitButton" value="Submit" onclick="submitData()">
      </div>
    </div>

    <br>

    <jsp:include page="result.jsp" />
  </center>


  </body>
</html>
