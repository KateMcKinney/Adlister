<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Viewing All The Ads" />
    </jsp:include>
    <style>
        #face {
            height: 500px;
            width: 500px;
            background: teal;
            border-top-left-radius: 55%;
            border-top-right-radius: 55%;
            border-bottom-left-radius: 55%;
            border-bottom-right-radius: 55%;
            position: fixed;
            margin-bottom: 50%;
            z-index: -1;
            opacity: .5;
        }

        #leftEye {
            height: 100px;
            width: 100px;
            background: red;
            position: absolute;
            margin-left: 15%;
            margin-top: 25%;
            border-top-left-radius: 25%;
            border-top-right-radius: 25%;
            border-bottom-left-radius: 25%;
            border-bottom-right-radius: 25%;
            animation: leftblink 7s;
            animation-iteration-count: infinite;
            z-index: -1;
            opacity: .5;
        }

        @keyframes leftblink {
            0%{
                transform: scaleY(0);
            }
            25%{
                transform: scaleY(-.5);
            }
            50%{
                transform: scaleY(-1);
            }
            75%{
                transform: scaleY(-.5);
            }
            100%{
                transform: scaleY(0);
            }
        }

        #rightEye {
            height: 100px;
            width: 100px;
            background: red;
            position: absolute;
            margin-left: 65%;
            margin-top: 25%;
            border-top-left-radius: 25%;
            border-top-right-radius: 25%;
            border-bottom-left-radius: 25%;
            border-bottom-right-radius: 25%;
            animation: rightblink 7s;
            animation-iteration-count: infinite;
            z-index: -1;
            opacity: .5;
        }

        @keyframes rightblink {
            0%{
                transform: scaleY(0);
            }
            25%{
                transform: scaleY(-.5);
            }
            50%{
                transform: scaleY(-2);
            }
            75%{
                transform: scaleY(-.5);
            }
            100%{
                transform: scaleY(0);
            }
        }

        #mouth {
            height: 7px;
            width: 300px;
            background: red;
            position: absolute;
            margin-left: 25%;
            margin-top: 60%;
            border-bottom-left-radius: 55%;
            border-bottom-right-radius: 100%;
            border-top-right-radius: 100%;
            z-index: -1;
            opacity: .5;
        }

        #spaceinvader {
            box-shadow: 0 0 0 1em #6ADF02,
            0 1em 0 1em #6ADF02,
            -2.5em 1.5em 0 .5em #6ADF02,
            2.5em 1.5em 0 .5em #6ADF02,
            -3em -3em 0 0 #6ADF02,
            3em -3em 0 0 #6ADF02,
            -2em -2em 0 0 #6ADF02,
            2em -2em 0 0 #6ADF02,
            -3em -1em 0 0 #6ADF02,
            -2em -1em 0 0 #6ADF02,
            2em -1em 0 0 #6ADF02,
            3em -1em 0 0 #6ADF02,
            -4em 0 0 0 #6ADF02,
            -3em 0 0 0 #6ADF02,
            3em 0 0 0 #6ADF02,
            4em 0 0 0 #6ADF02,
            -5em 1em 0 0 #6ADF02,
            -4em 1em 0 0 #6ADF02,
            4em 1em 0 0 #6ADF02,
            5em 1em 0 0 #6ADF02,
            -5em 2em 0 0 #6ADF02,
            5em 2em 0 0 #6ADF02,
            -5em 3em 0 0 #6ADF02,
            -3em 3em 0 0 #6ADF02,
            3em 3em 0 0 #6ADF02,
            5em 3em 0 0 #6ADF02,
            -2em 4em 0 0 #6ADF02,
            -1em 4em 0 0 #6ADF02,
            1em 4em 0 0 #6ADF02,
            2em 4em 0 0 #6ADF02;
            background: transparent;
            position: absolute;
            width: 1em;
            height: 1em;
            overflow: hidden;
            margin: 50px 0 70px 65px;
            margin-left: 55%;
            margin-top: 25%;
            animation: slidey 7s;
            animation-iteration-count: infinite;
            z-index: -1;
        }

        @keyframes slidey {
            0%{
                transform: translate3d(0em, 0em, 0em);
            }
            20%{
                transform: translate3d(0em, -5em, 0em);
            }
            40%{
                transform: translate3d(0em, -10em, 0em);
            }
            60%{
                transform: translate3d(0em, -15em, 0em);
            }
            80%{
                transform: translate3d(0em, -5em, 0em);
            }
            100%{
                transform: translate3d(0em, 0em, 0em);
            }
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />

<div class="container">
    <h1>BEST ADS YOU'LL FIND IN TOWN:</h1>

    <c:forEach var="ad" items="${ads}">
        <div class="col-md-6">
            <h2><a href="/ad?id=${ad.id}">${ad.title}</a></h2>
            <p>${ad.description}</p>
        </div>
    </c:forEach>
    <div id="face">
        <div id="rightEye"></div>
        <div id="leftEye"></div>
        <div id="mouth"></div>
    </div>
    <div id="spaceinvader"></div>
</div>

</body>
</html>
