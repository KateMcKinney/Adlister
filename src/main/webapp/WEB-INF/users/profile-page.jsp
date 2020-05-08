<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="Your Profile" />
    </jsp:include>

    <style>
        #face {
            position: fixed;
            height: 500px;
            width: 500px;
            border-radius: 50%;
            background: #6161DC;
        }

        #rightEye {
            position: relative;
            height: 100px;
            width: 100px;
            border-top-left-radius: 35%;
            border-top-right-radius: 35%;
            border-bottom-left-radius: 50%;
            border-bottom-right-radius: 50%;
            background: #5A93CD;
            margin-left: 22%;
            margin-top: 29%;
            animation: blinky 5s;
            animation-iteration-count: infinite;
        }

        @keyframes blinky {
            0%{
                transform: scaleY(1);
            }
            25%{
                transform: scaleY(-.25);
            }
            50%{
                transform: scaleY(-.5);
            }
            75%{
                transform: scaleY(-.25);
            }
            100%{
                transform: scaleY(1);
            }
        }

        #leftEye {
            position: relative;
            height: 100px;
            width: 100px;
            border-top-left-radius: 35%;
            border-top-right-radius: 35%;
            border-bottom-left-radius: 50%;
            border-bottom-right-radius: 50%;
            background: #5A93CD;
            margin-top: -20%;
            margin-left: 55%;
            animation: blinky 5s;
            animation-iteration-count: infinite;
        }

        #nose {
            position: relative;
            display: block;
            width: 120px;
            height: 180px;
            background: #084A8B;
            border-radius: 50% 50% 50% 50% / 60% 60% 40% 40%;
            margin-left: 36%;
            margin-top: 2%;
        }

        #nose:hover{
            animation: bounce 1s;
        }

        @keyframes bounce {
            0%, 20%, 60%, 100% {
                -webkit-transform: translateY(0);
                transform: translateY(0);
            }
            40% {
                -webkit-transform: translateY(-20px);
                transform: translateY(-20px);
            }
            80% {
                -webkit-transform: translateY(-20px);
                transform: translateY(-10px);
            }
        }

        #mouth {
            position: relative;
            width: 50px;
            height: 50px;
            border-radius: 50%;
            background: #fff;
            margin-bottom: 35%;
            margin-left: 25%;
            animation: mouthy .5s;
            animation-iteration-count: infinite;
        }

        @keyframes mouthy {
            0%{
                transform: scale(1);
            }
            20%{
                transform: scale(.75);
            }
            40%{
                transform: scale(.25);
            }
            60%{
                transform: scale(.5);
            }
            80%{
                transform: scale(.25);
            }
            100%{
                transform: scale(1);
            }
        }

        #hand {
            position: absolute;
            height: 100px;
            width: 100px;
            background: #6161DC;
            border-radius: 50%;
            margin-left: 40%;
            margin-top: 17%;
            animation: rotate 3s;
            animation-iteration-count: infinite;
        }

        @keyframes rotate {
        0%{transform: rotate(360deg);}
        20%{background-color: #5A93CD;}
        40%{background-color: #fff;}
        80%{background-color: #084A8B;}
        100%{transform: rotate(360deg);}
        }

        #finger1 {
            position: relative;
            height: 75px;
            width: 25px;
            background: #6161DC;
            margin-top: -65%;
            transform: rotate(-25deg);
            border-top-left-radius: 38%;
            border-top-right-radius: 38%;
            border-bottom-left-radius: 38%;
            border-bottom-right-radius: 38%;
            animation: finga 3s;
            animation-iteration-count: infinite;
        }

        @keyframes finga {
            20%{background-color: #5A93CD;}
            40%{background-color: #fff;}
            80%{background-color: #084A8B;}
        }

        #finger2 {
            position: relative;
            height: 75px;
            width: 25px;
            background: #6161DC;
            margin-top: -75%;
            margin-left: 40%;
            transform: rotate(29deg);
            border-top-left-radius: 38%;
            border-top-right-radius: 38%;
            border-bottom-left-radius: 38%;
            border-bottom-right-radius: 38%;
            animation: finga 3s;
            animation-iteration-count: infinite;
        }
    </style>
</head>
<body>
    <jsp:include page="/WEB-INF/partials/navbar.jsp" />

    <div class="container">
        <h1>Welcome, ${sessionScope.user}!</h1>

        <div id="face">
            <div id="rightEye"></div>
            <div id="leftEye"></div>
            <div id="nose"></div>
            <div id="mouth"></div>
        </div>
        <div id="hand">
            <div id="finger1"></div>
            <div id="finger2"></div>
        </div>
    </div>

</body>
</html>
