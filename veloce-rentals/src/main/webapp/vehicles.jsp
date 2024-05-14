
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="com.example.velocerentals.domain.dtos.VehicleOutDTO" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="styles.css">

</head>
<style>
    section{
        display: flex;
        flex-direction: column;
        align-items: center;
        height: 100%;
        gap: 3rem;
    }
    .vehicles__container{
        display:flex;
        flex-wrap: wrap;
        flex-direction: row;
        justify-content: center;
        gap:2rem;
    }
    .vehicle__card{
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        width: 300px;
        padding: 10px;
        transition: all 0.3s;
    }
    .vehicle__card h2{
        font-size: 1.5rem;
        margin: 0;
    }
    .vehicle__card:hover{
        transform: scale(1.1);
    }
    .vehicle__card img{
        object-fit: cover;

        width: 300px;
        height: 250px;
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
  <section>
      <header>
          <h1>Vehículos</h1>
      </header>
    <div class="vehicles__container">
            <%
            List<VehicleOutDTO> vehicles = (List<VehicleOutDTO>) request.getAttribute("vehicles");
            for (VehicleOutDTO vehicle : vehicles) {
            %>
            <div class="vehicle__card">
            <img src="<%= vehicle.urlImage()%>" />
            <h2><%= vehicle.brand() %> <%= vehicle.model() %></h2>
            <p><%= vehicle.type() %></p>
            <p><%= vehicle.rentalPrice() %> $</p>
            <a style="color: #a47226" href="vehicles?id=<%= vehicle.id()%>">Ver más</a>
            </div>
            <%
            }
            %>
    </div>
  </section>

</main>

</body>
</html>
