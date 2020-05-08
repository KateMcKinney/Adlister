<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Welcome to my site!" />
    </jsp:include>
    <style>
         body {
            background-color: #cbffa8;
        }
         #face {
             position: fixed;
             height: 500px;
             width: 500px;
             margin-left: 29%;
             margin-bottom: 45%;
             background: #B9EB8D;
             border-radius: 50%;
         }
         #leftEye {
             position: absolute;
             height: 100px;
             width: 100px;
             background: #277331;
             border-top-left-radius: 55%;
             border-top-right-radius: 55%;
             border-bottom-left-radius: 75%;
             border-bottom-right-radius: 75%;
             margin-left: 19%;
             margin-top: 10%;
             animation: blinky 2s;
             animation-iteration-count: infinite;
         }
         @keyframes blinky {
             0%{
                 transform: scaleY(0);
             }
             25%{
                 transform: scaleY(-1);
             }
             50%{
                 transform: scaleY(-1);
             }
             75%{
                 transform: scaleY(-1);
             }
             100%{
                 transform: scaleY(0);
             }
         }
         #rightEye {
             position: absolute;
             height: 100px;
             width: 100px;
             background: #277331;
             border-top-left-radius: 55%;
             border-top-right-radius: 55%;
             border-bottom-left-radius: 75%;
             border-bottom-right-radius: 75%;
             margin-left: 60%;
             margin-top: 10%;
             animation: blinky 2s;
             animation-iteration-count: infinite;
         }
         #nose {
             position: absolute;
             display: block;
             width: 120px;
             height: 180px;
             background: #277331;
             border-radius: 50% 50% 50% 50% / 60% 60% 40% 40%;
             margin-left: 38%;
             margin-top: 25%;
         }
         #mouth {
             position: absolute;
             background: #277331;
             width: 200px;
             height: 100px;
             border-top-left-radius: 10%;
             border-top-right-radius: 10%;
             border-bottom-left-radius: 50%;
             border-bottom-right-radius: 50%;
             margin-left: 30%;
             margin-top: 65%;
             animation: slidey 2s;
             animation-iteration-count: infinite;
         }
         @keyframes slidey {
             0%{
                 transform: scale(.2);
             }
             25%{
                 transform: scale(.4);
             }
             50%{
                 transform: scale(.6);
             }
             75%{
                 transform: scale(.4);
             }
             100%{
                 transform: scale(.2);
             }
         }
         span {
             color: #fff;
             margin-left: 35%;
             margin-top: 10%;
             font-size: 2em;
         }
         #leftHand {
             position: fixed;
             height: 200px;
             width: 220px;
             background: #0E6B2A;
             margin-left: 14%;
             margin-top: 15%;
             border-top-left-radius: 35%;
             border-top-right-radius: 35%;
             border-bottom-left-radius: 35%;
             border-bottom-right-radius: 35%;
             animation: jab 2s;
             animation-iteration-count: infinite;
         }
         @keyframes jab {
             0%{
                 transform: scale(1);
             }
             50%{
                 transform: scale(1.5);
             }
             100%{
                 transform: scale(1);
             }
         }
         #Lthumb {
             position: absolute;
             height: 55px;
             width: 55px;
             background: #0E6B2A;
             border-radius: 50%;
             margin-left: 85%;
             margin-top: 45%;
         }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />
    <div class="container">
        <h1>GERG'S LIST!</h1>

        <div id="face">
            <div id="leftEye"></div>
            <div id="rightEye"></div>
            <div id="nose"></div>
            <div id="mouth"></div>
        </div>
        <div id="leftHand">
            <span>ADS</span>
            <div id="Lthumb"></div>
        </div>

    </div>
</body>
</html>
