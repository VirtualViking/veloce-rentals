<%@ page import="com.example.velocerentals.domain.models.Vehicle" %>
<%@ page import="com.example.velocerentals.domain.dtos.VehicleOutDTO" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Detalle vehículo</title>
    <link rel="stylesheet" href="styles.css">
</head>
<style>
    .detail__container{
        display: flex;
        justify-content: center;
        align-items: center;
        margin-top: 50px;
        gap: 3rem;
    }

    .detail__image img{
        width: 500px;
        height: 700px;
    }

    .detail__info{
        display: flex;
        flex-direction: column;
        gap: 1rem;
        height: 100%;
    }
</style>
<body>
<nav>
    <ul>
        <div >
            <img src="https://i.ibb.co/KxW1WFT/logo.png" />
        </div>
        <div class="ul__container">
            <li><a href="home">Inicio</a></li>
            <%
                if (request.getAttribute("username") == null) {
            %>
            <li><a href="login">Login</a></li>
            <li><a href="register">Register</a></li>
            <%
            } else {
            %>
            <li><a href="">Bienvenido,<span> ${username}</span> </a></li>
            <li><a href="logout">Cerrar sesión</a></li>
            <%
                }
            %>

        </div>
    </ul>
</nav>
<main>
    <div class="detail__container">
        <%VehicleOutDTO vehicle = (VehicleOutDTO) request.getAttribute("vehicle"); %>
        <div class="detail__image">
            <img src="<%= vehicle.urlImage() %>" alt="<%= vehicle.brand() %> <%= vehicle.model() %>">
        </div>
            <div class="detail__info">
                <h2><%= vehicle.brand() %> <%= vehicle.model() %></h2>
                <p><%= vehicle.rentalPrice() %>$/día</p>
                <button>Alquilar </button>
            </div>
    </div>
</main>
</body>
</html>
